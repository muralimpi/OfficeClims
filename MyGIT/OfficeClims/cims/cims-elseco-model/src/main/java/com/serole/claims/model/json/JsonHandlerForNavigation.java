package com.serole.claims.model.json;

import org.springframework.stereotype.Component;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
public class JsonHandlerForNavigation {
	public JsonHandlerForNavigation(){  }
	     
	private String applicationHandle = "";	//APPLICATION HANDLE  --> like ELSECO
	private String moduleHandle = "";		//MODULE HANDLE  --> like Claim
	private String screenHandle = "";		//SCREEN_HANDLE  -->  like screen 1, 2, 6 
	private String serverEnvOrIP = "";		// TBD ?   -->  Server or IP details for Audit 
	
	
	/**
	 * @return the applicationHandle
	 */
	public String getApplicationHandle() {
		return applicationHandle != null? applicationHandle:"Elseco";
	}
	/**
	 * @param applicationHandle the applicationHandle to set
	 */
	public void setApplicationHandle(String applicationHandle) {
		this.applicationHandle = applicationHandle;
	}
	/**
	 * @return the screenHandle
	 */
	public String getScreenHandle() {
		return screenHandle!= null? screenHandle:"1,2,3,6,8";
	}
	/**
	 * @param screenHandle the screenHandle to set
	 */
	public void setScreenHandle(String screenHandle) {
		this.screenHandle = screenHandle;
	}	
	/**
	 * @return the serverEnvOrIP
	 */
	public String getServerEnvOrIP() {
		return serverEnvOrIP!= null? serverEnvOrIP:"192.168.14.35";
	}
	/**
	 * @param serverEnvOrIP the serverEnvOrIP to set
	 */
	public void setServerEnvOrIP(String serverEnvOrIP) {
		this.serverEnvOrIP = serverEnvOrIP;
	}
	/**
	 * @return the moduleHandle
	 */
	public String getModuleHandle() {
		return moduleHandle!= null? moduleHandle:"Claims";
	}
	/**
	 * @param moduleHandle the moduleHandle to set
	 */
	public void setModuleHandle(String moduleHandle) {
		this.moduleHandle = moduleHandle;
	}		
}
