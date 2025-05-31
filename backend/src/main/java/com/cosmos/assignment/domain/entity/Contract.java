package com.cosmos.assignment.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "JEFF_CHEE_CONTRACT")
public class Contract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7923044435045524857L;
	@Id
	@Column(name = "CONTRACT_NUMBER")
	private String contractNumber;
	@ManyToOne
	@JoinColumn(name = "CONTRACT_USER")
	private User contractUser;
	@Column(name = "CONTRACT_CREATED_DATE")
	private Date contractCreatedDate;
	@Column(name = "CONTRACT_UPDATED_DATE")
	private Date contractUpdatedDate;
	@Column(name = "CONTRACT_VOIDED_DATE")
	private Date contractVoidedDate;
	@Column(name = "CONTRACT_STATUS")
	private String contractStatus;
	@ManyToOne
	@JoinColumn(name = "CONTRACT_APPROVED_BY")
	private Moderator contractApprovedBy;
	@Column(name = "CONTRACT_PAYMENT_METHOD")
	private String contractPaymentMethod;

	// Composite Table
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "JEFF_CHEE_CONTRACT_BOOK", joinColumns = {
			@JoinColumn(name = "CONTRACT_BOOK_CONTRACT_NUMBER") }, inverseJoinColumns = {
					@JoinColumn(name = "CONTRACT_BOOK_BOOK_ID") })
	private Set<Book> books = new HashSet<Book>();

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public User getContractUser() {
		return contractUser;
	}

	public void setContractUser(User contractUser) {
		this.contractUser = contractUser;
	}

	public Date getContractCreatedDate() {
		return contractCreatedDate;
	}

	public void setContractCreatedDate(Date contractCreatedDate) {
		this.contractCreatedDate = contractCreatedDate;
	}

	public Date getContractUpdatedDate() {
		return contractUpdatedDate;
	}

	public void setContractUpdatedDate(Date contractUpdatedDate) {
		this.contractUpdatedDate = contractUpdatedDate;
	}

	public Date getContractVoidedDate() {
		return contractVoidedDate;
	}

	public void setContractVoidedDate(Date contractVoidedDate) {
		this.contractVoidedDate = contractVoidedDate;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Moderator getContractApprovedBy() {
		return contractApprovedBy;
	}

	public void setContractApprovedBy(Moderator contractApprovedBy) {
		this.contractApprovedBy = contractApprovedBy;
	}

	public String getContractPaymentMethod() {
		return contractPaymentMethod;
	}

	public void setContractPaymentMethod(String contractPaymentMethod) {
		this.contractPaymentMethod = contractPaymentMethod;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (contractApprovedBy == null) {
			if (other.contractApprovedBy != null)
				return false;
		} else if (!contractApprovedBy.equals(other.contractApprovedBy))
			return false;
		if (contractCreatedDate == null) {
			if (other.contractCreatedDate != null)
				return false;
		} else if (!contractCreatedDate.equals(other.contractCreatedDate))
			return false;
		if (contractNumber == null) {
			if (other.contractNumber != null)
				return false;
		} else if (!contractNumber.equals(other.contractNumber))
			return false;
		if (contractPaymentMethod == null) {
			if (other.contractPaymentMethod != null)
				return false;
		} else if (!contractPaymentMethod.equals(other.contractPaymentMethod))
			return false;
		if (contractStatus != other.contractStatus)
			return false;
		if (contractUpdatedDate == null) {
			if (other.contractUpdatedDate != null)
				return false;
		} else if (!contractUpdatedDate.equals(other.contractUpdatedDate))
			return false;
		if (contractUser == null) {
			if (other.contractUser != null)
				return false;
		} else if (!contractUser.equals(other.contractUser))
			return false;
		if (contractVoidedDate == null) {
			if (other.contractVoidedDate != null)
				return false;
		} else if (!contractVoidedDate.equals(other.contractVoidedDate))
			return false;
		return true;
	}
	
	
}
