package com.cosmos.assignment.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "JEFF_CHEE_BOOK")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2017994013991962410L;
	@Id
	@Column(name = "BOOK_ID")
	private String bookId;
	@Column(name = "BOOK_SUBJECT")
	private String bookSubject;
	@Column(name = "BOOK_DESCRIPTION")
	private String bookDescription;
	@Column(name = "BOOK_ISBN")
	private String bookIsbn;
	@Column(name = "BOOK_CONTENT")
	private String bookContent;
	@Column(name = "BOOK_CONTENT_TYPE")
	private int bookContentType;
	@ManyToOne
	@JoinColumn(name = "BOOK_AUTHOR")
	private Author bookAuthor;
	@ManyToOne
	@JoinColumn(name = "BOOK_PUBLISHER")
	private Publisher bookPublisher;
	@ManyToOne
	@JoinColumn(name = "BOOK_CATEGORY")
	private Category bookCategory;
	@Column(name = "BOOK_CREATED_DATE")
	private Date bookCreatedDate;
	@Column(name = "BOOK_PRICE")
	private double bookPrice;

	// Composite table
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private Set<Shelf> shelves = new HashSet<Shelf>();

	@JsonIgnore
	public Set<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(Set<Shelf> shelves) {
		this.shelves = shelves;
	}

	// Composite table
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private Set<Contract> contracts = new HashSet<Contract>();

	@JsonIgnore
	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookContent() {
		return bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public int getBookContentType() {
		return bookContentType;
	}

	public void setBookContentType(int bookContentType) {
		this.bookContentType = bookContentType;
	}

	public Author getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Publisher getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(Publisher bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Category getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Date getBookCreatedDate() {
		return bookCreatedDate;
	}

	public void setBookCreatedDate(Date bookCreatedDate) {
		this.bookCreatedDate = bookCreatedDate;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookSubject=" + bookSubject + ", bookDescription=" + bookDescription
				+ ", bookIsbn=" + bookIsbn + ", bookContent=" + bookContent + ", bookContentType=" + bookContentType
				+ ", bookAuthor=" + bookAuthor + ", bookPublisher=" + bookPublisher + ", bookCategory=" + bookCategory
				+ ", bookCreatedDate=" + bookCreatedDate + ", bookPrice=" + bookPrice + ", shelves=" + shelves
				+ ", contracts=" + contracts + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookCategory == null) {
			if (other.bookCategory != null)
				return false;
		} else if (!bookCategory.equals(other.bookCategory))
			return false;
		if (bookContent == null) {
			if (other.bookContent != null)
				return false;
		} else if (!bookContent.equals(other.bookContent))
			return false;
		if (bookContentType != other.bookContentType)
			return false;
		if (bookCreatedDate == null) {
			if (other.bookCreatedDate != null)
				return false;
		} else if (!bookCreatedDate.equals(other.bookCreatedDate))
			return false;
		if (bookDescription == null) {
			if (other.bookDescription != null)
				return false;
		} else if (!bookDescription.equals(other.bookDescription))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookIsbn == null) {
			if (other.bookIsbn != null)
				return false;
		} else if (!bookIsbn.equals(other.bookIsbn))
			return false;
		if (Double.doubleToLongBits(bookPrice) != Double.doubleToLongBits(other.bookPrice))
			return false;
		if (bookPublisher == null) {
			if (other.bookPublisher != null)
				return false;
		} else if (!bookPublisher.equals(other.bookPublisher))
			return false;
		if (bookSubject == null) {
			if (other.bookSubject != null)
				return false;
		} else if (!bookSubject.equals(other.bookSubject))
			return false;
		if (contracts == null) {
			if (other.contracts != null)
				return false;
		} else if (!contracts.equals(other.contracts))
			return false;
		if (shelves == null) {
			if (other.shelves != null)
				return false;
		} else if (!shelves.equals(other.shelves))
			return false;
		return true;
	}
	
}
