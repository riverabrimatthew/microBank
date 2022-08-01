package com.microTransaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "firstpoint")
	private long firstpoint;
	@Column(name = "endpoint")
	private long endpoint;
	@Column(name = "amount")
	private double amount;
	@Column(name = "transactdate")
	private Date transactdate;
	
	public Transaction() {
		
	}
	
	public Transaction(Long id, long firstpoint, long endpoint, double amount, Date transactdate) {
		super();
		this.id = id;
		this.firstpoint = firstpoint;
		this.endpoint = endpoint;
		this.amount = amount;
		this.transactdate = transactdate;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", firstpoint=" + firstpoint + ", endpoint=" + endpoint + ", amount=" + amount
				+ ", transactdate=" + transactdate +" ]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getFirstpoint() {
		return firstpoint;
	}
	public void setFirstpoint(long firstpoint) {
		this.firstpoint = firstpoint;
	}
	public long getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(long endpoint) {
		this.endpoint = endpoint;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTransactdate() {
		return transactdate;
	}
	public void setTransactdate(Date transactdate) {
		this.transactdate = transactdate;
	}
	
	
	
}
