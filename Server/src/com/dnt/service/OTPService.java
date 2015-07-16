package com.dnt.service;

import java.util.Random;
import java.util.UUID;

import com.dnt.model.Account;
import com.dnt.model.OTPChallenge;
import com.dnt.repository.OTPRepository;
import com.dnt.repository.impl.OTPIInMemoryRepo;

public class OTPService {
	private static OTPService instance = new OTPService();
	private static OTPRepository otpRepo;
	
	private OTPService(){
		otpRepo = new OTPIInMemoryRepo();
	}
	
	public static OTPService getInstance(){
		return instance;
	}
	
	public OTPRepository getRepository(){
		return otpRepo;
	}
	
	private String getRandomCode(){
		Random rand = new Random();
		int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
		return String.valueOf(randomNum);
	}
	
	public OTPChallenge createOTP(Account a, String ATMid){
		String challengeId = UUID.randomUUID().toString();
		OTPChallenge otp = new OTPChallenge();
		otp.setChallengeId(challengeId);
		otp.setATMid(ATMid);
		otp.setAccount(a);
		otp.setCode(getRandomCode());
		otpRepo.createOTP(otp);
		return otp;
	}
}
