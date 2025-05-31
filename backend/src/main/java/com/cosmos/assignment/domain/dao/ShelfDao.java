package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Shelf;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShelfDao extends GenericDao<Shelf, String>{
	public List<Book> getBooks(final String shelfUser);
	public int getShelfNumberOfBooks(final String shelfUser);
	public Date getShelfLastAccesDate(final String shelfUser);
	public int getShelfNumberOfAccess(final String shelfUser);
}
