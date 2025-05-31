package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Author;
import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Category;
import com.cosmos.assignment.domain.entity.Publisher;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface BookService {
	public void addBook(Book book);
	public void updateBook(Book book);
	
	public String getBookSubject(final String bookId);
	public String getBookDesciption(final String bookId);
	public String getBookIsbn(final String bookId);
	public String getBookContent(final String bookId);
	public int getBookContentType(final String bookId);
	public Author getBookAuthor(final String bookId);
	public Publisher getBookPublisher(final String bookId);
	public Category getBookCategory(final String bookId);
	public Date getBookCreatedDate(final String bookId);
	public double getBookPrice(final String bookId);
	
	public List<Book> findAllBook();
	public Book getBookById(final String id);
	public List<Book> findBookBySubject(final String bookSubject);
	public List<Book> findBookByAuthor(final String bookAuthorName);
	public List<Book> findBookByPublisher(final String bookPublisherName);
	public List<Book> findBookByCategory(final String bookCategoryName);
}
