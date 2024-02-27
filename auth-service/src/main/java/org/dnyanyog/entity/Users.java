package org.dnyanyog.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class Users { 

	@GeneratedValue
	@Id
	@Column
	private long user_code;
	
	@Column
	private long user_id;
	

	@Column
	private long userIds;
	
	
	public long getUserIds() {
		return userIds;
	}

	public void setUserIds(long userIds) {
		this.userIds = userIds;
	}
	@Column
	private String user_name;
	
	
	@Column
	private String password;
	@Column
	private String email;
	
	@Column
	private String age;
	

	public static Users getInstance() {
		return new Users();
	}
	
	public long getUser_code() {
		return user_code;
	
	}
	public Users setUser_code(long user_code) {
		this.user_code = user_code;
		return this;
	}
	public long getUser_id() {
		return user_id;
	}
	public Users setUser_id(long user_id) {
		this.user_id = user_id;
		return this;
	}
	public String getUser_name() {
		return user_name;
	}
	public Users setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Users setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Users setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getAge() {
		return age;
	}
	public Users setAge(String age) {
		this.age = age;
		return this;
	}
	
	
	
}
