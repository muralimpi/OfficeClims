package com.elseco.mims.client;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.elseco.mims.model.Login;
import com.elseco.mims.model.MfileMetaData;
import com.serole.core.exception.FileNotFoundException;
import com.serole.core.exception.FileUploadException;
import com.serole.core.exception.MFileGenericException;
import com.serole.core.exception.MFileServerException;
import com.serole.core.utils.CommonCoreUtil;
import com.serole.core.utils.CommonFileUtils;
import com.serole.core.utils.CommonJsonUtils;

/**
 * 
 * @author vadivel
 *
 */
@Component
@PropertySource({"application.yml", "file:${mimsConfigFileLocation}/${mimsConfigFileName}.yml"})
//@PropertySources{
	//	@PropertySource("classpath:application.yml"),
		//@PropertySource("file:${mimsConfigFileLocation}/${mimsConfigFileName}.yml")
//};
//PropertySource("file:///C:\\Users\\Serole_Dinesh\\Desktop\\Serolejava\\java-apps\\config\\mims_config.yml")
public class MFileRestClient {

	private static final Logger LOG = LoggerFactory.getLogger(MFileRestClient.class);
	private String username;
	private String password;
	private static String commonAuthToken;
	private static String vaultAuthToken;

	@Autowired
	private RestTemplate restTemplate;
	private String loginURL;

	private static final String FILES = "files";
	private static final String X_AUTHENTICATION = "X-Authentication";
	private static final String VALUE_TRUE_SOURCE = "\"Value\":\"true\"";
	private static final String VALUE_TRUE_DESTN = "\"Value\":true";

	@Value("${mfile.server.rest.searchDocUrl}")
	private String searchDocUrl;

	private String vaultLoginUrl;

	@Value("${mfile.server.rest.uploadUrl}")
	private String uploadUrl;

	@Value("${mfile.server.rest.tempUploadUrl}")
	private String tempUploadUrl;

	private String vaultName;

	@Value("${mfile.server.rest.quickSearchUrl}")
	private String quickSearchUrl;

	@Value("${mfile.server.rest.updateMetadataUrl}")
	private String updateMetadataUrl;

	@Autowired
    public MFileRestClient(@Value("${mfile.server.rest.username}") final String username,
			@Value("${mfile.server.rest.password}") final String password,
			@Value("${mfile.server.rest.loginUrl}") final String loginUri,
			@Value("${mfile.server.rest.vaultLoginUrl}") final String vaultLoginUrl,
			@Value("${mfile.server.rest.vaultName}") String vaultName) throws UnsupportedEncodingException {
		LOG.info("Started to create IprintMFileRestClient");
		this.restTemplate = new RestTemplate();
		this.username = username;
		this.password = password;
		this.vaultLoginUrl = vaultLoginUrl;
		this.loginURL = CommonCoreUtil.decodeUrl(loginUri);
		this.vaultName = vaultName;
	}

	public String commonLogin() {
		try {
			LOG.info("Server Authentication started with the url: {} and user: {}", this.loginURL, this.username);

			final Login data = restTemplate.postForObject(this.loginURL, new Login(this.username, this.password),
					Login.class);
			commonAuthToken = data.getValue();
			LOG.info("Common login token repsone: {}", commonAuthToken);
			return commonAuthToken;
		} catch (Exception e) {
			throw new MFileServerException("Unable to authorize MFileServer due to {}" + e.getMessage());
		}
	}

	private String vaultLogin() {
		try {

			if (StringUtils.isEmpty(commonAuthToken)) {
				commonAuthToken = commonLogin();
			}
			LOG.info("Vault Search with Authentication started with the url: {}", this.vaultLoginUrl);
			final HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add(X_AUTHENTICATION, commonAuthToken);

			final HttpEntity<String> requestEntity = new HttpEntity<String>("parameters", headers);

			final ResponseEntity<List<VaultSearchResponse>> responseEntity = restTemplate.exchange(vaultLoginUrl,
					HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<VaultSearchResponse>>() {
					});
			final List<VaultSearchResponse> vaultSearchs = responseEntity.getBody();
			for (final VaultSearchResponse search : vaultSearchs) {
				if (vaultName.trim().equalsIgnoreCase(search.getName().trim())) {
					vaultAuthToken = search.getAuthentication();
					break;
				}
			}

			if (vaultAuthToken == null) {
				throw new MFileServerException(
						String.format("Invalid authentication/valut %s is not found", vaultName));
			}
		} catch (Exception e) {
			LOG.error("There is an error due to {}", e);
			throw new MFileServerException("Unable to authorize MFileServer due to {}" + e.getMessage());
		}

		return vaultAuthToken;
	}

	public MFSearchDocResponse searchDocByTitle(final String file) {
		LOG.info("searchDocByTitle fileName: {} and searchUrl: {}", file, this.searchDocUrl);
		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add(X_AUTHENTICATION, vaultAuthToken);

		final HttpEntity<String> requestEntity = new HttpEntity<String>("parameters", headers);

		final ResponseEntity<MFSearchDocResponse> responseEntity = restTemplate.exchange(searchDocUrl + file,
				HttpMethod.GET, requestEntity, MFSearchDocResponse.class);

		final MFSearchDocResponse mfSearchDocResponse = responseEntity.getBody();

		LOG.info("Original response: {}", CommonJsonUtils.convertObjectToJsonStr(mfSearchDocResponse));
		return mfSearchDocResponse;
	}

	public Map<String, Object> searchDocByProperties(final String propertiesParams) {
		LOG.info("Searching Doc by meta data...Params: {} and searchUrl: {}", propertiesParams, this.quickSearchUrl);
		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add(X_AUTHENTICATION, vaultAuthToken);

		final HttpEntity<String> requestEntity = new HttpEntity<String>("parameters", headers);
		final StringBuilder searchUrl = new StringBuilder(this.quickSearchUrl);
		searchUrl.append(propertiesParams);
		final String url = CommonCoreUtil.decodeUrl(searchUrl.toString());
		LOG.info("Search by properties....url {}", url);

		final ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<Map<String, Object>>() {
				});

		final Map<String, Object> responseMap = response.getBody();

		/*
		 * final ResponseEntity<MFSearchDocResponse> responseEntity =
		 * restTemplate.exchange(url, HttpMethod.GET, requestEntity,
		 * MFSearchDocResponse.class); final MFSearchDocResponse mfSearchDocResponse =
		 * responseEntity.getBody(); LOG.info("Original response: {}",
		 * mfSearchDocResponse);
		 */

		LOG.info("Search document response: {}", responseMap);
		return responseMap;
	}

	public byte[] download(final String url) {

		LOG.info("Downloading file..url {}", url);
		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		messageConverters.add(new ByteArrayHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);

		final HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		requestHeaders.add(X_AUTHENTICATION, vaultAuthToken);

		final HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);

		final ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, byte[].class,
				"1");

		final byte[] content = response.getBody();

		return content;
	}

	public UploadResponse uploadDocTemp(final MultipartFile file, HttpMethod httpMethod) {
		final String fileName = file.getOriginalFilename();
		LOG.info("Uploading file.. {}", fileName);
		UploadResponse response = null;
		Resource resource = null;

		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
		requestHeaders.add(X_AUTHENTICATION, vaultAuthToken);

		final MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();
		resource = CommonFileUtils.createTempResource(file);
		data.add(FILES, resource);
		final HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
				data, requestHeaders);

		final ResponseEntity<UploadResponse> responseEntity = restTemplate.exchange(tempUploadUrl, httpMethod,
				requestEntity, UploadResponse.class);
		response = responseEntity.getBody();
		LOG.info("Temp Upload response: {}", responseEntity.toString());
		if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
			LOG.info("File upload successfully..{}", fileName);
		} else {
			throw new FileUploadException("Unable to upload file");
		}

		return response;
	}

	public UploadResponse uploadTemp(final File file) {
		final String fileName = file.getAbsolutePath();
		LOG.info("Uploading file temporarily.. {}", fileName);
		UploadResponse response = null;

		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
		requestHeaders.add(X_AUTHENTICATION, vaultAuthToken);

		final MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();

		data.add(FILES, new FileSystemResource(file));

		final HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
				data, requestHeaders);

		final ResponseEntity<UploadResponse> responseEntity = restTemplate.exchange(tempUploadUrl, HttpMethod.POST,
				requestEntity, UploadResponse.class);
		response = responseEntity.getBody();
		LOG.info("Temp Upload response: {}", responseEntity.toString());
		if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
			LOG.info("File upload successfully..{}", fileName);
		} else {
			throw new FileUploadException("Unable to upload file");
		}

		return response;
	}

	public Map<String, Object> upload(final UploadRequest request) {

		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}
		final HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.add(X_AUTHENTICATION, vaultAuthToken);

		final String requestJsonStr = CommonJsonUtils.objectToJsonString(request).replace(VALUE_TRUE_SOURCE,
				VALUE_TRUE_DESTN);
		LOG.info("Permanent upload request url: {} \n data: {}", uploadUrl, requestJsonStr);

		final HttpEntity<String> requestEntity = new HttpEntity<String>(requestJsonStr, requestHeaders);

		final ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(uploadUrl, HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Map<String, Object>>() {
				});
		final Map<String, Object> responseMap = responseEntity.getBody();
		LOG.info("Permanent Upload response: {}", responseMap);
		return responseMap;

	}

	public Object updateMetaData(final List<MfileMetaData> updateMetaDataRequestList,
			final Map<String, Object> parameters) {

		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}
		final HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.add(X_AUTHENTICATION, vaultAuthToken);

		final String requestJsonStr = CommonJsonUtils.objectToJsonString(updateMetaDataRequestList);
		LOG.info("updateMetaDataRequestList: {}", requestJsonStr);

		final HttpEntity<String> requestEntity = new HttpEntity<String>(requestJsonStr, requestHeaders);

		final URI targetUrl = CommonCoreUtil.contructUrl(updateMetadataUrl, parameters);
		LOG.info("MFile Update meta-data url: {}", targetUrl);

		try {
			final ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.POST,
					requestEntity, new ParameterizedTypeReference<Map<String, Object>>() {
					});

			final Object responseMap = responseEntity.getBody();
			LOG.info("Meta data upload response: {}", responseMap);
			return responseMap;
		} catch (Exception e) {
			LOG.error("Unable to update meta data due to....{}", e);
			throw new MFileGenericException("There is a newer version of this object on the server.");
		}

	}

	public byte[] delete(final String url) {

		LOG.info("Deleting file..url {}", url);
		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
		messageConverters.add(new ByteArrayHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);

		final HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		requestHeaders.add(X_AUTHENTICATION, vaultAuthToken);

		final DeleteRequest deleteRequest = new DeleteRequest(true);
		final HttpEntity<DeleteRequest> requestEntity = new HttpEntity<DeleteRequest>(deleteRequest, requestHeaders);

		final ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, byte[].class);

		final byte[] content = response.getBody();

		return content;

	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public PermanentUploadResponse checkOutIn(final String url, final CheckOutRequest oCheckOutRequest) {

		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		try {
			final HttpHeaders requestHeaders = constructRequestHeaders(vaultAuthToken, MediaType.APPLICATION_JSON);

			final HttpEntity<CheckOutRequest> requestEntity = new HttpEntity<CheckOutRequest>(oCheckOutRequest,
					requestHeaders);

			final ResponseEntity<PermanentUploadResponse> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,
					requestEntity, PermanentUploadResponse.class);

			LOG.info("CheckOut response: {}", responseEntity);
			return responseEntity.getBody();
		} catch (final HttpClientErrorException e) {
			final String errorMessage = e.getMessage();
			LOG.error("#### Error due to {}", errorMessage);
			if (errorMessage.contains("404")) {
				throw new FileNotFoundException("The requested file not found");
			}

		}

		return null;

	}

	public PermanentUploadResponse uploadUpdatedDoc(final MultipartFile file, HttpMethod httpMethod, final String url) {
		final String fileName = file.getOriginalFilename();
		LOG.info("Uploading file.. {}", fileName);

		Resource resource = null;

		if (StringUtils.isEmpty(vaultAuthToken)) {
			vaultAuthToken = vaultLogin();
		}

		final HttpHeaders requestHeaders = constructRequestHeaders(vaultAuthToken, MediaType.MULTIPART_FORM_DATA);

		final MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();
		resource = CommonFileUtils.createTempResource(file);
		data.add(FILES, resource);

		final HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
				data, requestHeaders);
		final ResponseEntity<PermanentUploadResponse> responseEntity = restTemplate.exchange(url, httpMethod,
				requestEntity, PermanentUploadResponse.class);

		LOG.info("Updated document upload response: {}", responseEntity.toString());
		return responseEntity.getBody();

	}

	private HttpHeaders constructRequestHeaders(final String authToken, final MediaType mediaType) {
		final HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(mediaType);
		requestHeaders.add(X_AUTHENTICATION, authToken);

		return requestHeaders;
	}

}
