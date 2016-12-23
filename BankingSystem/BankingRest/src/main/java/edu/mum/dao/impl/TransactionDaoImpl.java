package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import edu.mum.dao.TransactionDao;
import edu.mum.domain.Transaction;


@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao{
	public TransactionDaoImpl() {
		super.setDaoType(Transaction.class );
		}


  public Transaction getTransactionByTransactionId(String key) {
	 return  this.getTransactionByTransactionId(key);
  }

		public List<Transaction> getAllTransactions() {
    	return this.findAll();
    }
	
    public Transaction getTransactionById(String key) {	     
		Query query = entityManager.createQuery("select p from Transaction p  where p.transactionId =:transactionId");
		return (Transaction) query.setParameter("transactionId", key).getSingleResult();

    }
	
	public List<Transaction> getTransactionsByCategory(String category) {
		
		Query query = entityManager.createQuery("select p from Transaction p where p.category = :category");
		 
		return (List<Transaction>) query.setParameter("category", category).getResultList();
		}


	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsByDescOrder() {
		Query query = entityManager.createQuery("select p from Transaction p order by p.transactionId desc");
		return (List<Transaction>) query.getResultList();

	}
}
