package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class AddUserResponse {
	
	
private  String status;
private String message;
private  long user_id;
private String user_name;
private String password;
private String email;
private String age;
private UserData userData;

public long getUser_id() {
	return user_id;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public UserData getUserData() {
	return userData;
}
public void setUserData(UserData userData) {
	this.userData = userData;
}
	


public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}