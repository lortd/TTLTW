package entity;

import java.sql.Timestamp;

public class Cart {
	private int cartId;
	private int userId;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Cart() {
	}

	public Cart(int cartId, int userId, Timestamp createdAt, Timestamp updatedAt) {
		this.cartId = cartId;
		this.userId = userId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + "]";
	}
}