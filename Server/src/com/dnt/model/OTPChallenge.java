package com.dnt.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

public class OTPChallenge {
	private Account account;
	private String challengeId;
	@JsonIgnore
	private String code;
	private String ATMid;
	private Date createdDate;
	
	public OTPChallenge(){
		createdDate = new Date();
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getChallengeId() {
		return challengeId;
	}
	public void setChallengeId(String challengeId) {
		this.challengeId = challengeId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getATMid() {
		return ATMid;
	}
	public void setATMid(String aTMid) {
		ATMid = aTMid;
	}
	public Date getCreatedDate(){
		return createdDate;
	}
}
