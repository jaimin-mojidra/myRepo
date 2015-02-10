package com.login;

import com.dbQueries.GetString;

public class LoginBean {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		System.out.println("login method");
		GetString gs = new GetString();
		String result = gs.getUserTypeString(username, password);
		System.out.println("returned " + result);
		return result;
	}
}