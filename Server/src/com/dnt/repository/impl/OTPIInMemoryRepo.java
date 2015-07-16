package com.dnt.repository.impl;

import java.util.List;

import com.dnt.model.OTPChallenge;
import com.dnt.repository.OTPRepository;

public class OTPIInMemoryRepo implements OTPRepository {
	private List<OTPChallenge> otps;
	
	public OTPIInMemoryRepo(){
		otps = InMemoryDatabaseBuilder.getInstance().getOTPs();
	}

	@Override
	public void createOTP(OTPChallenge otp) {
		otps.add(otp);
	}

	@Override
	public OTPChallenge getOTPByID(String challengeID) {
		for (OTPChallenge o: otps){
			if (o.getChallengeId().equals(challengeID)){
				return o;
			}
		}
		return null;
	}

	@Override
	public void removeOTP(OTPChallenge otp) {
		otps.remove(otp);
	}

}
