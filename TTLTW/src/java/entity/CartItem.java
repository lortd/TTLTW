package entity;

import java.sql.Timestamp;

public class CartItem {
	private int cartItemId;
	private int cartId;
	private int productId;
	private int quantity;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public CartItem() {
	}

	public CartItem(int cartItemId, int cartId, int productId, int quantity, Timestamp createdAt, Timestamp updatedAt) {
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartId=" + cartId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
}