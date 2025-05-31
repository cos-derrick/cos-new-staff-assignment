package com.cosmos.assignment.domain.dao.impl;

import com.cosmos.assignment.domain.dao.ContractDao;
import com.cosmos.assignment.domain.entity.Contract;
import com.cosmos.assignment.domain.entity.Moderator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ContractDaoImpl extends AbstractGenericDao<Contract, String> implements ContractDao{
	private final static String TABLE = "JEFF_CHEE_CONTRACT";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findUserContracts(String userId) {
		Criteria cr = getSession().createCriteria(Contract.class)
				.add(Restrictions.eq("contractUser.userId", userId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		Object contracts = cr.list();
		List<Contract> result = (List<Contract>) contracts;
		return result;
	}

	@Override
	public int getContractStatus(String contractNumber) {
		Query query = getSession().createQuery("SELECT CONTRACT_STATUS FROM "+ TABLE +" WHERE CONTRACT_NUMBER = "+ contractNumber);
		int result = (int) query.uniqueResult();
		return result;
	}

	@Override
	public String getContractPaymentMethod(String contractNumber) {
		Query query = getSession().createQuery("SELECT CONTRACT_PAYMENT_METHOD FROM "+ TABLE +" WHERE CONTRACT_NUMBER = "+ contractNumber);
		String result = (String) query.uniqueResult();
		return result;
	}

	@Override
	public Date getContractCreatedDate(String contractNumber) {
		Query query = getSession().createQuery("SELECT CONTRACT_CREATED_DATE FROM "+ TABLE +" WHERE CONTRACT_NUMBER = "+ contractNumber);
		Date result = (Date) query.uniqueResult();
		return result;
	}

	@Override
	public Date getContractUpdatedDate(String contractNumber) {
		Query query = getSession().createQuery("SELECT CONTRACT_UPDATED_DATE FROM "+ TABLE +" WHERE CONTRACT_NUMBER = "+ contractNumber);
		Date result = (Date) query.uniqueResult();
		return result;
	}

	@Override
	public Date getContractVoidedDate(String contractNumber) {
		Query query = getSession().createQuery("SELECT CONTRACT_VOIDED_DATE FROM "+ TABLE +" WHERE CONTRACT_NUMBER = "+ contractNumber);
		Date result = (Date) query.uniqueResult();
		return result;
	}

	@Override
	public Moderator getContractApprovedBy(String contractNumber) {
		Query query = getSession().createQuery("SELECT CONTRACT_APPROVED_BY FROM "+ TABLE +" WHERE CONTRACT_NUMBER = "+ contractNumber);
		Moderator result = (Moderator) query.uniqueResult();
		return result;
	}

	@Override
	public List<Contract> findAllContract() {
		Criteria cr = getSession().createCriteria(Contract.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		Object contracts = cr.list();
		List<Contract> result = (List<Contract>) contracts;
		return result;
	}

}
