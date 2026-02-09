package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
@Test(description ="verify if the forgot password is working")
	
	public void forgotPasswordTest() {
	
	AuthService authService = new AuthService();
	Response response = authService.forgotPassword("saurabhk6@gmail.com");
	System.out.println(response.asPrettyString());
}

}
