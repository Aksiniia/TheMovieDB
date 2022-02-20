package com.example.themoviedb.Api;

public class ValidateUser {
	public String username;
	public String password;
	public String request_token;

	public ValidateUser(String username, String password, String request_token) {
		this.username = username;
		this.password = password;
		this.request_token = request_token;
	}
}
