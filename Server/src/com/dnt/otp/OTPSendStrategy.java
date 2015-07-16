package com.dnt.otp;

import com.dnt.model.OTPChallenge;
import com.dnt.model.User;

public interface OTPSendStrategy {
	public void sendOTP(User user, OTPChallenge otp);
}
