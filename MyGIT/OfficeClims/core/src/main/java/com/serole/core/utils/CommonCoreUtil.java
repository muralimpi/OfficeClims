package com.serole.core.utils;

import java.net.URI;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.serole.core.exception.DecodeUrlException;

/**
 * 
 * @author vadivel
 *
 */
public class CommonCoreUtil {
	private static final Logger LOG = LoggerFactory.getLogger(CommonCoreUtil.class);
	public static final String DOT = ".";
	public static final String BACK_SLASH = "/";

	private static final String UTF_8 = "UTF-8";

	public static String decodeUrl(final String url) {
		try {
			final StringBuilder loginUriBuilder = new StringBuilder(url);
			return URLDecoder.decode(loginUriBuilder.toString(), UTF_8);
		} catch (Exception e) {
			LOG.error("Unable to encode the url {} due to {}", url, e);
			throw new DecodeUrlException(String.format("Unable to encode the url %s due to %s", url, e.getMessage()));
		}

	}

	public static String constructUrlWithQueryParams(final String url, final Map<String, String> paramMap) {
		final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		if (!paramMap.isEmpty()) {
			for (final Entry<String, String> entry : paramMap.entrySet()) {
				builder.queryParam(entry.getKey(), entry.getValue());
			}

		}

		return decodeUrl(builder.toUriString());
	}

	public static URI contructUrl(final String url, final Map<String, Object> parameters) {
		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		final UriComponents uriComponents = builder.buildAndExpand(parameters).encode();
		return uriComponents.toUri();
	}
}
