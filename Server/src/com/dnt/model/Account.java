package com.dnt.model;

import org.codehaus.jackson.annotate.JsonIgnore;

public abstract class Account {
	@JsonIgnore
	private User owner;
	private String accountId;
	private double balance;
	private double interest;
	private String type;
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountID) {
		this.accountId = accountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void deposit(Double a){
		this.balance += a;
	}
	public void withdraw(Double a){
		this.balance -= a;
	}
}
