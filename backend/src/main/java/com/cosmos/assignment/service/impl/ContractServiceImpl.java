package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.ContractDao;
import com.cosmos.assignment.domain.entity.Contract;
import com.cosmos.assignment.domain.entity.Moderator;
import com.cosmos.assignment.service.ContractService;
import com.cosmos.assignment.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{

	@Inject
	private ContractDao contractDao;
	
	@Override
	@Transactional
	public void addContract(Contract contract) {
		int id = findAllContract().size() + 1;
		contract.setContractNumber(Util.generateId("Contract",id));
		contractDao.add(contract);
	}

	@Override
	@Transactional
	public void updateContractUpdatedDate(Contract contract) {
		contractDao.update(contract);
	}

	@Override
	@Transactional
	public void updateContractVoidedDate(Contract contract) {
		contractDao.update(contract);
	}

	@Override
	@Transactional
	public void updateContractStatus(Contract contract) {
		contractDao.update(contract);
	}

	@Override
	@Transactional
	public void approveContract(Contract contract) {
		contractDao.update(contract);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contract> findUserContracts(String userId) {
		return contractDao.findUserContracts(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public Date getContractCreatedDate(String contractNumber) {
		return contractDao.getContractCreatedDate(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public Date getContractUpdatedDate(String contractNumber) {
		return contractDao.getContractUpdatedDate(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public Date getContractVoidedDate(String contractNumber) {
		return contractDao.getContractVoidedDate(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public int getContractStatus(String contractNumber) {
		return contractDao.getContractStatus(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public Moderator getContractApprovedBy(String contractNumber) {
		return contractDao.getContractApprovedBy(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public String getContractPaymentMethod(String contractNumber) {
		return contractDao.getContractPaymentMethod(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contract> findAllContract() {
		return contractDao.findAllContract();
	}

	@Override
	@Transactional
	public Contract getContractById(String id) {
		return contractDao.getById(id);
	}
}
