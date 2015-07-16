package com.dnt.model;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	@JsonIgnore
	private String pin;
	private List<Account> accounts = new LinkedList<Account>();
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public List<Account> getAccounts(){
		return this.accounts;
	}
	public void addAccount(Account a){
		this.accounts.add(a);
	}
	public List<Account> getAccountByType(String type){
		List<Account> filtered = new LinkedList<Account>();
		for(Account a : this.accounts){
			if (a.getClass().getSimpleName().equals(type)){
				filtered.add(a);
			}
		}
		return filtered;
	}
	
	@Override
	public String toString(){
		return this.getFirstName() + " " + this.getLastName();
	}
}
