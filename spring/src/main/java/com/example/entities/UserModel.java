package com.example.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserModel {
	@Id
	private String Id;
	@Column(name="email")
	@NotNull(message = "Email is mandatory")
    @Email(message = "invalid email")
	private String email;
	@Column(name="password", nullable=false)
	@NotNull(message = "Type your password")
    @Length(min = 5, max = 20, message = "Password should be atleast 5 characters")
	private String password;
	@Column(name="username", nullable=false, length=30)
    @NotNull(message = "username is mandatory")
	private String username;
	@Column(name="mobile_Number", nullable=false)
	@NotNull(message = "Mobile number is mandatory")
    @Length(min=10, message = "mobile number should be 10 digits")
	private String mobileNumber;
	@Column(name="active")
	private Boolean active;
	@Column(name="role", nullable=false)
	private String role;
	
	public UserModel() {
		super();
	}

	public UserModel(String id, @NotNull(message = "Email is mandatory") @Email(message = "invalid email") String email,
			@NotNull(message = "Type your password") @Length(min = 5, max = 20, message = "Password should be atleast 5 characters") String password,
			@NotNull(message = "username is mandatory") String username,
			@NotNull(message = "Mobile number is mandatory") @Length(min = 10, message = "mobile number should be 10 digits") String mobileNumber,
			Boolean active, String role) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.active = active;
		this.role = role;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

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

	@Override
	public String toString() {
		return "UserModel [Id=" + Id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", mobileNumber=" + mobileNumber + ", active=" + active + ", role=" + role + "]";
	}
	
	
}
