package com.webelement.flaadmin.dto;

public class RefreshTokenResponse {
	private String token;

	public RefreshTokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
