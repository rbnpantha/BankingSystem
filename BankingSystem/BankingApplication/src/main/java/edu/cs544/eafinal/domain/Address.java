package edu.cs544.eafinal.domain;



public class Address {

 	private long id;


 	private String street;
	private String city;	
 	private String state;
  	private String zipCode;

  	private Users  user;
  	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Users getMember() {
		return user;
	}
	public void setMember(Users user) {
		this.user = user;
	}
}
