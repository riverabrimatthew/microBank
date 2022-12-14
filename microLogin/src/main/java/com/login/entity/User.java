package com.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	@Column (name = "username")
	private String username;
	@Column (name = "password")
	private String password;
	@Column (name = "contactnumber")
	private Long contactnumber;
	@Column (name="accountnumber")
	private long accountnumber;
	@Column (name = "totalbalance")
	private int totalbalance;
	@Column (name = "creationdate")
	private String creationdate;
	
	public User() {
	}


	public User(Long id, String username, String password, Long contactnumber,int totalbalance,long accountnumber,  String creationdate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.contactnumber = contactnumber;
		this.accountnumber = accountnumber;
		this.totalbalance = totalbalance;
		this.creationdate = creationdate;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(Long contactnumber) {
		this.contactnumber = contactnumber;
	}

	public int getTotalbalance() {
		return totalbalance;
	}

	public void setTotalbalance(int totalbalance) {
		this.totalbalance = totalbalance;
	}

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public long getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	
}
