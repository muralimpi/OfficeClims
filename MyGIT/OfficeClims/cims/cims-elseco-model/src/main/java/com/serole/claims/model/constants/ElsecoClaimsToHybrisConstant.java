package com.serole.claims.model.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:${claims.config.file.location}/${claims.config.file.name}.properties")
public class ElsecoClaimsToHybrisConstant {

	/**
	 * Call for the Hybris  - to process a Reserve and Payment to Members
	 */
	@Value("${cims.to.hybris.destination.name}")
	public String JCO_DESTINATION_NAME;
			
	@Value("${cims.to.hybris.app.server}")
	public String JCO_HOST;	
	
	@Value("${cims.to.hybris.instance.number}")
	public String JCO_INSTANCE_SYSTEM_NUM;
	
	@Value("${cims.to.hybris.system.id}")
	public String JCO_SYSTEM_ID;
	
	@Value("${cims.to.hybris.client}")
	public String JCO_CLIENT;
	
	@Value("${cims.to.hybris.user}")
	public String JCO_USER;
	
	@Value("${cims.to.hybris.password}")
	public String JCO_PSWRD;
	
	@Value("${cims.to.hybris.standard.fm}")
	public String JCO_STNDRD_FM;
	
	@Value("${cims.to.hybris.lang}")
	public String JCO_LANG;
	
	
	/**
	 * Call for the PQM  - to get the Available Premium Fund Amount
	 */
	@Value("${cims.to.rfc.balanceamount.destination.name}")
	public String AVL_PRM_FUND_DESTINATION_NAME;
			
	@Value("${cims.to.rfc.balanceamount.app.server}")
	public String AVL_PRM_FUND_HOST;	
	
	@Value("${cims.to.rfc.balanceamount.instance.number}")
	public String AVL_PRM_FUND_INSTANCE_SYSTEM_NUM;
	
	@Value("${cims.to.rfc.balanceamount.system.id}")
	public String AVL_PRM_FUND_SYSTEM_ID;
	
	@Value("${cims.to.rfc.balanceamount.client}")
	public String AVL_PRM_FUND_CLIENT;
	
	@Value("${cims.to.rfc.balanceamount.user}")
	public String AVL_PRM_FUND_USER;
	
	@Value("${cims.to.rfc.balanceamount.password}")
	public String AVL_PRM_FUND_PSWRD;
	
	@Value("${cims.to.rfc.balanceamount.standard.fm}")
	public String AVL_PRM_FUND_STNDRD_FM;
	
	@Value("${cims.to.rfc.balanceamount.lang}")
	public String AVL_PRM_FUND_LANG;
	
	/**
	 * Call for the Hybris  - to process a Claims Release Payment
	 */
	@Value("${cims.to.hybris.relpaymnt.destination.name}")
	public String JCO_RELPAY_DESTINATION_NAME;
			
	@Value("${cims.to.hybris.relpaymnt.app.server}")
	public String JCO_RELPAY_HOST;	
	
	@Value("${cims.to.hybris.relpaymnt.instance.number}")
	public String JCO_RELPAY_INSTANCE_SYSTEM_NUM;
	
	@Value("${cims.to.hybris.relpaymnt.system.id}")
	public String JCO_RELPAY_SYSTEM_ID;
	
	@Value("${cims.to.hybris.relpaymnt.client}")
	public String JCO_RELPAY_CLIENT;
	
	@Value("${cims.to.hybris.relpaymnt.user}")
	public String JCO_RELPAY_USER;
	
	@Value("${cims.to.hybris.relpaymnt.password}")
	public String JCO_RELPAY_PSWRD;
	
	@Value("${cims.to.hybris.relpaymnt.standard.fm}")
	public String JCO_RELPAY_STNDRD_FM;
	
	@Value("${cims.to.hybris.relpaymnt.lang}")
	public String JCO_RELPAY_LANG;
}
