package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.PublisherDao;
import com.cosmos.assignment.domain.entity.Publisher;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherDaoImpl extends AbstractGenericDao<Publisher, String> implements PublisherDao{
	private final static String TABLE = "JEFF_CHEE_PUBLISHER";
	
	@Override
	public String getPublisherName(String publisherId) {
		Query query = getSession().createQuery("SELECT PUBLISHER_NAME FROM "+ TABLE +" WHERE PUBLISHER_ID = "+ publisherId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getPublisherEmail(String publisherId) {
		Query query = getSession().createQuery("SELECT PUBLISHER_EMAIL FROM "+ TABLE +" WHERE PUBLISHER_ID = "+ publisherId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getPublisherAddress(String publisherId) {
		Query query = getSession().createQuery("SELECT PUBLISHER_ADDRESS FROM "+ TABLE +" WHERE PUBLISHER_ID = "+ publisherId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getPublisherTelephone(String publisherId) {
		Query query = getSession().createQuery("SELECT PUBLISHER_TELEPHONE FROM "+ TABLE +" WHERE PUBLISHER_ID = "+ publisherId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getPublisherFax(String publisherId) {
		Query query = getSession().createQuery("SELECT PUBLISHER_FAX FROM "+ TABLE +" WHERE PUBLISHER_ID = "+ publisherId);
		String result = (String) query.uniqueResult();
		return result;
	}

}
