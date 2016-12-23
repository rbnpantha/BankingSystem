package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.Users;
 
public interface UserService {

	public void save(Users member);
	public void update(Users member);
   	public void saveFull( Users member);  		

	public List<Users> findAll();
	public Users findByMemberNumber(Integer memberId);

	public Users findOne(Long id);
	public Users findOneFull(Long id);
	
	public List<Users> findAllJoinFetch();
	public List<Users> findByGraph();
		
}
