package com.dnt.sms.impl;

import com.dnt.sms.SMSGateway;

public class ConsoleGateway implements SMSGateway{
	private static final ConsoleGateway instance = new ConsoleGateway();
	
	private ConsoleGateway(){
		
	}
	
	public static SMSGateway getInstance(){
		return instance;
	}

	@Override
	public void send(String toNumber, String content) {
		System.out.println("Send SMS to " + toNumber + ": " + content);	
	}

}
