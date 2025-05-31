package com.cosmos.assignment.web.webform;

public class ContractForm {
	private String userId;
	private String paymentMethod;
	private String[] booksId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String[] getBooksId() {
		return booksId;
	}
	public void setBooksId(String[] booksId) {
		this.booksId = booksId;
	}
}
