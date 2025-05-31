package com.cosmos.assignment.web.webform;

public class BookForm {
	private String bookId;
	private String bookSubject;
	private String bookDescription;
	private String bookIsbn;
	private String bookContent;
	private int bookContentType;
	private String authorId;
	private String publisherId;
	private String categoryId;
	private String createdDate;
	private double bookPrice;
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
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "BookForm [bookId=" + bookId + ", bookSubject=" + bookSubject + ", bookDescription=" + bookDescription
				+ ", bookIsbn=" + bookIsbn + ", bookContent=" + bookContent + ", bookContentType=" + bookContentType
				+ ", authorId=" + authorId + ", publisherId=" + publisherId + ", categoryId=" + categoryId
				+ ", createdDate=" + createdDate + ", bookPrice=" + bookPrice + "]";
	}
}
