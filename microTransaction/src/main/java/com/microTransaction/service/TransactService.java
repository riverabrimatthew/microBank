package com.microTransaction.service;

import java.util.List;

import com.microTransaction.entity.Transaction;

public interface TransactService {

	public Transaction transferamount(double amount, long firstpoint, long endpoint);

	public List<Transaction> listAll();

	
}
