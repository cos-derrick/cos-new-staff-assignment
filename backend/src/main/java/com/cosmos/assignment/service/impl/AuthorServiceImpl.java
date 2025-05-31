package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.AuthorDao;
import com.cosmos.assignment.domain.entity.Author;
import com.cosmos.assignment.service.AuthorService;
import com.cosmos.assignment.util.Util;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Repository
@Service("authorService")
public class AuthorServiceImpl implements AuthorService{

	@Inject
	private AuthorDao authorDao;

	@Override
	@Transactional
	public void addAuthor(Author author) {
		int id = findAllAuthor().size() + 1;
		author.setAuthorId(Util.generateId("Author",id));
		authorDao.add(author);
	}

	@Override
	@Transactional
	public void updateAuthor(Author author) {
		authorDao.update(author);
	}

	@Override
	@Transactional(readOnly = true)
	public String getAuthorName(String authorId) {
		return authorDao.getAuthorName(authorId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getAuthorEmail(String authorId) {
		return authorDao.getAuthorEmail(authorId);
	}

	@Override
	@Transactional(readOnly = true)
	public String getAuthorCountry(String authorId) {
		return authorDao.getAuthorCountry(authorId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Author> findAllAuthor() {
		return authorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Author getAuthorById(String id) {
		return authorDao.getById(id);
	}
}
