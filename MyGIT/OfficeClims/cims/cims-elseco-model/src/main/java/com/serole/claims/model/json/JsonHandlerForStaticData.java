package com.serole.claims.model.json;

import java.util.Map;

import org.springframework.stereotype.Component;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
public class JsonHandlerForStaticData {
	public JsonHandlerForStaticData(){  }
	
	private Map<String, Object> staticinfo;

	/**
	 * @return the staticinfo
	 */
	public Map<String, Object> getStaticinfo() {
		return staticinfo;
	}

	/**
	 * @param staticinfo the staticinfo to set
	 */
	public void setStaticinfo(Map<String,Object> staticinfo) {
		this.staticinfo = staticinfo;
	} 
}
