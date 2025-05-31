package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.PublisherDao;
import com.cosmos.assignment.domain.entity.Publisher;
import com.cosmos.assignment.service.PublisherService;
import com.cosmos.assignment.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

	@Inject
	private PublisherDao publisherDao;
	
	@Override
	@Transactional
	public void addPublisher(Publisher publisher) {
		int id = findAllPublisher().size() + 1;
		publisher.setPublisherId(Util.generateId("Publisher",id));
		publisherDao.add(publisher);
	}

	@Override
	@Transactional
	public void updatePublisher(Publisher publisher) {
		publisherDao.update(publisher);
	}

	@Override
	@Transactional(readOnly = true)
	public String getPublisherName(String publisherId) {
		return publisherDao.getPublisherName(publisherId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getPublisherEmail(String publisherId) {
		return publisherDao.getPublisherEmail(publisherId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getPublisherAddress(String publisherId) {
		return publisherDao.getPublisherAddress(publisherId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getPublisherTelephone(String publisherId) {
		return publisherDao.getPublisherTelephone(publisherId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getPublisherFax(String publisherId) {
		return publisherDao.getPublisherFax(publisherId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Publisher> findAllPublisher() {
		return publisherDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Publisher getPublisherById(String id) {
		return publisherDao.getById(id);
	}
}
