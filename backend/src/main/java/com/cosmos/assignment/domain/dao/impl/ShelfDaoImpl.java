package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.ShelfDao;
import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Shelf;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ShelfDaoImpl extends AbstractGenericDao<Shelf, String> implements ShelfDao{
	private final static String TABLE = "JEFF_CHEE_SHELF";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooks(String shelfUser) {
		String subTable = "JEFF_CHEE_BOOK";
		String subQuery = "SELECT * FROM JEFF_CHEE_SHELF_BOOK WHERE SHELF_BOOK_USER_ID = " + shelfUser;
		Query query = getSession().createQuery("SELECT * FROM "+ subTable +" WHERE BOOK_ID IN ("+subQuery+")");
		List<Book> result = query.list();
		return result;
	}

	@Override
	public int getShelfNumberOfBooks(String shelfUser) {
		Query query = getSession().createQuery("SELECT SHELF_NUMBER_OF_BOOK FROM "+ TABLE +" WHERE SHELF_USER = "+ shelfUser);
		int result = (int) query.uniqueResult();
		return result;
	}

	@Override
	public Date getShelfLastAccesDate(String shelfUser) {
		Query query = getSession().createQuery("SELECT SHELF_LAST_ACCESS_DATE FROM "+ TABLE +" WHERE SHELF_USER = "+ shelfUser);
		Date result = (Date) query.uniqueResult();
		return result;
	}

	@Override
	public int getShelfNumberOfAccess(String shelfUser) {
		Query query = getSession().createQuery("SELECT SHELF_NUMBER_OF_ACCESS FROM "+ TABLE +" WHERE SHELF_USER = "+ shelfUser);
		int result = (int) query.uniqueResult();
		return result;
	}
}
