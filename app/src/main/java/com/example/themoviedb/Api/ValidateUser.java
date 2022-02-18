package com.example.themoviedb.Api;

public class ValidateUser {
	public String success;
	public String username;
	public String password;

	public ValidateUser(String success, String username, String password) {
		this.success = success;
		this.username = username;
		this.password = password;
	}
}
