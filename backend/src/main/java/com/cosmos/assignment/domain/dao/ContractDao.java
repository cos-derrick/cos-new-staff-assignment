package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Contract;
import com.cosmos.assignment.domain.entity.Moderator;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractDao extends GenericDao<Contract, String>{
	public List<Contract> findUserContracts(final String userId);
	public Date getContractCreatedDate(final String contractNumber);
	public Date getContractUpdatedDate(final String contractNumber);
	public Date getContractVoidedDate(final String contractNumber);
	public int getContractStatus(final String contractNumber);
	public Moderator getContractApprovedBy(final String contractNumber);
	public String getContractPaymentMethod(final String contractNumber);
	
	public List<Contract> findAllContract();
}
