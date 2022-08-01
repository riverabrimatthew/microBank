package com.microTransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microTransaction.entity.Transaction;
import com.microTransaction.service.TransactService;


@Controller
public class TransactionController {
	
	@Autowired
	private TransactService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Transaction> listOfTransacs = service.listAll();
		model.addAttribute("listtransaction", listOfTransacs);
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model){
		model.addAttribute("transaction", new Transaction());
		return "new";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savetransfer(@ModelAttribute Transaction trnsc,Model model)
	{
		Transaction trnscion= service.transferamount(trnsc.getAmount(),trnsc.getFirstpoint(),trnsc.getEndpoint());
		model.addAttribute("transactionService",trnscion);
		return "redirect:/";
	
	}
}