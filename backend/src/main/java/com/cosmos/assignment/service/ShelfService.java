package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Shelf;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface ShelfService {
	void addBooks(final List<Book> books, final Shelf shelf);
	void updateShelfNumberOfBook(final Shelf shelf);
	void updateShelfLastAccessDate(final Shelf shelf);
	void updateNumberOfAccess(final Shelf shelf);
	
	public List<Book> getBooks(final String shelfUser);
	public int getShelfNumberOfBooks(final String shelfUser);
	public Date getShelfLastAccesDate(final String shelfUser);
	public int getShelfNumberOfAccess(final String shelfUser);

	public List<Shelf> getAllShelf();
	public Shelf getShelfById(final String id);
}
