package com.api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class LoginAPITest2 extends AuthService{
	

	@Test (description = "Verify if login is working with second login method...")
	public void loginTest() {
		
		Response response = given().baseUri("http://64.227.160.186:8080") //This response is builder design patter, if ased in interview diffrent design patter  you have implemented for login
				.header("Content-Type","application/json")                //Talk about page object, factory design pattern, service design pattern
				.body("{\"username\": \"uday1234\", \"password\": \"uday12345\"}")
				.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
