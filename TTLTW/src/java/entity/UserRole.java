package entity;

import java.sql.Timestamp;

public class UserRole {
	private int userroleId;
	private String name;
	private Timestamp createdAt;

	public UserRole() {
	}

	public UserRole(int userroleId, String name, Timestamp createdAt) {
		this.userroleId = userroleId;
		this.name = name;
		this.createdAt = createdAt;
	}

	public int getUserroleId() {
		return userroleId;
	}

	public void setUserroleId(int userroleId) {
		this.userroleId = userroleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserRole [userroleId=" + userroleId + ", name=" + name + ", createdAt=" + createdAt + "]";
	}
}