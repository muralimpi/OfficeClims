package com.serole.claims.service.exception;


/**
 * ResourceNotFoundException -  A customized exception handling class
 * @author Serole_Vijay
 *
 */
public class ResourceNotFoundException extends RuntimeException {
  	private static final long serialVersionUID = 1L;
	
	private Long resourceId;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.setResourceId(resourceId);
    }

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}