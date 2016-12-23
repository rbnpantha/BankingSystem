package edu.cs544.eafinal.service;

import java.util.List;

import edu.cs544.eafinal.domain.Transaction;
import edu.cs544.eafinal.domain.Users;

public interface TransactionService {
	public Transaction addTransaction(Transaction transaction);
	public void deleteTransaction(Long AccountId);
	public List<Transaction> getAll();
	public Transaction getTransaction(Long AccountId);
	public void updateTransaction(Transaction transaction);
}
