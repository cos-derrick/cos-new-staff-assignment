package com.cosmos.assignment.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="JEFF_CHEE_CHEQUE")
public class Cheque implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -65104853464683966L;
	@Id
	@Column(name="CHEQUE_CONTRACT")
	private String chequeContract;
	@ManyToOne
	@JoinColumn(name="CHEQUE_USER")
	private User chequeUser;
	@Column(name="CHEQUE_CREATED_DATE")
	private Date chequeCreatedDate;
	@Column(name="CHEQUE_AMT")
	private double chequeAmt;
	@Column(name="CHEQUE_STATUS")
	private String chequeStatus;
	@Column(name="CHEQUE_APPROVED_DATE")
	private Date chequeApprovedDate;
	@ManyToOne
	@JoinColumn(name="CHEQUE_APPROVED_BY")
	private Moderator chequeApprovedBy;
	@Column(name="CHEQUE_NUMBER")
	private String chequeNumber;
	
	public String getChequeContract() {
		return chequeContract;
	}
	public void setChequeContract(String chequeContract) {
		this.chequeContract = chequeContract;
	}
	public User getChequeUser() {
		return chequeUser;
	}
	public void setChequeUser(User chequeUser) {
		this.chequeUser = chequeUser;
	}
	public Date getChequeCreatedDate() {
		return chequeCreatedDate;
	}
	public void setChequeCreatedDate(Date chequeCreatedDate) {
		this.chequeCreatedDate = chequeCreatedDate;
	}
	public double getChequeAmt() {
		return chequeAmt;
	}
	public void setChequeAmt(double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	public Date getChequeApprovedDate() {
		return chequeApprovedDate;
	}
	public void setChequeApprovedDate(Date chequeApprovedDate) {
		this.chequeApprovedDate = chequeApprovedDate;
	}
	public Moderator getChequeApprovedBy() {
		return chequeApprovedBy;
	}
	public void setChequeApprovedBy(Moderator chequeApprovedBy) {
		this.chequeApprovedBy = chequeApprovedBy;
	}
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
}
