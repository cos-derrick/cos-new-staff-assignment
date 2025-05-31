package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Publisher;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDao extends GenericDao<Publisher, String>{
	public String getPublisherName(final String publisherId);
	public String getPublisherEmail(final String publisherId);
	public String getPublisherAddress(final String publisherId);
	public String getPublisherTelephone(final String publisherId);
	public String getPublisherFax(final String publisherId);
}
