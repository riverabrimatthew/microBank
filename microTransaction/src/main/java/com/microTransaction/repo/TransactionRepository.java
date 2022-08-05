package com.microTransaction.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microTransaction.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	Transaction findTransactionById(Long id);

	List<Transaction> findByFirstpoint (long firstpoint);
	
}
