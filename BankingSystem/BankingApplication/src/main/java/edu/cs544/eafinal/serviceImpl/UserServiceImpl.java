package edu.cs544.eafinal.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.cs544.eafinal.aspect.annotation.Logging;
import edu.cs544.eafinal.domain.Response;
import edu.cs544.eafinal.domain.Users;
import edu.cs544.eafinal.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	RestTemplate restTemplate = new RestTemplate();

	Response response;
	ObjectMapper objectMapper = new ObjectMapper();

	@Logging
	@PreAuthorize("hasRole('ROLE_SUPERVISOR')")
	public Users addUser(Users user) {
		final String uri = "http://localhost:8080/BankingRest/users/add/";
		RestTemplate restTemplate = new RestTemplate();
		Users result = restTemplate.postForObject(uri, user, Users.class);
		System.out.println(result);
		return result;
	}

	@Logging
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteUser(Long AccountId) {
		// TODO Auto-generated method stub
		final String uri = "http://localhost:8080/BankingRest/users/delete/" + AccountId;
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", AccountId);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);
		System.out.println("Successfully Deleted user with AccountNo : " + AccountId);
	}

	@Logging
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Users> getAll() {
		System.out.println("getAll method is called !!");
		ResponseEntity<List<Users>> rateResponse = restTemplate.exchange("http://localhost:8080/BankingRest/users/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Users>>() {
				});
		List<Users> users = rateResponse.getBody();
		for (Users user : users)
			System.out.println(" the list is as : " + user.getFirstName());

		return users;

	}

	@Logging
	public Users getUser(Long AccountId) {
		System.out.println("Inside service impl method!! " + AccountId);
		String url = "http://localhost:8080/BankingRest/users/"+AccountId;
		Users user = restTemplate.getForObject(url, Users.class, AccountId);
		System.out.println("Usr is : " + user.toString());
		return user;
	}

	@Logging
	public void updateUser(Users user) {
		final String uri = "http://localhost:8080/BankingRest/users/delete/{id}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "2");
		Users updateUser = new Users();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, updateUser, params);

	}
}
