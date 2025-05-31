package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.ShelfDao;
import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Shelf;
import com.cosmos.assignment.service.ShelfService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService{

	@Inject
	private ShelfDao shelfDao;
	
	@Override
	@Transactional
	public void addBooks(List<Book> books, Shelf shelf) {
		shelf.setBooks(books);
		shelfDao.add(shelf);
	}

	@Override
	@Transactional
	public void updateShelfNumberOfBook(Shelf shelf) {
		shelfDao.update(shelf);
	}

	@Override
	@Transactional
	public void updateShelfLastAccessDate(Shelf shelf) {
		shelfDao.update(shelf);
	}

	@Override
	@Transactional
	public void updateNumberOfAccess(Shelf shelf) {
		shelfDao.update(shelf);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> getBooks(String shelfUser) {
		return shelfDao.getBooks(shelfUser);
	}

	@Override
	@Transactional(readOnly = true)
	public int getShelfNumberOfBooks(String shelfUser) {
		return shelfDao.getShelfNumberOfBooks(shelfUser);
	}

	@Override
	@Transactional(readOnly = true)
	public Date getShelfLastAccesDate(String shelfUser) {
		return shelfDao.getShelfLastAccesDate(shelfUser);
	}

	@Override
	@Transactional(readOnly = true)
	public int getShelfNumberOfAccess(String shelfUser) {
		return shelfDao.getShelfNumberOfAccess(shelfUser);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Shelf> getAllShelf() {
		return shelfDao.findAll();
	}

	@Override
	@Transactional
	public Shelf getShelfById(String id) {
		return shelfDao.getById(id);
	}

}
