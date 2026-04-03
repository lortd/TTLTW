package entity;

import java.sql.Timestamp;

public class Order {
	private int orderId;
	private int userId;
	private String fullname;
	private String phone;
	private String address;
	private String paymentMethod;
	private String status;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Order() {
	}

	public Order(int orderId, int userId, String fullname, String phone, String address, String paymentMethod,
			String status, Timestamp createdAt, Timestamp updatedAt) {
		this.orderId = orderId;
		this.userId = userId;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// Getters and Setters...
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", fullname=" + fullname + ", status=" + status + "]";
	}
}