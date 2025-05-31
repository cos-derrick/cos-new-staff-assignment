package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Contract;
import com.cosmos.assignment.domain.entity.Moderator;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface ContractService {
	public void addContract(Contract contract);
	public void updateContractUpdatedDate(Contract contract);
	public void updateContractVoidedDate(Contract contract);
	public void updateContractStatus(Contract contract);
	public void approveContract(Contract contract);
	
	public List<Contract> findUserContracts(final String userId);
	public Date getContractCreatedDate(final String contractNumber);
	public Date getContractUpdatedDate(final String contractNumber);
	public Date getContractVoidedDate(final String contractNumber);
	public int getContractStatus(final String contractNumber);
	public Moderator getContractApprovedBy(final String contractNumber);
	public String getContractPaymentMethod(final String contractNumber);
	
	public List<Contract> findAllContract();
	public Contract getContractById(final String id);
}
