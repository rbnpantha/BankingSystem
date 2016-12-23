package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.mum.validation.EmptyOrSize;

@Entity
public class Address {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;

	@EmptyOrSize(min=5, max = 9, message= "{EmptyOrSize}")
 	private String street;
	private String city;	
 	private String state;
  	private String zipCode;

  	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn (name="member_id") 
  	@JsonIgnore
  	private Users  member;
  	
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
		return member;
	}
	public void setMember(Users member) {
		this.member = member;
	}
	
	
}
