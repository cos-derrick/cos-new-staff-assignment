package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.CashAcctTransDao;
import com.cosmos.assignment.domain.entity.CashAcctTrans;
import com.cosmos.assignment.service.CashAcctTransService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class CashAcctTransServiceImpl implements CashAcctTransService{

	@Inject
	private CashAcctTransDao cashAcctTransDao;
	
	@Override
	@Transactional
	public void addCashAcctTrans(CashAcctTrans cashAcctTrans) {
		cashAcctTransDao.add(cashAcctTrans);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CashAcctTrans> getCashAcctTransByUserId(String userId) {
		return cashAcctTransDao.getCashAcctTransByUserId(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public double getCashAcctTransAmt(String contractNumber) {
		return cashAcctTransDao.getCashAcctTransAmt(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public String getCashAcctTransRemarks(String contractNumber) {
		return cashAcctTransDao.getCashAcctTransRemarks(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public Date getCashAcctTransCreatedDate(String contractNumber) {
		return cashAcctTransDao.getCashAcctTransCreatedDate(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CashAcctTrans> findAllCashAcctTrans() {
		return cashAcctTransDao.findAll();
	}

	@Override
	@Transactional
	public CashAcctTrans getCashAcctTransById(String id) {
		return cashAcctTransDao.getById(id);
	}

}
