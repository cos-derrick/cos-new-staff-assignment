package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.BookDao;
import com.cosmos.assignment.domain.entity.Author;
import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Category;
import com.cosmos.assignment.domain.entity.Publisher;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BookDaoImpl extends AbstractGenericDao<Book, String> implements BookDao{
	private final static String TABLE = "JEFF_CHEE_BOOK";
	
	@Override
	public String getBookSubject(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_SUBJECT FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getBookDesciption(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_DESCRIPTION FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getBookIsbn(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_ISBN FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public String getBookContent(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_CONTENT FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public int getBookContentType(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_CONTENT_TYPE FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		int result = (int) query.uniqueResult();
		return result;
	}

	@Override
	public Author getBookAuthor(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_AUTHOR FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		Author result = (Author) query.uniqueResult();
		return result;
	}

	@Override
	public Publisher getBookPublisher(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_PUBLISHER FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		Publisher result = (Publisher) query.uniqueResult();
		return result;
	}

	@Override
	public Category getBookCategory(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_CATEGORY FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		Category result = (Category) query.uniqueResult();
		return result;
	}

	@Override
	public Date getBookCreatedDate(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_CREATED_DATE FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		Date result = (Date) query.uniqueResult();
		return result;
	}

	@Override
	public double getBookPrice(String bookId) {
		Query query = getSession().createQuery("SELECT BOOK_PRICE FROM "+ TABLE +" WHERE BOOK_ID = "+ bookId);
		double result = (double) query.uniqueResult();
		return result;
	}

	@Override
	public List<Book> findAllBook() {
		Criteria cr = getSession().createCriteria(Book.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);				
		Object result = cr.list();
		List<Book> books = (List<Book>) result;
		return books;
	}
	
	@Override
	public List<Book> findBookBySubject(String bookSubject) {
		Criteria cr = getSession().createCriteria(Book.class)
				.add(Restrictions.like("bookSubject", "%"+bookSubject+"%"));					
		Object result = cr.list();
		List<Book> books = (List<Book>) result;
		return books;
	}

	@Override
	public List<Book> findBookByAuthor(String bookAuthorName) {
		Criteria cr = getSession().createCriteria(Book.class);		
		cr.createCriteria("bookAuthor").add(Restrictions.like("authorName", "%"+bookAuthorName+"%"));
		Object result = cr.list();
		List<Book> books = (List<Book>) result;
		return books;
	}

	@Override
	public List<Book> findBookByPublisher(String bookPublisherName) {
		Criteria cr = getSession().createCriteria(Book.class);
		cr.createCriteria("bookPublisher").add(Restrictions.like("publisherName", "%"+bookPublisherName+"%"));					
		Object result = cr.list();
		List<Book> books = (List<Book>) result;
		return books;
	}

	@Override
	public List<Book> findBookByCategory(String bookCategoryName) {
		Criteria cr = getSession().createCriteria(Book.class);
		cr.createCriteria("bookCategory").add(Restrictions.like("categoryName", "%"+bookCategoryName+"%"));					
		Object result = cr.list();
		List<Book> books = (List<Book>) result;
		return books;
	}

}
