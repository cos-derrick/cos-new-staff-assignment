package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.CategoryDao;
import com.cosmos.assignment.domain.entity.Category;
import com.cosmos.assignment.service.CategoryService;
import com.cosmos.assignment.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public void addCategory(Category category) {
		int id = findAllCategory().size() + 1;
		category.setCategoryId(Util.generateId("Category",id));
		categoryDao.add(category);
	}

	@Override
	@Transactional
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	@Override
	@Transactional(readOnly = true)
	public String getCategoryName(String categoryId) {
		return categoryDao.getCategoryName(categoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getDescription(String categoryId) {
		return categoryDao.getDescription(categoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAllCategory() {
		return categoryDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Category getCategoryById(String id) {
		return categoryDao.getById(id);
	}

}
