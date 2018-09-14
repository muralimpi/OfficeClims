package com.elseco.mims.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elseco.mims.client.File;
import com.elseco.mims.client.Lookup;
import com.elseco.mims.client.PermanentUploadResponse;
import com.elseco.mims.client.PropertyValue;
import com.elseco.mims.client.TypedValue;
import com.elseco.mims.client.UploadRequest;
import com.elseco.mims.client.UploadResponse;
import com.elseco.mims.model.DocInfo;
import com.elseco.mims.model.MfileMetaData;
import com.elseco.mims.model.MimsResponse;
import com.elseco.mims.services.MFileDocService;
import com.serole.core.controllers.SeroleAbstractController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author vadivel
 *
 */
@RestController
@RequestMapping(value = "/mfile")
@Api(value = "MFile Document", description = "MFile search and download", tags = { "MFile Service" })
public class MFileDocController extends SeroleAbstractController {

	@Autowired
	private MFileDocService service;

	private static final Logger LOG = LoggerFactory.getLogger(MFileDocController.class);

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = MimsResponse.class, responseContainer = "MimsResponse", value = "Search")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MimsResponse search(@NotNull @RequestParam("file") final String fileName) {
		LOG.info("Searching document... GET /mfile/search and file: {}", fileName);
		return service.search(fileName);
	}

	@ApiOperation(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE, response = Byte.class, responseContainer = "byte[]", value = "Download")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/download", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamSource> downloadPost(
			@ApiParam(value = "Download file information", required = true) @RequestBody DocInfo docInfo) {
		final String fileName = docInfo.getFileName();
		LOG.info("Downloading document... POST /mfile/download and file: {}", fileName);
		final byte[] content = service.download(docInfo);
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "filename=" + fileName);
		headers.setContentLength(content.length);
		final ResponseEntity<InputStreamSource> response = new ResponseEntity<>(new ByteArrayResource(content), headers,
				HttpStatus.OK);
		LOG.info("File download completed...");
		return response;
	}

	@ApiOperation(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE, response = Byte.class, responseContainer = "byte[]", value = "Download")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamSource> downloadGet(
			@ApiParam(value = "Mfile objectType", required = true) @RequestParam(required = true, value = "objectType") Integer objectType,
			@ApiParam(value = "Mfile objectId", required = true) @RequestParam(required = true, value = "objectId") Integer objectId,
			@ApiParam(value = "Mfile objectVersion", required = true) @RequestParam(required = true, value = "objectVersion") Integer objectVersion,
			@ApiParam(value = "Mfile fileId", required = true) @RequestParam(required = true, value = "fileId") Integer fileId,
			@ApiParam(value = "Mfile fileName", required = true) @RequestParam(required = true, value = "fileName") String fileName,
			@ApiParam(value = "Mfile fileExtention", required = true) @RequestParam(required = true, value = "fileExtention") String fileExtention) {

		LOG.info("Downloading document... GET /mfile/download and file: {}", fileName);
		final DocInfo docInfo = new DocInfo();
		docInfo.setFileExtention(fileExtention);
		docInfo.setFileId(fileId);
		docInfo.setFileName(fileName);
		docInfo.setObjectId(objectId);
		docInfo.setObjectType(objectType);
		docInfo.setObjectVersion(objectVersion);
		final byte[] content = service.download(docInfo);
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "filename=" + fileName +"."+ fileExtention);
	        headers.setContentLength(content.length);
		final ResponseEntity<InputStreamSource> response = new ResponseEntity<>(new ByteArrayResource(content), headers,
				HttpStatus.OK);
		LOG.info("File download completed...");
		return response;
	}

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = MimsResponse.class, responseContainer = "MimsResponse", value = "Upload")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> upload(
			@ApiParam(value = "file", required = true) @RequestParam("file") MultipartFile file) {
		final String fileName = file.getOriginalFilename();

		LOG.info("Downloading document... POST /mfile/upload and file: {}", fileName);

		final String title = StringUtils.substringBefore(fileName, ".");
		final String extention = StringUtils.substringAfter(fileName, ".");
		final UploadResponse uploadResponse = service.uploadTemp(file);

		final UploadRequest permanentUploadRequest = constructPermanentUploadRequest(uploadResponse, title, extention,
				null);
		return service.upload(permanentUploadRequest);
	}

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "MFSearchDocResponse", value = "Searching file")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/search/direct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> searchByMetaData(@RequestParam Map<String, String> metaData) {
		LOG.info("Searching document... GET /mfile/search/direct");
		return service.searchByProperties(metaData);
	}

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "Map", value = "File Upload along with meta data")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@RequestMapping(value = "/uploadWithMeta", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> uploadFileWithMetaData(@RequestParam Map<String, String> metaData,
			@RequestParam("uploadCollection[]") MultipartFile uploadCollection) {
		LOG.info(String.format("%s /mfile/uploadWithMeta %s", RequestMethod.POST, metaData.toString()));
		final MultipartFile file = uploadCollection;
		final String fileName = file.getOriginalFilename();
		LOG.info("Files need to upload: {}", fileName);
		final String title = StringUtils.substringBeforeLast(fileName, ".");
		final String extention = StringUtils.substringAfterLast(fileName, ".");
		final UploadResponse uploadResponse = service.uploadTemp(file);
		final UploadRequest permanentUploadRequest = constructPermanentUploadRequest(uploadResponse, title, extention,
				metaData);
		return service.upload(permanentUploadRequest);

	}

	/**
	 * 
	 * @param objectType
	 * @param objectId
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "MFSearchDocResponse", value = "Deleting file")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InputStreamSource> delete(
			@ApiParam(value = "Mfile objectType", required = true) @RequestParam(required = true, value = "objectType") Integer objectType,
			@ApiParam(value = "Mfile objectId", required = true) @RequestParam(required = true, value = "objectId") Integer objectId) {
		LOG.info("deleting document... PUT /mfile/delete");
		final DocInfo docInfo = new DocInfo();
		docInfo.setObjectId(objectId);
		docInfo.setObjectType(objectType);
		byte[] content = service.deleteService(docInfo);
		final HttpHeaders headers = new HttpHeaders();
		final ResponseEntity<InputStreamSource> response;

		if (content != null) {
			headers.setContentLength(content.length);
			response = new ResponseEntity<>(new ByteArrayResource(content), headers, HttpStatus.OK);
		} else {
			String str = "File deleted successfully... objectType/objectId ## " + objectType + "/" + objectId;
			content = str.getBytes();
			response = new ResponseEntity<>(new ByteArrayResource(content), headers, HttpStatus.OK);
		}
		LOG.info("File deleted successfully... objectType/objectId ## " + objectType + "/" + objectId);
		return response;
	}

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = MimsResponse.class, responseContainer = "MimsResponse", value = "Update")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public PermanentUploadResponse update(
			@ApiParam(value = "file", required = true) @RequestParam("file") MultipartFile file,
			@ApiParam(value = "Mfile objectType", required = true) @RequestParam(required = true, value = "objectType") Integer objectType,
			@ApiParam(value = "Mfile objectId", required = true) @RequestParam(required = true, value = "objectId") Integer objectId,
			@ApiParam(value = "Mfile fileId", required = true) @RequestParam(required = true, value = "fileId") Integer fileId) {
		final String fileName = file.getOriginalFilename();

		LOG.info("Updating the document... PUT /mfile/update and file: {}", fileName);

		final DocInfo docInfo = new DocInfo();
		docInfo.setFileId(fileId);
		docInfo.setFileName(fileName);
		docInfo.setObjectId(objectId);
		docInfo.setObjectType(objectType);
		return service.updateDoc(docInfo, file);
	}

	/**
	 * 
	 * @param uploadResponse
	 * @param title
	 * @param extention
	 * @param metaData
	 * @return
	 */
	private UploadRequest constructPermanentUploadRequest(final UploadResponse uploadResponse, final String title,
			final String extention, final Map<String, String> metaData) {
		final UploadRequest permanentUploadRequest = new UploadRequest();

		final List<File> files = new ArrayList<>(1);
		final File fileUpload = new File();
		fileUpload.setUploadID(uploadResponse.getUploadID());
		fileUpload.setSize(uploadResponse.getSize());
		fileUpload.setTitle(title);
		fileUpload.setExtension(extention);
		files.add(fileUpload);

		permanentUploadRequest.setFiles(files);

		final List<PropertyValue> propertyValues = new ArrayList<>(3);

		final PropertyValue propertyValueOne = new PropertyValue();
		final TypedValue typedValueOne = new TypedValue();
		typedValueOne.setDataType(1);
		typedValueOne.setValue(title);
		propertyValueOne.setPropertyDef(0);
		propertyValueOne.setTypedValue(typedValueOne);
		propertyValues.add(propertyValueOne);

		final PropertyValue propertyValueTwo = new PropertyValue();
		final TypedValue typedValueTwo = new TypedValue();
		typedValueTwo.setDataType(8);
		typedValueTwo.setValue("true");
		propertyValueTwo.setPropertyDef(22);
		propertyValueTwo.setTypedValue(typedValueTwo);
		propertyValues.add(propertyValueTwo);

		final PropertyValue propertyValueThree = new PropertyValue();
		propertyValueThree.setPropertyDef(100);
		final TypedValue typedValueThree = new TypedValue();
		typedValueThree.setDataType(9);
		final Lookup lookup = new Lookup();
		lookup.setItem(Integer.parseInt(metaData.get("p100"))); // taking p100
																// property as a
																// document
																// class
		lookup.setVersion(-1);
		typedValueThree.setLookup(lookup);
		propertyValueThree.setTypedValue(typedValueThree);
		propertyValues.add(propertyValueThree);

		if (metaData != null) {
			for (final String key : metaData.keySet()) {

				if (!"p100".equals(key)) {
					final PropertyValue propertyValue = new PropertyValue();

					final TypedValue typedValue = new TypedValue();
					String metaDataValue = metaData.get(key);
					String metaDataKey = key;
					if (key.startsWith("p")) {
						metaDataKey = key.replace("p", StringUtils.EMPTY);
					}

					try {
						propertyValue.setPropertyDef(Integer.parseInt(metaDataKey));

						typedValue.setValue(metaDataValue);
						typedValue.setHasValue(true);
						typedValue.setDisplayValue(metaDataValue);
						typedValue.setDataType(1); // we cover strings so far
						typedValue.setSortingKey(StringUtils.EMPTY);
						typedValue.setHasAutomaticPermission(false);
						propertyValue.setTypedValue(typedValue);
						propertyValues.add(propertyValue);
					} catch (NumberFormatException e) {
						LOG.warn("The parameter {} and value is not required. So skipping...", metaDataKey,
								metaDataValue);
					}

				}

			}

		}

		permanentUploadRequest.setPropertyValues(propertyValues);

		return permanentUploadRequest;
	}

	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = MimsResponse.class, responseContainer = "MimsResponse", value = "Update Meta-data")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/updateMetadata/{objectVersionType}/{objectVersionId}/{obejctVersion}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public MimsResponse updateMetadata(
			@ApiParam(value = "objectVersionType", required = true) @PathVariable Integer objectVersionType,
			@ApiParam(value = "objectVersionId", required = true) @PathVariable Integer objectVersionId,
			@ApiParam(value = "obejctVersion", required = true) @PathVariable Integer obejctVersion,
			@ApiParam(value = "metaDataList") @RequestBody List<MfileMetaData> updateMetaDataRequestList) {
		LOG.info("updateMetadata... GET /mfile/updateMetadata");
		LOG.info("objectVersionType: {}, objectVersionId: {} and obejctVersion: {}", objectVersionType, objectVersionId,
				obejctVersion);
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("objectVersionType", objectVersionType);
		parameters.put("objectVersionId", objectVersionId);
		parameters.put("obejctVersion", obejctVersion);

		return new MimsResponse(true, "Meta data updated successufully",
				service.updateMetaData(updateMetaDataRequestList, parameters));
	}

}