package com.elseco.mims.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.elseco.mims.client.MFileRestClient;

/**
 * 
 * @author vadivel
 *
 */
@Component
public class MFilesServerHealthIndicator implements HealthIndicator {
	private static final Logger LOG = LoggerFactory.getLogger(MFilesServerHealthIndicator.class);

	private MFileRestClient mFileRestClient;

	@Autowired
	public MFilesServerHealthIndicator(final MFileRestClient client) {
		this.mFileRestClient = client;
	}

	@Override
	public Health health() {
		try {

			final String response = mFileRestClient.commonLogin();
			if (response != null) {
				return Health.up().build();
			} else {
				return Health.down().build();
			}
		} catch (final Exception ex) {
			LOG.error("Error due to {}", ex);
			return Health.down(ex).withDetail("VPN", "It may require VPN Connectivity").build();
		}
	}
}