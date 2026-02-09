package com.api.filters;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{

	//Interview que - Filter is an iterface u used in project.
	
	//private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);
	
	private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		Logger.info("BASE URI:" + requestSpec.getBaseUri());
		Logger.info("Request Header:" + requestSpec.getHeaders());
		Logger.info("Request Payload:" + requestSpec.getBody());
		
	}
	
	public void logResponse(Response response) {
		Logger.info("Status Code:" +response.getStatusCode());
		Logger.info("Response Header:" +response.headers());
		Logger.info("Request Header:" +response.getBody().prettyPrint());
		
	}
	
	
	
	
	}


