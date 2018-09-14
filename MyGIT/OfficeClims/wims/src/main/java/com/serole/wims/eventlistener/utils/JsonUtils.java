package com.serole.wims.eventlistener.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serole.wims.eventlistener.exception.WorkflowException;
import com.serole.wims.eventlistener.model.ActivitiLog;
import com.serole.wims.eventlistener.model.data;

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
public class JsonUtils {

	private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);
	private static ObjectMapper MAPPER = null;

	static {
		if (MAPPER == null) {
			MAPPER = new ObjectMapper();
			MAPPER.setSerializationInclusion(Include.NON_NULL);
		}
	}

	/**
	 * 
	 * @param jsonData
	 * @return
	 */
	public static Object convertJsonToObj(String jsonData) {
		Object obj = null;

		try {
			// JSON String to Object
			obj = MAPPER.readValue(jsonData, ActivitiLog.class);
		} catch (final IOException e) {
			LOG.error("Unable to parse JSON Data. >> ", e);
			throw new WorkflowException("Unable to parse JSON Data. >> " + e.getMessage());
		}

		return obj;
	}

	/**
	 * 
	 * @param oWrapperTaskResp
	 * @return
	 */
	public static String convertObjTojson(data oData) {
		String jsonString = null;

		try {
			// Object to JSON String
			//jsonString = oActivitiLog.toString(); 
			//jsonString = new com.google.gson.Gson().toJson(oActivitiLog);
			jsonString = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(oData);

		} catch (Exception e) {
			LOG.error("Unable to port Object to JSON String. >> ", e);
			throw new WorkflowException("Unable to port Object to JSON String. >> " + e.getMessage());
		}

		return jsonString;
	}

}
