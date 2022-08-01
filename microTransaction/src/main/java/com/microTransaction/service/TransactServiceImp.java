package com.microTransaction.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microTransaction.entity.Transaction;
import com.microTransaction.entity.User;
import com.microTransaction.repo.TransactionRepository;
import com.microTransaction.repo.UserRepository;

@Service
@Transactional
public class TransactServiceImp implements TransactService{


	@Autowired
	TransactionRepository transRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Transaction transferamount(double amnt, long firstpoint, long endpoint) {
		
		Optional <User> userGET=userRepo.findByAccountnumber(firstpoint);
		Optional <User> userPOST=userRepo.findByAccountnumber(endpoint);
		User giver= userGET.get();
		User recipient= userPOST.get();
		if(giver.getAccountnumber() == recipient.getAccountnumber()) {
			return null;
		}else if(amnt < giver.getTotalbalance()) {
			giver.setTotalbalance(giver.getTotalbalance()-amnt);
			userRepo.save(giver);
			recipient.setTotalbalance(recipient.getTotalbalance()+amnt);
			userRepo.save(recipient);
			Transaction newTrnsc =new Transaction();
			newTrnsc.setFirstpoint(giver.getAccountnumber());
			newTrnsc.setEndpoint(recipient.getAccountnumber());
			newTrnsc.setTransactdate(new Date(System.currentTimeMillis()));
			newTrnsc.setAmount(amnt);
			
			transRepo.save(newTrnsc);
			return newTrnsc;			
		}else {
			return null;
		}		
	
	}

	@Override
	public List<Transaction> listAll() {
		return transRepo.findAll();
	}
	
}
