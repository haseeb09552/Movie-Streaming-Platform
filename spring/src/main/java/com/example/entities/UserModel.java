package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="user")
public class UserModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private String mobileNumber;
	@Column
	private Boolean active;
	@Column
	private String role;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
