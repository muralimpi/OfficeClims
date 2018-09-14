package com.elseco.nyms.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * 
 * @author vadivel
 *
 */
@Component
public class MailHealthIndicator extends AbstractHealthIndicator {
	private static final Logger LOG = LoggerFactory.getLogger(MailHealthIndicator.class);
	private final JavaMailSenderImpl mailSender;

	@Autowired
	public MailHealthIndicator(final JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	protected void doHealthCheck(Builder builder) {

		final String host = this.mailSender.getHost();
		final int port = this.mailSender.getPort();
		builder.withDetail("location", host).withDetail("port", port);
		try {
			this.mailSender.testConnection();
			builder.up();
		} catch (final Exception ex) {
			LOG.error("Error due to {}", ex);
			builder.down(ex);
		}
	}
}