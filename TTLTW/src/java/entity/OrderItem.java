package entity;

import java.math.BigDecimal;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int productId;
	private int quantity;
	private BigDecimal price;

	public OrderItem() {
	}

	public OrderItem(int orderItemId, int orderId, int productId, int quantity, BigDecimal price) {
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", price=" + price + "]";
	}
}