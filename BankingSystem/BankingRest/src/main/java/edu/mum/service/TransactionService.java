package edu.mum.service;

import java.util.List;

import edu.mum.domain.Transaction;

public interface TransactionService {
	List<Transaction> getAllTransactions();

	Transaction getTransactionById(String transactionID);
	
	List<Transaction> getTransactionsByCategory(String category);

 	void addTransaction(Transaction transaction);

	Transaction get(long id);
 
	List<Transaction> getTransactionsByDescOrder();

}
