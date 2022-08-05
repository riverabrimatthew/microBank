package com.microTransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microTransaction.entity.Transaction;
import com.microTransaction.service.TransactionService;


@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	
	@GetMapping("/")
	public String viewTransactList(Model model) {
		List<Transaction> listOfTransacs = service.listAll();
		model.addAttribute("listtransaction", listOfTransacs);
		return "index";
	}
	
	@GetMapping("/transactList")
	public String findByFirstPoint(@ModelAttribute Transaction trnsc, @RequestParam("firstpoint") long firstpoint, Model model) {
		List<Transaction> listOfTransacs = service.findByFirstpoint(trnsc.getFirstpoint());
		model.addAttribute("listtransaction", listOfTransacs);
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model){
		model.addAttribute("transaction", new Transaction());		
		return "new";
	}
	
	@PostMapping("/save")
	public String savetransfer(@ModelAttribute Transaction trnsc)
	{
		Transaction trnscion= service.transferamount(trnsc.getAmount(),trnsc.getFirstpoint(),trnsc.getEndpoint());
		if(trnscion != null) {
			return "redirect:/transactList?firstpoint="+trnsc.getFirstpoint();
		}else {
			return "error";
		}
		
	}
}