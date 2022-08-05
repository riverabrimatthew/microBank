package com.microTransaction.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microTransaction.entity.Transaction;
import com.microTransaction.entity.User;
import com.microTransaction.repo.TransactionRepository;
import com.microTransaction.repo.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactRepo;

	@Autowired
	UserRepository userRepo;
	
	public List<Transaction> listAll() {
		return transactRepo.findAll();
	}

	public Transaction transferamount(double amount, long firstpoint, long endpoint) {
		Optional <User> userGET=userRepo.findByAccountnumber(firstpoint);
		Optional <User> userPOST=userRepo.findByAccountnumber(endpoint);
		if(userGET.isPresent() && userPOST.isPresent()) {
			User giver= userGET.get();
			User recipient= userPOST.get();
				if(giver.getAccountnumber() == recipient.getAccountnumber()) {
					return null;
				}else if(amount < giver.getTotalbalance()) {
					giver.setTotalbalance(giver.getTotalbalance()-amount);
					userRepo.save(giver);
					recipient.setTotalbalance(recipient.getTotalbalance()+amount);
					userRepo.save(recipient);
					Transaction newTrnsc =new Transaction();
					newTrnsc.setFirstpoint(giver.getAccountnumber());
					newTrnsc.setEndpoint(recipient.getAccountnumber());
					newTrnsc.setTransactdate(new Date(System.currentTimeMillis()));
					newTrnsc.setAmount(amount);
					
					transactRepo.save(newTrnsc);
					return newTrnsc;			
				}else {
					return null;
				}	
			}else {
				return null;
			}
		}

	public List<Transaction> findByFirstpoint(long firstpoint) {
		return transactRepo.findByFirstpoint(firstpoint);
	}
	
}
	
	


