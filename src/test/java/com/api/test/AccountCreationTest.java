package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models_pojos_requests.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description ="verify if the login is working")
	
	public void createAccountTest() {
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
		.userName("sharviiu@2508") //Change for new request
		.email("saurabhk109@gamil.com") // Change for new request
		.firstName("Uday")
		.lastName("Kumar")
		.mobileNumber("9145134528")
		.password("uday12345")
		.build();
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		System.out.println(response.asPrettyString());
	}

}
