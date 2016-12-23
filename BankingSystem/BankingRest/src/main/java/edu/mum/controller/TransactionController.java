package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Transaction;
import edu.mum.service.TransactionService;

@RestController
@RequestMapping({"/transactions"})
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
 
 	@RequestMapping({"","/all"})
	public List<Transaction> list(Model model) {
		return  transactionService.getAllTransactions();
 
	}
	
 	@RequestMapping("/{id}")
	public Transaction getTransactionById( @PathVariable("id") Long transactionId) {

		return transactionService.get(transactionId);
 	}

	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Transaction processAddNewTransactionForm(@RequestBody Transaction transactionToBeAdded ) {

			transactionService.addTransaction(transactionToBeAdded);
	 
		
	   	return transactionToBeAdded;
	}
	
}
