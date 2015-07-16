package com.dnt.otp.sender;

import com.dnt.model.OTPChallenge;
import com.dnt.model.User;
import com.dnt.otp.OTPSendStrategy;
import com.dtn.email.EmailGateway;
import com.dtn.email.impl.DreamhostEmail;

public class OTPByEmail implements OTPSendStrategy {

	@Override
	public void sendOTP(User user, OTPChallenge otp) {
		EmailGateway email = DreamhostEmail.getInstance();
		email.sendHTMLEmail(user.getEmail(), "Your transaction OTP", 
				"Dear <b>"+user.toString()+"</b>,<br/>"+
				"You or someone trying to take your money at ATM <b>"+otp.getATMid()+"</b>. " +
			    "If that was you please enter this following OTP to confirm your transaction" +
				"<h3>" + otp.getCode() + "</h3>Thank you<br/>Happy banking", "");
	}

}
