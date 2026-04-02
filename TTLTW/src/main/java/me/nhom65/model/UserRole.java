package me.nhom65.model;

import java.sql.Timestamp;

public class UserRole {

	private int userRoleId;
	private String name;
	private Timestamp createdAt;
	
	
	public UserRole(int userRoleId, String name, Timestamp createdAt) {
		super();
		this.userRoleId = userRoleId;
		this.name = name;
		this.createdAt = createdAt;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public String getName() {
		return name;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	
}
