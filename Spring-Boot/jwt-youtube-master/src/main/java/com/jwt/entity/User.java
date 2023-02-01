package com.jwt.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data

@Entity
public class User {

    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String email;
    private String phoneNumber;
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;
    

	public User(String userName, String userFirstName, String userLastName, String email, String phoneNumber,
			String userPassword) {
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userPassword = userPassword;
	}

	

	public User() {
		
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserFirstName() {
		return userFirstName;
	}



	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}



	public String getUserLastName() {
		return userLastName;
	}



	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
}