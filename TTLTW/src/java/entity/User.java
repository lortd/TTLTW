package entity;

import java.sql.Timestamp;

public class User {
	private int userId;
	private String username;
	private String passwordHash;
	private String email;
	private String phone;
	private String address;
	private int roleId;
	private Timestamp createdAt;

	public User() {
	}

	public User(int userId, String username, String passwordHash, String email, String phone, String address,
			int roleId, Timestamp createdAt) {
		this.userId = userId;
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", roleId=" + roleId + "]";
	}
}