package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Author;

public interface AuthorDao extends GenericDao<Author, String>{
	public String getAuthorName(final String authorId);
	public String getAuthorEmail(final String authorId);
	public String getAuthorCountry(final String authorId);
}
