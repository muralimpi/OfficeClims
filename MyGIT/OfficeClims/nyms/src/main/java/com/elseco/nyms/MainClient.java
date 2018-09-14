/**
 * 
 */
package com.elseco.nyms;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.elseco.nyms.model.NymsResponse;
import com.elseco.nyms.model.claim.Inputclaim;
import com.elseco.nyms.services.EmailService;
import com.elseco.nyms.utils.JsonUtils;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class MainClient {

	// @Autowired
	// private static DefaultWorkflowService oDefaultWorkflowService;

	/**
	 * 
	 */
	public MainClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		try {
			String jsonData = new String(Files.readAllBytes(Paths.get("e://nymsinbound.json")));
			EmailService oEmailService = new EmailService();
			Inputclaim oInput = JsonUtils.convertJsonToObj(jsonData);
			
			NymsResponse oNymsResponse = oEmailService.generateDocNUploadNSendMail(oInput);
			System.out.println(oNymsResponse.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
