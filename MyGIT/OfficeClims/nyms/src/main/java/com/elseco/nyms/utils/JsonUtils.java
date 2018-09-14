package com.elseco.nyms.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elseco.nyms.model.Mail;
import com.elseco.nyms.model.ReqObj;
import com.elseco.nyms.model.claim.Inputclaim;
import com.elseco.nyms.model.claim.hybris.InboundHybris;
import com.elseco.nyms.model.policies.InputPolicies;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serole.core.exception.JsonParserException;

public class JsonUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);
	private static ObjectMapper MAPPER = null;
	
	static {
		if (MAPPER == null) {
			MAPPER = new ObjectMapper();
			MAPPER.setSerializationInclusion(Include.NON_NULL);
		}

	}

	public static Mail convertMapToMail(final Map<String, Object> data) {
		Mail mail = null;
		try {
			final String jsonResult = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			mail = MAPPER.readValue(jsonResult, Mail.class);
		} catch (final IOException e) {
			LOG.error("Unable to parse due to...{}", e);
			throw new JsonParserException("Unable to parse due to..." + e.getMessage());
		}

		return mail;
	}

	public static Mail convertMail(final Map<String, Object> data, final String jsonString) {
		Mail mail = null;
		try {
			mail = convertMapToMail(data);
			final List<Object> companies = MAPPER.readValue(jsonString, new TypeReference<List<Object>>() {
			});
			mail.setReports(companies);
		} catch (final IOException e) {
			LOG.error("Unable to parse due to...{}", e);
			throw new JsonParserException("Unable to parse due to..." + e.getMessage());
		}

		return mail;
	}
	
	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public static Inputclaim convertJsonToObj(String jsonData) {
		Inputclaim oInput = null;

		try {
			// JSON String to ReqObj
			oInput  = MAPPER.readValue(jsonData, Inputclaim.class);
		} catch (final IOException e) {
			LOG.error("Unable to parse JSON Data. >> ", e);
		}

		return oInput;
	}

	/**
	 * 
	 * @param oWrapperTaskResp
	 * @return
	 */
	public static String convertObjTojson(ReqObj oReqObj) {
		String jsonString = null;

		try {
			// ReqObj to JSON String
			jsonString = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(oReqObj);

		} catch (Exception e) {
			LOG.error("Unable to port Object to JSON String. >> ", e);
		}

		return jsonString;
	}

	/** 
	 * 
	 * @param data
	 * @return
	 */
	public static Inputclaim convertMapToReqObj(final Map<String, Object> data) {
		Inputclaim oInput = null;
		try {
			final String jsonResult = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			oInput = MAPPER.readValue(jsonResult, Inputclaim.class);
		} catch (final IOException e) {
			LOG.error("Unable to parse due to...{}", e);
			throw new JsonParserException("Unable to parse due to..." + e.getMessage());
		}

		return oInput;
	}

	/** 
	 * 
	 * @param data
	 * @return
	 */
	public static InboundHybris convertMapToInboundHybrisReqObj(final Map<String, Object> data) {
		InboundHybris oInput = null;
		try {
			final String jsonResult = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			oInput = MAPPER.readValue(jsonResult, InboundHybris.class);
		} catch (final IOException e) {
			LOG.error("Unable to parse due to...{}", e);
			throw new JsonParserException("Unable to parse due to..." + e.getMessage());
		}

		return oInput;
	}


	/** 
	 * 
	 * @param data
	 * @return
	 */
	public static InputPolicies convertMapToInputPolicyReqObj(final Map<String, Object> data) {
		InputPolicies oInput = null;
		try {
			final String jsonResult = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			oInput = MAPPER.readValue(jsonResult, InputPolicies.class);
		} catch (final IOException e) {
			LOG.error("Unable to parse due to...{}", e);
			throw new JsonParserException("Unable to parse due to..." + e.getMessage());
		}

		return oInput;
	}


	
}