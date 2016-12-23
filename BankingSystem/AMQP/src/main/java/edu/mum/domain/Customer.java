package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer implements Serializable {
	private Long id = null;
	private int version = 0;

	private String email;

	private String firstName;

	private String lastName;

	public Customer() {
	}

	public Customer(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String orderNumber) {
		this.email = orderNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String items) {
		this.firstName = items;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String payment) {
		this.lastName = payment;
	}

	

}
