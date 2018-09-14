package com.serole.claims.core.util;

import org.springframework.stereotype.Service;

@Service
public class CommonUtil {
	
	public static Object lookupService(String serviceName) {
		return null;
	}
	
	public boolean isNullOrEmpty(String var) {
		if(var == null || "".equals(var)) {
			return true;
		}
		return false;
	}
}
