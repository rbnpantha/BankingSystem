package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.aspect.annotation.Logging;
import edu.mum.dao.UserDao;
import edu.mum.domain.Users;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class UserServiceImpl implements edu.mum.service.UserService {
	
 	@Autowired
	private UserDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;

 	@Logging
    public void save( Users user) {  		
		memberDao.save(user);
	}
 	@Logging
    public void update( Users user) {  		
		memberDao.update(user);
	}
	
    @Override
   	public void saveFull( Users user) {  		
  		credentialsService.save(user.getUserCredentials());
  		memberDao.save(user);
	}
  	
    @Logging
	public List<Users> findAll() {
		List<Users> users = (List<Users>)memberDao.findAll();
		System.out.println("Inside find all user!!!");
		for(Users user : users)
			System.out.println("List of user displayed !! "+user.getFirstName() );
		return (List<Users>)memberDao.findAll();
	}
    @Logging
	public Users findByMemberNumber(Integer memberId) {
		return memberDao.findByMemberNumber(memberId);
	}
	@Logging
	public Users findOne(Long id) {
		System.out.println("Inside memberservice method : " + id);
		return memberDao.findOne(id);
	}
	@Logging
	public Users findOneFull(Long id) {
		Users user = this.findOne(id);
		
// OR 		"SELECT p FROM Member m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		user.getUserCredentials();
		
		return  user;
	}
	@Logging
	public List<Users> findAllJoinFetch() {
		return memberDao.findAllJoinFetch();
	}
	
 	@Override
	public List<Users> findByGraph() {
		return  memberDao.findByGraph();
	}

}
