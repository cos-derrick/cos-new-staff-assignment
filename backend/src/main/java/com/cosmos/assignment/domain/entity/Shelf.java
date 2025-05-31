package com.cosmos.assignment.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "JEFF_CHEE_SHELF")
public class Shelf implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6766692678446152759L;
	@Id
	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
	@JoinColumn(name = "SHELF_USER")
	private User shelfUser;
	@Column(name = "SHELF_NUMBER_OF_BOOK")
	private int shelfNumberOfBook;
	@Column(name = "SHELF_LAST_ACCESS_DATE")
	private Date shelfLastAccessDate;
	@Column(name = "SHELF_NUMBER_OF_ACCESS")
	private int shelfNumberOfAccess;

	//Composite Table
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "JEFF_CHEE_SHELF_BOOK", joinColumns = { @JoinColumn(name = "SHELF_BOOK_USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SHELF_BOOK_BOOK_ID") })
	private Set<Book> books = new HashSet<Book>();

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> listBooks) {
		Set<Book> books= new HashSet<Book>(listBooks);
		this.books = books;
	}
	
	public User getShelfUser() {
		return shelfUser;
	}

	public void setShelfUser(User shelfUser) {
		this.shelfUser = shelfUser;
	}

	public int getShelfNumberOfBook() {
		return shelfNumberOfBook;
	}

	public void setShelfNumberOfBook(int shelfNumberOfBook) {
		this.shelfNumberOfBook = shelfNumberOfBook;
	}

	public Date getShelfLastAccessDate() {
		return shelfLastAccessDate;
	}

	public void setShelfLastAccessDate(Date shelfLastAccessDate) {
		this.shelfLastAccessDate = shelfLastAccessDate;
	}

	public int getShelfNumberOfAccess() {
		return shelfNumberOfAccess;
	}

	public void setShelfNumberOfAccess(int shelfNumberOfAccess) {
		this.shelfNumberOfAccess = shelfNumberOfAccess;
	}
}
