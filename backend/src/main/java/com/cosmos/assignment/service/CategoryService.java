package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Category;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface CategoryService {
	public void addCategory(Category category);
	public void updateCategory(Category category);
	
	public String getCategoryName(final String categoryId);
	public String getDescription(final String categoryId);
	
	public List<Category> findAllCategory();
	public Category getCategoryById(final String id);
}
