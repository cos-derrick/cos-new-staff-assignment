package com.cosmos.assignment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="JEFF_CHEE_CATEGORY")
public class Category implements Serializable{

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7802763376439811415L;
	
	@Id
	@Column(name="CATEGORY_ID")
	private String categoryId;
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	@Column(name="CATEGORY_DESCRIPTION")
	private String categoryDescription;
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + "]";
	}
	
	
}
