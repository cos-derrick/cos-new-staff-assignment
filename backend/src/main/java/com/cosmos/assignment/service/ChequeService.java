package com.cosmos.assignment.service;

import com.cosmos.assignment.domain.entity.Cheque;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ChequeService {
	void addCheque(final Cheque cheque);
	void updateCheque(final Cheque cheque);
	void approveCheque(final Cheque cheque);
	void updateApprovedDate(final Cheque cheque);
	void updateChequeStatus(final Cheque cheque);
	
	public List<Cheque> getCheques(final String userId);
	public double getChequeAmt(final String contractNumber);
	public int getChequeStatus(final String contractNumber);
	public String getChequeNumber(final String contractNumber);
	
	public List<Cheque> findAllCheque();
	public Cheque getChequeById(final String id);
}
