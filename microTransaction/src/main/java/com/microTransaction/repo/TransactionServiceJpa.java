package com.microTransaction.repo;

import java.util.List;

import com.microTransaction.entity.Transaction;
import com.microTransaction.service.TransactService;

public class TransactionServiceJpa implements TransactService {

	@Override
	public Transaction transferamount(double amount, long firspoint, long endpoint) {
		return null;
	}

	@Override
	public List<Transaction> listAll() {
		return null;
	}

}
