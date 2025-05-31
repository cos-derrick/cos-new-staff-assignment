package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.ChequeDao;
import com.cosmos.assignment.domain.entity.Cheque;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChequeDaoImpl extends AbstractGenericDao<Cheque, String> implements ChequeDao{
	private final static String TABLE = "JEFF_CHEE_CHEQUE";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cheque> getCheques(String userId) {
		Query query = getSession().createQuery("SELECT * FROM "+ TABLE +" WHERE CHEQUE_USER = "+ userId);
		List<Cheque> list = query.list();
		return list;
	}

	@Override
	public double getChequeAmt(String contractNumber) {
		Query query = getSession().createQuery("SELECT CHEQUE_AMT FROM "+ TABLE +" WHERE CHEQUE_CONTRACT = "+ contractNumber);
		double result = (double) query.uniqueResult();
		return result;
	}

	@Override
	public int getChequeStatus(String contractNumber) {
		Query query = getSession().createQuery("SELECT CHEQUE_STATUS FROM "+ TABLE +" WHERE CHEQUE_CONTRACT = "+ contractNumber);
		int result = (int) query.uniqueResult();
		return result;
	}

	@Override
	public String getChequeNumber(String contractNumber) {
		Query query = getSession().createQuery("SELECT CHEQUE_NUMBER FROM "+ TABLE +" WHERE CHEQUE_CONTRACT = "+ contractNumber);
		String result = (String) query.uniqueResult();
		return result;
	}
}
