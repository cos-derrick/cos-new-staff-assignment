package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.AuthorDao;
import com.cosmos.assignment.domain.entity.Author;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl extends AbstractGenericDao<Author, String> implements AuthorDao{
	private final static String TABLE = "JEFF_CHEE_AUTHOR";
	@Override
	public String getAuthorName(String authorId) {
		Query query = getSession().createQuery("SELECT AUTHOR_NAME FROM "+ TABLE +" WHERE AUTHOR_ID = "+ authorId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getAuthorEmail(String authorId) {
		String hql = "SELECT A.authorEmail FROM Author A WHERE A.authorId = '"+authorId+"'";
		Query query = getSession().createQuery(hql);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getAuthorCountry(String authorId) {
		Query query = getSession().createQuery("SELECT AUTHOR_COUNTRY FROM "+ TABLE +" WHERE AUTHOR_ID = "+ authorId);
		String result = (String) query.uniqueResult();
		return result;
	}

}
