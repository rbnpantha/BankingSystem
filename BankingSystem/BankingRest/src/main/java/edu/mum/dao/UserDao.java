package edu.mum.dao;

import java.util.List;
import java.util.Set;

import edu.mum.domain.Users;

public interface UserDao extends GenericDao<Users> {
      
	public Users findByMemberNumber(Integer number);
	public List<Users> findAllJoinFetch();
	public List<Users> findByGraph();
	}
