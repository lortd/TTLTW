package me.nhom65.model;

import java.sql.Timestamp;

public class User {

	
	private int usedId;
	private String userName;
	private String passwordHash;
	private String email;
	private String phone;
	private String address;
	private int roleId;
	private Timestamp createdAt;
	
	public User(int usedId, String userName, String passwordHash, String email, String phone, String address,
			int roleId, Timestamp createdAt) {
		super();
		this.usedId = usedId;
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
		this.createdAt = createdAt;
	}
	
	public int getUsedId() {
		return usedId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public String getEmail() {
		return email;
	}
	public int getRoleId() {
		return roleId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	
	
}
