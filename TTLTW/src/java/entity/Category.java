package entity;

import java.sql.Timestamp;

public class Category {
	private int categoryId;
	private String name;
	private String description;
	private Integer parentId;
	private Timestamp createdAt;

	public Category() {
	}

	public Category(int categoryId, String name, String description, Integer parentId, Timestamp createdAt) {
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
		this.createdAt = createdAt;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", parentId=" + parentId + "]";
	}
}