package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.CashAcctTrans;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CashAcctTransDao extends GenericDao<CashAcctTrans, String>{
	public List<CashAcctTrans> getCashAcctTransByUserId(final String userId);
	public double getCashAcctTransAmt(final String contractNumber);
	public String getCashAcctTransRemarks(final String contractNumber);
	public Date getCashAcctTransCreatedDate(final String contractNumber);
}
