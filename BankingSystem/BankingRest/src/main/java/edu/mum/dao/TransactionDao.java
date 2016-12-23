package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Transaction;
import edu.mum.domain.Transaction;



public interface TransactionDao extends GenericDao<Transaction> {
	Transaction getTransactionByTransactionId(String key);
	
	public List<Transaction> getAllTransactions();
	
    Transaction getTransactionById(String key);
	
	List<Transaction> getTransactionsByCategory(String category);


	List<Transaction> getTransactionsByDescOrder();

}
