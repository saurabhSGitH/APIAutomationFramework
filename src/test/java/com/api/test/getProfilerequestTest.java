package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models_pojos_requests.LoginRequest;
import com.api.models_pojos_response.LoginResponse;
import com.api.models_pojos_response.UserProfileResponse;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getProfilerequestTest {
	
	@Test
	public void getProfileRequestTest() {
		
		
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		
		
		UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		System.out.println(userProfileResponse.getFirstName());
		System.out.println(userProfileResponse.getLastName());

	}
	

}
