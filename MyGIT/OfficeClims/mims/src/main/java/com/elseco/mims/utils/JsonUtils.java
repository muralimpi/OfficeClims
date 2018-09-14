package com.elseco.mims.utils;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elseco.mims.client.VaultSearchResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serole.core.exception.JsonParserException;

/**
 * 
 * @author vadivel
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

	public static String convertObejectToJsonStr(final Object value) {
		try {
			return MAPPER.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			String ex = String.format("Unable to parse %s to string due to %s", value, e.getMessage());
			LOG.error(ex);
			throw new JsonParserException(ex);
		}
	}

	public static List<VaultSearchResponse> parseVaultSearch(final String jsonString) {
		List<VaultSearchResponse> vaultSearchs = null;
		try {
			vaultSearchs = MAPPER.readValue(jsonString, new TypeReference<List<VaultSearchResponse>>() {
			});
		} catch (IOException e) {
			String ex = String.format("Unable to parse jsonstr: %s to List<VaultSearch> due to %s", jsonString,
					e.getMessage());
			LOG.error(ex);
			throw new JsonParserException(ex);
		}

		return vaultSearchs;
	}
}
