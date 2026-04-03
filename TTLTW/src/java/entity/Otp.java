package entity;

import java.sql.Timestamp;

public class Otp {
	private int otpId;
	private int userId;
	private String otpHash;
	private String type;
	private boolean isUsed;
	private int attemptCount;
	private Timestamp createdAt;
	private Timestamp expiredAt;

	public Otp() {
	}

	public Otp(int otpId, int userId, String otpHash, String type, boolean isUsed, int attemptCount,
			Timestamp createdAt, Timestamp expiredAt) {
		this.otpId = otpId;
		this.userId = userId;
		this.otpHash = otpHash;
		this.type = type;
		this.isUsed = isUsed;
		this.attemptCount = attemptCount;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean used) {
		isUsed = used;
	}

	@Override
	public String toString() {
		return "Otp [otpId=" + otpId + ", userId=" + userId + ", type=" + type + ", isUsed=" + isUsed + "]";
	}
}