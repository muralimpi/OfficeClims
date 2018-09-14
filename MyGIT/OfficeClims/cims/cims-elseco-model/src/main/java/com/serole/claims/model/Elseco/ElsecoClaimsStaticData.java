package com.serole.claims.model.Elseco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
//@Table(name = "\"EL_ELSECO.EL_CLAIMS.EL_DB::EL_StaticData_T\"", schema="EL_CLAIMS")
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_StaticData_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsStaticData {
	public ElsecoClaimsStaticData(){  }
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;   					//ID	
	
	@Column(name = "ApplicationHandle")
	private String applicationHandle; 	//ApplicationHandle	

	@Column(name = "ScreenHandle")	
	private String screenHandle;   		//ScreenHandle	
	
	@Column(name = "Depend1")
	private String depend1;  			//Depend1	
	
	@Column(name = "Depend2")
	private String depend2;  			//Depend2	
	
	@Column(name = "EntityHandle")
	private String entityHandle;  		//EntityHandle	
	
	@Column(name = "EntityCode")
	private String entityCode;  		//EntityCode	
	
	@Column(name = "EntityName1")
	private String entityName1;  		//EntityName1	
	
	@Column(name = "EntityName2")
	private String entityName2;  		//EntityName2	
	
	@Column(name = "EntityDesc")
	private String entityDesc;  		//EntityDesc	
	
	@Column(name = "IsEnable")
	private String isEnable;  				//IsEnable	
	
	@Column(name = "Status")
	private String status  = "";  			//Status	

	/**
	 * @return the id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param id the id to set
	 */
	public void setID(int id) {
		ID = id;
	}

	/**
	 * @return the applicationHandle
	 */
	public String getApplicationHandle() {
		return applicationHandle;
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
		return screenHandle;
	}

	/**
	 * @param screenHandle the screenHandle to set
	 */
	public void setScreenHandle(String screenHandle) {
		this.screenHandle = screenHandle;
	}

	/**
	 * @return the depend1
	 */
	public String getDepend1() {
		return depend1;
	}

	/**
	 * @param depend1 the depend1 to set
	 */
	public void setDepend1(String depend1) {
		this.depend1 = depend1;
	}

	/**
	 * @return the depend2
	 */
	public String getDepend2() {
		return depend2;
	}

	/**
	 * @param depend2 the depend2 to set
	 */
	public void setDepend2(String depend2) {
		this.depend2 = depend2;
	}

	/**
	 * @return the entityHandle
	 */
	public String getEntityHandle() {
		return entityHandle;
	}

	/**
	 * @param entityHandle the entityHandle to set
	 */
	public void setEntityHandle(String entityHandle) {
		this.entityHandle = entityHandle;
	}

	/**
	 * @return the entityCode
	 */
	public String getEntityCode() {
		return entityCode;
	}

	/**
	 * @param entityCode the entityCode to set
	 */
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	/**
	 * @return the entityName1
	 */
	public String getEntityName1() {
		return entityName1;
	}

	/**
	 * @param entityName1 the entityName1 to set
	 */
	public void setEntityName1(String entityName1) {
		this.entityName1 = entityName1;
	}

	/**
	 * @return the entityName2
	 */
	public String getEntityName2() {
		return entityName2;
	}

	/**
	 * @param entityName2 the entityName2 to set
	 */
	public void setEntityName2(String entityName2) {
		this.entityName2 = entityName2;
	}

	/**
	 * @return the entityDesc
	 */
	public String getEntityDesc() {
		return entityDesc;
	}

	/**
	 * @param entityDesc the entityDesc to set
	 */
	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}

	/**
	 * @return the isEnable
	 */
	public String getIsEnable() {
		return isEnable;
	}

	/**
	 * @param isEnable the isEnable to set
	 */
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsStaticData [Id=" + ID + ", "
				+ (applicationHandle != null ? "applicationHandle=" + applicationHandle + ", " : "")
				+ (screenHandle != null ? "screenHandle=" + screenHandle + ", " : "")
				+ (depend1 != null ? "depend1=" + depend1 + ", " : "")
				+ (depend2 != null ? "depend2=" + depend2 + ", " : "")
				+ (entityHandle != null ? "entityHandle=" + entityHandle + ", " : "")
				+ (entityCode != null ? "entityCode=" + entityCode + ", " : "")
				+ (entityName1 != null ? "entityName1=" + entityName1 + ", " : "")
				+ (entityName2 != null ? "entityName2=" + entityName2 + ", " : "")
				+ (entityDesc != null ? "entityDesc=" + entityDesc + ", " : "") + "isEnable=" + isEnable + ", "
				+ (status != null ? "status=" + status : "") + "]";
	}	
}
