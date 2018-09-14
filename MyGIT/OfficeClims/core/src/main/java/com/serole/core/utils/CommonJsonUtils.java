package com.serole.core.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serole.core.exception.JsonParserException;

/**
 * 
 * @author vadivel
 *
 */
public class CommonJsonUtils {
	private static final Logger LOG = LoggerFactory.getLogger(CommonJsonUtils.class);
	private static ObjectMapper MAPPER = null;
	static {
		if (MAPPER == null) {
			MAPPER = new ObjectMapper();
			MAPPER.setSerializationInclusion(Include.NON_NULL);
		}

	}

	public static String convertObjectToJsonStr(final Object value) {
		try {
			return MAPPER.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			String ex = String.format("Unable to parse %s to string due to %s", value, e.getMessage());
			LOG.error(ex);
			throw new JsonParserException(ex);
		}
	}

	public static JsonNode jsonStringToNode(final String jsonString) {
		LOG.info("Parsing Json str: {}", jsonString);
		try {
			return MAPPER.readTree(jsonString);
		} catch (final IOException cause) {
			final String jsonStringStart64 = (64 < jsonString.length() ? jsonString.substring(0, 64) : jsonString);
			throw new IllegalArgumentException("Unable to parse JSON string: " + jsonStringStart64, cause);
		}
	}

	public static String parseToken(final String jsonString, final String propertyName) {
		final JsonNode rootNode = jsonStringToNode(jsonString);
		return rootNode.get(propertyName).asText();
	}

	public static String objectToJsonString(final Object object) {
		try {
			return MAPPER.writeValueAsString(object);
		} catch (final IOException cause) {
			throw new JsonParserException("Unable to convert object to JSON string: " + object);
		}
	}

}
