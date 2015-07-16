package com.dnt.repository;

import com.dnt.model.OTPChallenge;

public interface OTPRepository {
	public void createOTP(OTPChallenge otp);
	public OTPChallenge getOTPByID(String OTPChallenge);
	public void removeOTP(OTPChallenge otp);
}
