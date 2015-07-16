package com.dnt.model;

import java.util.Date;
import java.util.UUID;

public class Transaction {
	private String transactionID;
	private Account account;
	private String ATM;
	private Double amount;
	private Date createdDate;
	private String type;
	private String description;
	
	public Transaction(){
		transactionID = UUID.randomUUID().toString();
		createdDate = new Date();
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getATM() {
		return ATM;
	}
	public void setATM(String aTM) {
		ATM = aTM;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
