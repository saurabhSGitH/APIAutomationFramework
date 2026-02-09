package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models_pojos_requests.LoginRequest;
import com.api.models_pojos_response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listerners.TestListeners.class)
public class LoginAPITest3 {
	
	@Test(description ="verify if the login is working")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		//System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId()); 
		Assert.assertTrue(loginResponse.getToken() != null);
		//ALOK1234@yahoo.com
		//Assert.assertEquals(loginResponse.getEmail(),"deva@gamil.com");
		Assert.assertEquals(loginResponse.getEmail(),"ALOK1234@yahoo.com");
		Assert.assertEquals(loginResponse.getId(),1);
		
	}

}
