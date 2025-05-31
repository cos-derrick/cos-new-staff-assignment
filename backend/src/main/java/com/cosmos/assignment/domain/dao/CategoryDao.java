package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends GenericDao<Category, String>{
	public String getCategoryName(final String categoryId);
	public String getDescription(final String categoryId);
}
