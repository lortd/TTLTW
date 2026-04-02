package me.nhom65.model;

import java.sql.Timestamp;

public class OTP {
	
	private int otpId;
	private int userId;
	private String otpHash;
	private String type;
	private int isUsed;
	private int attemptCount;
	private Timestamp createdAt;
	private Timestamp expiredAt;
	public OTP(int otpId, int userId, String otpHash, String type, int isUsed, int attemptCount, Timestamp createdAt,
			Timestamp expiredAt) {
		super();
		this.otpId = otpId;
		this.userId = userId;
		this.otpHash = otpHash;
		this.type = type;
		this.isUsed = isUsed;
		this.attemptCount = attemptCount;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
	}
	public int getOtpId() {
		return otpId;
	}
	public int getUserId() {
		return userId;
	}
	public String getOtpHash() {
		return otpHash;
	}
	public String getType() {
		return type;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public int getAttemptCount() {
		return attemptCount;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getExpiredAt() {
		return expiredAt;
	}
	
	
	
}
