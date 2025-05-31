package com.cosmos.assignment.service.impl;

import com.cosmos.assignment.domain.dao.ChequeDao;
import com.cosmos.assignment.domain.entity.Cheque;
import com.cosmos.assignment.service.ChequeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ChequeServiceImpl implements ChequeService{
	
	@Inject
	private ChequeDao chequeDao;

	@Override
	@Transactional
	public void addCheque(Cheque cheque) {
		chequeDao.add(cheque);
	}

	@Override
	@Transactional
	public void updateCheque(Cheque cheque) {
		chequeDao.update(cheque);
	}

	@Override
	@Transactional
	public void approveCheque(Cheque cheque) {
		chequeDao.update(cheque);
	}

	@Override
	@Transactional
	public void updateApprovedDate(Cheque cheque) {
		chequeDao.update(cheque);
	}

	@Override
	@Transactional
	public void updateChequeStatus(Cheque cheque) {
		chequeDao.update(cheque);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cheque> getCheques(String userId) {
		return chequeDao.getCheques(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public double getChequeAmt(String contractNumber) {
		return chequeDao.getChequeAmt(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public int getChequeStatus(String contractNumber) {
		return chequeDao.getChequeStatus(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public String getChequeNumber(String contractNumber) {
		return chequeDao.getChequeNumber(contractNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cheque> findAllCheque() {
		return chequeDao.findAll();
	}

	@Override
	@Transactional
	public Cheque getChequeById(String id) {
		return chequeDao.getById(id);
	}
}
