package edu.cs544.eafinal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Users {
	
 	private long id;
	
	
	private String firstName;
	
	
	private String lastName;

	private Integer age;
 	
	private String email;
	
 	private Integer memberNumber;


 	UserCredentials userCredentials;
 	
  
   private List<Address> addresses = new ArrayList<Address>();

   /*public User(String firstName, String lastName, Integer age, String title, Integer memberNumber){
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.age = age;
	   this.title = title;
	   this.memberNumber = memberNumber;
	   
   }*/
   
 	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 
	
 	public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
 	public void addAddress(Address address) {
		this.addresses.add(address);
		address.setMember(this);
	}
	public Integer getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
 	public Integer getAge() {
		return age;
	}
}
