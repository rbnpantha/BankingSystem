package edu.mum.dao.impl;

 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.Users;



@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<Users> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(Users.class );
		}

	public Users findByMemberNumber(Integer number) {
	     
		Query query = entityManager.createQuery("select m from Member m  where m.memberNumber =:number");
		return (Users) query.setParameter("number", number).getSingleResult();
			     

	}

	public List<Users> findAllJoinFetch() {
		  Query query =  entityManager.createQuery("SELECT DISTINCT m FROM Member AS m JOIN FETCH m.addresses AS a");
		  return (List<Users>) query.getResultList();

	}

	public List<Users> findByGraph() {

	    EntityGraph graph = entityManager.getEntityGraph("graph.Member.addresses");

	    return (List<Users>) this.findAll("javax.persistence.fetchgraph",graph);
 
	}



 }