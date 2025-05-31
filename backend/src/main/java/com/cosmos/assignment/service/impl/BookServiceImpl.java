package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.BookDao;
import com.cosmos.assignment.domain.entity.Author;
import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Category;
import com.cosmos.assignment.domain.entity.Publisher;
import com.cosmos.assignment.service.BookService;
import com.cosmos.assignment.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

	@Inject 
	private BookDao bookDao;
	
	@Override
	@Transactional
	public void addBook(Book book) {
		int id = findAllBook().size() + 1;
		book.setBookId(Util.generateId("Book",id));
		bookDao.add(book);
	}

	@Override
	@Transactional
	public void updateBook(Book book) {
		bookDao.update(book);
	}

	@Override
	@Transactional(readOnly = true)
	public String getBookSubject(String bookId) {
		return bookDao.getBookSubject(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getBookDesciption(String bookId) {
		return bookDao.getBookDesciption(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getBookIsbn(String bookId) {
		return bookDao.getBookIsbn(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getBookContent(String bookId) {
		return bookDao.getBookContent(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public int getBookContentType(String bookId) {
		return bookDao.getBookContentType(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public Author getBookAuthor(String bookId) {
		return bookDao.getBookAuthor(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public Publisher getBookPublisher(String bookId) {
		return bookDao.getBookPublisher(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public Category getBookCategory(String bookId) {
		return bookDao.getBookCategory(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public Date getBookCreatedDate(String bookId) {
		return bookDao.getBookCreatedDate(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public double getBookPrice(String bookId) {
		return bookDao.getBookPrice(bookId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> findAllBook() {
		return bookDao.findAllBook();
	}

	@Override
	@Transactional(readOnly = true)
	public Book getBookById(String id) {
		return bookDao.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> findBookBySubject(String bookSubject) {
		return bookDao.findBookBySubject(bookSubject);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> findBookByAuthor(String bookAuthorName) {
		return bookDao.findBookByAuthor(bookAuthorName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> findBookByPublisher(String bookPublisherName) {
		return bookDao.findBookByPublisher(bookPublisherName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> findBookByCategory(String bookCategoryName) {
		return bookDao.findBookByCategory(bookCategoryName);
	}
}
