package edu.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.service.UserService;
import edu.mum.domain.Users;

@RestController
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService  memberService;


	@RequestMapping
	public List<Users>  findAll( ) {
		return  memberService.findAll();
 
	}
	
	
  	@RequestMapping("/{id}")
	public Users getMemberById(@PathVariable("id") Long id) {
  		System.out.println("The user id received by REST is : " + id);
		return   memberService.findOne(id);
 
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Users processAddNewMemberForm(@RequestBody Users memberToBeAdded) {
		memberService.save(memberToBeAdded);
		return memberToBeAdded;
 
	}
	@RequestMapping(value="/delete", method = RequestMethod.PUT)
	public String delete(@RequestParam Long accountId) {
		//send user obtained from the given accountID then change the flag only!!
	//	memberService.update(member);
		//memberService.delete();
	    return "Apartment #"+accountId+" deleted successfully";
	}
	
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT )
	public String update(@RequestBody Users memberToBeUpdated, @RequestParam Long accountId) {
		System.out.println("The AccountID here is : "+ accountId);
		//send user obtained from the given accountID then change the flag only!!
		memberService.update(memberToBeUpdated);
		//memberService.delete();
	    return "Apartment #"+accountId+" deleted successfully";
	}
 
}
