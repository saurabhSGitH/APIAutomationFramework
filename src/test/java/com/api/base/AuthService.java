package com.api.base;

import java.util.HashMap;

import com.api.models_pojos_requests.LoginRequest;
import com.api.models_pojos_requests.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH+"login");
	}
	
	public Response signUp(SignUpRequest signUpRequest) {
		return postRequest(signUpRequest, BASE_PATH+"signup");
}
	public Response forgotPassword(String emailAdress) {
		HashMap<String,String> payload = new HashMap<String, String>();
		payload.put("email", emailAdress);
		
		return postRequest(payload, BASE_PATH+"forgot-Password");
}
}
