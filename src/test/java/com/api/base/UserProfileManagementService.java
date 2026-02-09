package com.api.base;
import static io.restassured.RestAssured.given;

import com.api.models_pojos_requests.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
	
	private static final String BASE_PATH = "/api/users";
	
    public Response getProfile(String token) {
    	setAuthToken(token);
    	return getRequest(BASE_PATH+"/profile")
    			.then().log().all()
                .extract().response();
    }
    	
//Created below method    	
//    	public class UserProfileManagementService extends BaseService{
//
//    	    public Response getProfile(String token) {
//    	        return given()
//    	                .baseUri("http://64.227.160.186:8080")
//    	                .header("Authorization", "Bearer " + token)
//    	                .header("Accept", "*/*")
//    	                .get("/api/users/profile");
//    	    }
    	    public Response updateProfile(String token, ProfileRequest payload) {
    	    	setAuthToken(token);
    	    	return putRequest(payload ,BASE_PATH+"/profile");
    	    }

  }
    

