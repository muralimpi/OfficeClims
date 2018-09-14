package com.serole.claims.model;

import org.springframework.stereotype.Component;

@Component
public class ClaimsContract {
	ClaimsItems itms = new ClaimsItems();
	ClaimsPayee payee = new ClaimsPayee();
	ClaimsPayment paymnt = new ClaimsPayment();
}
