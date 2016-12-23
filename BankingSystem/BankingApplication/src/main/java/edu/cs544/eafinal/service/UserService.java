package edu.cs544.eafinal.service;

import java.util.List;
import edu.cs544.eafinal.domain.Users;

public interface UserService {
	public Users addUser(Users user);
	public void deleteUser(Long AccountId);
	public List<Users> getAll();
	public Users getUser(Long AccountId);
	public void updateUser(Users user);
}
