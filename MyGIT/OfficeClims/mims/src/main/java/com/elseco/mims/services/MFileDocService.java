package com.elseco.mims.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.elseco.mims.client.CheckOutRequest;
import com.elseco.mims.client.Files;
import com.elseco.mims.client.Item;
import com.elseco.mims.client.MFSearchDocResponse;
import com.elseco.mims.client.MFileRestClient;
import com.elseco.mims.client.PermanentUploadResponse;
import com.elseco.mims.client.UploadRequest;
import com.elseco.mims.client.UploadResponse;
import com.elseco.mims.model.DocInfo;
import com.elseco.mims.model.MfileMetaData;
import com.elseco.mims.model.MimsResponse;
import com.elseco.mims.transformer.SearchDocTransformer;
import com.serole.core.exception.FileNotFoundException;
import com.serole.core.exception.MFileGenericException;
import com.serole.core.exception.MFileServerException;
import com.serole.core.utils.CommonCoreUtil;

/**
 * 
 * @author vadivel
 *
 */
@Configuration
public class MFileDocService {
	private static final Logger LOG = LoggerFactory.getLogger(MFileDocService.class);
	private static final String DOC_UPDATE_ERR_MSG = "Invalid File-ID/Object-Id/Title/Document Type(file-extention)";
	@Autowired
	private MFileRestClient restClient;

	@Autowired
	private SearchDocTransformer transformer;

	@Value("${mfile.server.rest.downlodUrl}")
	private String downlodBaseUrl;

	@Value("${mfile.server.rest.deleteUrl}")
	private String crudBaseUrl;

	public MimsResponse search(final String fileName) {
		LOG.info("Searching the document {}", fileName);
		final MFSearchDocResponse mfSearchDocResponse = restClient.searchDocByTitle(fileName);

		if (mfSearchDocResponse != null && mfSearchDocResponse.getItems().size() >= 1) {

			for (final Item item : mfSearchDocResponse.getItems()) {
				final Files[] files = item.getFiles();
				if (files.length == 0) {
					continue;
				}
				final String escapedName = files[0].getEscapedName();
				LOG.info("Filename {} and escaped name: {}", fileName, escapedName);
				if (escapedName == null) {
					continue;
				}
				if (escapedName.equals(fileName)) {
					final Map<String, Object> data = new HashMap<>();
					final DocInfo docInfo = transformer.transform(item);
					docInfo.setEscapedName(escapedName);
					data.put("DocInfo", docInfo);
					data.put("downloadUrl", constructDownloadUrl(docInfo));
					data.put("deleteUrl", constructDeleteUrl(docInfo));
					final MimsResponse mimsResponse = new MimsResponse(true, "File found successfully");
					mimsResponse.setData(data);
					return mimsResponse;
				}
			}

		}

		throw new MFileGenericException(
				String.format("Requested file: %s not available in the mfile server", fileName));

	}

	public Map<String, Object> searchByProperties(final Map<String, String> requestQueryParams) {
		LOG.info("Searching the document... requestQueryParams{}", requestQueryParams);
		if (requestQueryParams == null || requestQueryParams.isEmpty()) {
			throw new MFileServerException("Query parameters not found in the url");
		}

		final String queryParams = constructQueryParams(requestQueryParams);
		return restClient.searchDocByProperties(queryParams);

	}

	private String constructQueryParams(final Map<String, String> requestQueryParams) {
		final StringBuilder queryParamsBuilder = new StringBuilder();
		for (final String key : requestQueryParams.keySet()) {
			final String value = requestQueryParams.get(key);
			LOG.info("Key : {}  Value: {}", key, value);
			queryParamsBuilder.append(key);
			queryParamsBuilder.append("=");
			queryParamsBuilder.append(value);
			queryParamsBuilder.append("&");

		}

		String queryParams = queryParamsBuilder.toString();
		if (queryParams.endsWith("&")) {
			queryParams = queryParams.substring(0, queryParams.length() - 1);
		}
		return queryParams;
	}

	public String constructDownloadUrl(final DocInfo docInfo) {

		final UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentContextPath().path("/mfile/download")
				.queryParam("objectType", docInfo.getObjectType()).queryParam("objectId", docInfo.getObjectId())
				.queryParam("objectVersion", docInfo.getObjectVersion()).queryParam("fileId", docInfo.getFileId())
				.queryParam("fileName", docInfo.getFileName()).queryParam("fileExtention", docInfo.getFileExtention())
				.build().encode();
		return uriComponents.toUriString();

	}

	/**
	 * 
	 * @param docInfo
	 * @return
	 */
	public String constructDeleteUrl(final DocInfo docInfo) {
		final UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentContextPath().path("/mfile/delete")
				.queryParam("objectType", docInfo.getObjectType()).queryParam("objectId", docInfo.getObjectId()).build()
				.encode();
		return uriComponents.toUriString();

	}

	public byte[] download(final DocInfo searchRequest) {
		LOG.info("Downloading the document {}", searchRequest.getFileName());
		final String url = constructMFileDownloadUrl(searchRequest, downlodBaseUrl);
		LOG.info("Full download url: {}", url);
		return restClient.download(url);
	}

	private String constructMFileDownloadUrl(final DocInfo searchRequest, final String downlodBaseUrl) {
		final StringBuilder downlodUrl = new StringBuilder(downlodBaseUrl);
		downlodUrl.append(CommonCoreUtil.BACK_SLASH);
		downlodUrl.append(searchRequest.getObjectType());
		downlodUrl.append(CommonCoreUtil.BACK_SLASH);
		downlodUrl.append(searchRequest.getObjectId());
		downlodUrl.append(CommonCoreUtil.BACK_SLASH);
		downlodUrl.append(searchRequest.getObjectVersion());
		downlodUrl.append(CommonCoreUtil.BACK_SLASH);
		downlodUrl.append("files");
		downlodUrl.append(CommonCoreUtil.BACK_SLASH);
		downlodUrl.append(searchRequest.getFileId());
		downlodUrl.append(CommonCoreUtil.BACK_SLASH);
		downlodUrl.append("content");

		return UriComponentsBuilder.fromHttpUrl(downlodUrl.toString()).build(true).toUriString();
	}

	public UploadResponse uploadTemp(final MultipartFile multipartFile) {

		LOG.info("Started to temp upload file {}", multipartFile.getOriginalFilename());
		final UploadResponse uploadResponse = restClient.uploadDocTemp(multipartFile, HttpMethod.POST);

		return uploadResponse;
	}

	public Map<String, Object> upload(final UploadRequest uploadRequest) {
		final com.elseco.mims.client.File file = uploadRequest.getFiles().get(0);
		LOG.info("Started to permanent upload title {} and extention {} ", file.getTitle(), file.getExtension());
		return restClient.upload(uploadRequest);

	}

	public Object updateMetaData(final List<MfileMetaData> updateMetaDataRequestList,
			final Map<String, Object> parameters) {

		LOG.info("Started updating meta-data parameters {} and updateMetaDataRequestList {} ", parameters,
				updateMetaDataRequestList);
		return restClient.updateMetaData(updateMetaDataRequestList, parameters);

	}

	public byte[] deleteService(final DocInfo searchRequest) {
		LOG.info("deleting the document {}", searchRequest.getFileName());
		final String url = constructMFileDeleteUrl(searchRequest, crudBaseUrl);
		LOG.info("Full delete url: {}", url);
		return restClient.delete(url);
	}

	private String constructMFileDeleteUrl(final DocInfo searchRequest, final String deleteBaseUrl) {
		final StringBuilder deleteUrl = new StringBuilder(deleteBaseUrl);
		deleteUrl.append(CommonCoreUtil.BACK_SLASH);
		deleteUrl.append(searchRequest.getObjectType());
		deleteUrl.append(CommonCoreUtil.BACK_SLASH);
		deleteUrl.append(searchRequest.getObjectId());
		deleteUrl.append(CommonCoreUtil.BACK_SLASH);
		deleteUrl.append("deleted");

		return UriComponentsBuilder.fromHttpUrl(deleteUrl.toString()).build(true).toUriString();
	}

	public PermanentUploadResponse updateDoc(final DocInfo searchRequest, final MultipartFile multipartFile) {

		LOG.info("updating the document {}", searchRequest.getFileName());

		try {
			final String checkOutUrl = constructMFileCheckoutUrl(searchRequest, crudBaseUrl);
			LOG.info("Checked out url: {}", checkOutUrl);
			final String fileName = multipartFile.getOriginalFilename();
			final String title = StringUtils.substringBefore(fileName, ".");
			final String extention = StringUtils.substringAfter(fileName, ".");
			CheckOutRequest checkOutRequest = new CheckOutRequest(2);
			PermanentUploadResponse response = restClient.checkOutIn(checkOutUrl, checkOutRequest);

			String tit = response.getTitle();
			Files file = response.getFiles().get(0);
			final String extn = file.getExtension();
			if (StringUtils.equals(extention, extn) && StringUtils.equals(tit, title)) {
				final String updateContentUrl = constructMFileUpdateUrl(searchRequest, crudBaseUrl);
				LOG.info("File content update url: {}", updateContentUrl);
				response = restClient.uploadUpdatedDoc(multipartFile, HttpMethod.PUT, updateContentUrl);
				LOG.info("File Upload content response: {}", response);

				tit = response.getTitle();
				file = response.getFiles().get(0);

				if (StringUtils.equals(extention, extn) && StringUtils.equals(tit, title)) {
					checkOutRequest = new CheckOutRequest(0);
					LOG.info("File Upload check in url: {}", response);
					response = restClient.checkOutIn(checkOutUrl, checkOutRequest);
					LOG.info("File Upload check in url: {}", response);
				} else {
					throw new FileNotFoundException(DOC_UPDATE_ERR_MSG);
				}

				LOG.info("File updatd successfully with the respone...{}", response);
			} else {
				LOG.info("File need to upload newly.....");
				throw new FileNotFoundException(DOC_UPDATE_ERR_MSG);
			}

			return response;
		} catch (final HttpClientErrorException e) {
			// TODO: handle exception
			final String errorMessage = e.getMessage();
			LOG.error("### Error due to {}", errorMessage);
			if (errorMessage.contains(String.valueOf(HttpStatus.NOT_FOUND.value()))
					|| errorMessage.contains(String.valueOf(HttpStatus.BAD_REQUEST.value()))) {
				throw new FileNotFoundException(DOC_UPDATE_ERR_MSG);
			}

			throw e;
		}
	}

	private String constructMFileCheckoutUrl(final DocInfo searchRequest, final String deleteBaseUrl) {
		final StringBuilder checkoutUrl = new StringBuilder(deleteBaseUrl);
		checkoutUrl.append(CommonCoreUtil.BACK_SLASH);
		checkoutUrl.append(searchRequest.getObjectType());
		checkoutUrl.append(CommonCoreUtil.BACK_SLASH);
		checkoutUrl.append(searchRequest.getObjectId());
		checkoutUrl.append(CommonCoreUtil.BACK_SLASH);
		checkoutUrl.append("latest");
		checkoutUrl.append(CommonCoreUtil.BACK_SLASH);
		checkoutUrl.append("checkedout");

		return UriComponentsBuilder.fromHttpUrl(checkoutUrl.toString()).build(true).toUriString();
	}

	private String constructMFileUpdateUrl(final DocInfo searchRequest, final String deleteBaseUrl) {
		final StringBuilder updateUrl = new StringBuilder(deleteBaseUrl);
		updateUrl.append(CommonCoreUtil.BACK_SLASH);
		updateUrl.append(searchRequest.getObjectType());
		updateUrl.append(CommonCoreUtil.BACK_SLASH);
		updateUrl.append(searchRequest.getObjectId());
		updateUrl.append(CommonCoreUtil.BACK_SLASH);
		updateUrl.append("files");
		updateUrl.append(CommonCoreUtil.BACK_SLASH);
		updateUrl.append(searchRequest.getFileId());
		updateUrl.append(CommonCoreUtil.BACK_SLASH);
		updateUrl.append("content");

		return UriComponentsBuilder.fromHttpUrl(updateUrl.toString()).build(true).toUriString();
	}
}
