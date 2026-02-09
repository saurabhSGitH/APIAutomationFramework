package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models_pojos_requests.LoginRequest;
import com.api.models_pojos_requests.ProfileRequest;
import com.api.models_pojos_response.LoginResponse;
import com.api.models_pojos_response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response response=authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse =  response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println("------------------1------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		System.out.println("----------------2--------------------");
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "uday1234");
		System.out.println("---------------3---------------------");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Megha")
				.lastName("Khandelwal")
				.mobileNumber("9003484958")
				.email("saurabhk606@gmail.com")
				.build();
		response=userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
}
}
