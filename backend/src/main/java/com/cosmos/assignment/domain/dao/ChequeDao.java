package com.cosmos.assignment.domain.dao;

import com.cosmos.assignment.domain.entity.Cheque;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChequeDao extends GenericDao<Cheque, String>{
	public List<Cheque> getCheques(final String userId);
	public double getChequeAmt(final String contractNumber);
	public int getChequeStatus(final String contractNumber);
	public String getChequeNumber(final String contractNumber);
}
