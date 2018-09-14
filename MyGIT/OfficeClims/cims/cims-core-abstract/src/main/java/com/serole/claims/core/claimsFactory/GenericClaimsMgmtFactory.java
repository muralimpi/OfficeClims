package com.serole.claims.core.claimsFactory;

import org.springframework.stereotype.Component;

@Component("genericClaimsMgmtFactory")
public abstract class GenericClaimsMgmtFactory extends AbstractClaimsMgmtFactory {
	
	public void printClaimDetails() {
		System.out.println("In a GenericClaimsMgmtFactory... ");
	}

	public abstract Object getInstance();
}
