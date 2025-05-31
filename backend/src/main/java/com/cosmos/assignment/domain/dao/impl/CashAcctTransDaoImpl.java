package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.CashAcctTransDao;
import com.cosmos.assignment.domain.entity.CashAcctTrans;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CashAcctTransDaoImpl extends AbstractGenericDao<CashAcctTrans, String> implements CashAcctTransDao{
	private final static String TABLE = "JEFF_CHEE_CASH_ACCT_TRANS";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CashAcctTrans> getCashAcctTransByUserId(String userId) {
		Query query = getSession().createQuery("SELECT * FROM "+ TABLE +" WHERE CASH_ACCT_TRANS_USER = "+ userId);
		List<CashAcctTrans> list = query.list();
		return list;
	}

	@Override
	public double getCashAcctTransAmt(String contractNumber) {
		Query query = getSession().createQuery("SELECT CASH_ACCT_TRANS_AMT FROM "+ TABLE +" WHERE CASH_ACCT_TRANS_CONTRACT = "+ contractNumber);
		double result = (double) query.uniqueResult();
		return result;
	}

	@Override
	public String getCashAcctTransRemarks(String contractNumber) {
		Query query = getSession().createQuery("SELECT CASH_ACCT_TRANS_REMARKS FROM "+ TABLE +" WHERE CASH_ACCT_TRANS_CONTRACT = "+ contractNumber);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public Date getCashAcctTransCreatedDate(String contractNumber) {
		Query query = getSession().createQuery("SELECT CASH_ACCT_TRANS_CREATED_DATE FROM "+ TABLE +" WHERE CASH_ACCT_TRANS_CONTRACT = "+ contractNumber);
		Date result = (Date) query.uniqueResult();
		return result;
	}

}
