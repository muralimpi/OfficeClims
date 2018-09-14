package com.serole.claims.service.factoryManager;

import org.springframework.stereotype.Component;

import com.serole.claims.core.claimsFactory.GenericClaimsMgmtFactory;
import com.serole.claims.core.constants.AppConstants;

/**
 * A Factory class that returns a instance of a ClaimsManager
 * @author Serole_Vijay
 *
 */
@Component("elsecoClaimsManagerFactory")
public class ElsecoClaimsFactoryManager {	
		
	public static GenericClaimsMgmtFactory getFactory(String client){
	      if(client.equalsIgnoreCase(AppConstants.AVIATION)){
	         return new ElsecoClaimsProcessManager();	         
	      }else if(client.equalsIgnoreCase(AppConstants.ENTITY)){
		         return new ElsecoClaimsEntityManager();
		  }/*else if(client.equalsIgnoreCase(APPCONSTANTS.ENERGY)){
	         return new EnergyClaimsMgmtFactory();
	      }else if(client.equalsIgnoreCase(APPCONSTANTS.SPACE)){
		     return new SpaceClaimsMgmtFactory();
		  }*/
	      
	      return null;
	   }
}
