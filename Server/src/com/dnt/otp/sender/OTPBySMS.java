/**
 * 
 */
package com.dnt.otp.sender;

import com.dnt.model.OTPChallenge;
import com.dnt.model.User;
import com.dnt.otp.OTPSendStrategy;
import com.dnt.sms.SMSFactory;
import com.dnt.sms.SMSGateway;

/**
 * @author Nhu
 *
 */
public class OTPBySMS implements OTPSendStrategy {

	@Override
	public void sendOTP(User user, OTPChallenge otp) {
		SMSGateway sms = SMSFactory.getFactory().createGateway("Twilio");
		sms.send(user.getPhoneNumber(), "Your transaction OTP is " + otp);
	}

}
