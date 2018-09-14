package com.serole.claims.model;

import org.springframework.stereotype.Component;

@Component
public class Claims {
	public int claimsId;
	
	ClaimsContract cntr = new ClaimsContract();	
	ClaimsNotes notes = new ClaimsNotes();
	ClaimsReserve res = new ClaimsReserve();
	
	public void getClaimsInstance() {
		//System.out.println(" You are here...." );
	}
	
}
