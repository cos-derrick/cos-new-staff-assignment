package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Author;

import java.util.List;

public interface AuthorService {
	public void addAuthor(Author author);
	public void updateAuthor(Author author);
//	public void deleteAuthor(Author author);
	
	public String getAuthorName(final String authorId);
	public String getAuthorEmail(final String authorId);
	public String getAuthorCountry(final String authorId);
	
	public List<Author> findAllAuthor();
	public Author getAuthorById(final String id);
}
