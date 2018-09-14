package com.serole.claims.core.claimsFactory;

import org.springframework.stereotype.Component;

@Component("abstractClaimsMgmtFactory")
public abstract class AbstractClaimsMgmtFactory {		
	public void printClaimDetails() {
		System.out.println("In a AbstractClaimsMgmtFactory... ");
	}
	
	public abstract Object getInstance() ;
	   
}
