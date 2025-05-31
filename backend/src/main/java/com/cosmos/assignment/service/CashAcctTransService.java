package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.CashAcctTrans;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface CashAcctTransService {
	
	public void addCashAcctTrans(CashAcctTrans cashAcctTrans);
	
	public List<CashAcctTrans> getCashAcctTransByUserId(final String userId);
	public double getCashAcctTransAmt(final String contractNumber);
	public String getCashAcctTransRemarks(final String contractNumber);
	public Date getCashAcctTransCreatedDate(final String contractNumber);
	
	public List<CashAcctTrans> findAllCashAcctTrans();
	public CashAcctTrans getCashAcctTransById(final String id);
}
