package com.serole.wims.eventlistener.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.serole.wims.client.WimsRestclient;
import com.serole.wims.eventlistener.service.DefaultWorkflowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
@RestController
@Api(value = "Wims workflow", description = "wims activity")
public class DefaultWorkflowController {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultWorkflowController.class);
	
	@Autowired
	DefaultWorkflowService oDefaultWorkflowService;
	
	/*@Autowired
	WimsRestclient oWimsRestclient;*/ 

	/*@RequestMapping(value = "/startprocessflow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String startProcessInstances(@RequestParam("jsonData") String jsonData) {
		return oDefaultWorkflowService.startProcessFlow(jsonData);*/
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = String.class, responseContainer = "StringResponse", value = "startprocessflow")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@RequestMapping(value = "/startprocessflow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String startProcessInstances()
	{
		return oDefaultWorkflowService.maintask();
	}
	/*@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = String.class, responseContainer = "StringResponse", value = "startprocessflow")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@RequestMapping(value = "/startRestprocessflow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String startRestProcessInstances()
	{
		return oWimsRestclient.sendMail();
	}
*/
}
