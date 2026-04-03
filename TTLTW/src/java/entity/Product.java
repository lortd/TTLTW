/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Date; // Sử dụng thư viện này

public class Product {
    private int productId;
    private String name;
    private String description;
    private int categoryId;
    private String imageUrl;
    private BigDecimal price;
    private int quantity;
    private String status;
    private Date createdAt; // Đổi sang Date
    private Date updatedAt; // Đổi sang Date

    public Product() {
    }

    // Constructor đủ 10 tham số theo đúng thứ tự SQL
    public Product(int productId, String name, String description, int categoryId, 
                   String imageUrl, BigDecimal price, int quantity, String status, 
                   Date createdAt, Date updatedAt) {
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

    // ... Getters và Setters giữ nguyên ...


    // Getters và Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", categoryId="
				+ categoryId + ", imageUrl=" + imageUrl + ", price=" + price + ", quantity=" + quantity + ", status="
				+ status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
    
}