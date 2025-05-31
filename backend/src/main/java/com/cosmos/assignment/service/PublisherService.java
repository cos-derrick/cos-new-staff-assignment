package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Publisher;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface PublisherService {
	public void addPublisher(Publisher publisher);
	public void updatePublisher(Publisher publisher);
	
	public String getPublisherName(final String publisherId);
	public String getPublisherEmail(final String publisherId);
	public String getPublisherAddress(final String publisherId);
	public String getPublisherTelephone(final String publisherId);
	public String getPublisherFax(final String publisherId);
	
	public List<Publisher> findAllPublisher();
	public Publisher getPublisherById(final String id);
}
