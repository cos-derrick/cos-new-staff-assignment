package com.cosmos.assignment.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="JEFF_CHEE_CASH_ACCT_TRANS")
public class CashAcctTrans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8046649039204183073L;
	@Id
	@OneToOne(fetch= FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	@Column
	@JoinColumn(name="CASH_ACCT_TRANS_CONTRACT")
	private Contract cashAcctTransContract;
	@ManyToOne
	@JoinColumn(name="CASH_ACCT_TRANS_USER")
	private User cashAcctTransUser;
	@Column(name="CASH_ACCT_TRANS_AMT")
	private double castAcctTransAmt;
	@Column(name="CASH_ACCT_TRANS_REMARKS")
	private String cashAcctTransRemarks;
	@Column(name="CASH_ACCT_TRANS_CREATED_DATE")
	private Date cashAcctTransCreatedDate;
	
	public Contract getCashAcctTransContract() {
		return cashAcctTransContract;
	}
	public void setCashAcctTransContract(Contract cashAcctTransContract) {
		this.cashAcctTransContract = cashAcctTransContract;
	}
	public User getCashAcctTransUser() {
		return cashAcctTransUser;
	}
	public void setCashAcctTransUser(User cashAcctTransUser) {
		this.cashAcctTransUser = cashAcctTransUser;
	}
	public double getCastAcctTransAmt() {
		return castAcctTransAmt;
	}
	public void setCastAcctTransAmt(double castAcctTransAmt) {
		this.castAcctTransAmt = castAcctTransAmt;
	}
	public String getCashAcctTransRemarks() {
		return cashAcctTransRemarks;
	}
	public void setCashAcctTransRemarks(String cashAcctTransRemarks) {
		this.cashAcctTransRemarks = cashAcctTransRemarks;
	}
	public Date getCashAcctTransCreatedDate() {
		return cashAcctTransCreatedDate;
	}
	public void setCashAcctTransCreatedDate(Date cashAcctTransCreatedDate) {
		this.cashAcctTransCreatedDate = cashAcctTransCreatedDate;
	}
}
