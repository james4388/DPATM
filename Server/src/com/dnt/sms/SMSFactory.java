package com.dnt.sms;

import com.dnt.sms.impl.ConsoleGateway;
import com.dnt.sms.impl.TwilioGateway;

/*
 * Factory Method: create factory based on gateway implementation, fallback to console sms if not exist
 */
public class SMSFactory {
	private static final SMSFactory instance = new SMSFactory();
	
	private SMSFactory(){
		
	}
	
	public static SMSFactory getFactory(){
		return instance;
	}
	
	public SMSGateway createGateway(String gateway){
		if (gateway.equals("Twilio")){
			return TwilioGateway.getInstance();
		}
		return ConsoleGateway.getInstance();
	}
}
