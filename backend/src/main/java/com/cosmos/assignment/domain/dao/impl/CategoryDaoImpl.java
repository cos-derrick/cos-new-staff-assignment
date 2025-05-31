package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.CategoryDao;
import com.cosmos.assignment.domain.entity.Category;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends AbstractGenericDao<Category, String> implements CategoryDao{
	private final static String TABLE = "JEFF_CHEE_CATEGORY";
	@Override
	public String getCategoryName(String categoryId) {
		Query query = getSession().createQuery("SELECT CATEGORY_NAME FROM "+ TABLE +" WHERE CATEGORY_ID = "+ categoryId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getDescription(String categoryId) {
		Query query = getSession().createQuery("SELECT CATEGORY_DESCRIPTION FROM "+ TABLE +" WHERE CATEGORY_ID = "+ categoryId);
		String result = (String) query.uniqueResult();
		return result;
	}

}
