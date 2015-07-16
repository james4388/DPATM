package com.dnt.sms;

public interface SMSGateway {
	public void send(String toNumber, String content);
}
