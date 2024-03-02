package com.app.rab.util;

public class ResponseObject {
	private String token;
	private Integer role;

	public ResponseObject(String token, Integer role) {
		super();
		this.token = token;
		this.role = role;
	}
	
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
