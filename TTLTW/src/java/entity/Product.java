package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {
	private int productId;
	private String name;
	private String description;
	private int categoryId;
	private String imageUrl;
	private BigDecimal price;
	private int quantity;
	private String status;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Product() {
	}

	public Product(int productId, String name, String description, int categoryId, String imageUrl, BigDecimal price,
			int quantity, String status, Timestamp createdAt, Timestamp updatedAt) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
}