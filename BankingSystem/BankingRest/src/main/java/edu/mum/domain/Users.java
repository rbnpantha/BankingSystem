package edu.mum.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.mum.validation.EmptyOrSize;
import edu.mum.validation.NullMinNumber;


@Entity 
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
	@Column(length = 16)
	@NotEmpty
	private String firstName;
	
	@Column(length = 16)
	@EmptyOrSize(min=5, max = 9, message= "{EmptyOrSize}")
	private String lastName;

	@NullMinNumber(value=6)
	private Integer age;
 	
	@Column(length = 32)
	@NotEmpty
	private String email;
	
	@NullMinNumber(value=6)
 	private Integer memberNumber;

	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
 	@JoinColumn(name="member_id") 
//@JsonIgnore
	@JsonBackReference
 	UserCredentials userCredentials;
 	
  
/*    @Valid
    @Size(min = 1, message="{List.empty}" )
*/
	@OneToMany(mappedBy="member",fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })  
  	@JsonIgnore
   private List<Address> addresses = new ArrayList<Address>();

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
