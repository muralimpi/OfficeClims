package com.elseco.nyms.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail.custom")
public class MailConfigMap {
	private Map<String, String> mailConfigMap;

	public Map<String, String> getMailConfigMap() {
		return mailConfigMap;
	}

	public void setMailConfigMap(Map<String, String> mailConfigMap) {
		this.mailConfigMap = mailConfigMap;
	}

}
