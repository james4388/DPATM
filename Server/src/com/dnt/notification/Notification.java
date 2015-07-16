package com.dnt.notification;

public class Notification {
	private static Notification instance = new Notification();
	private static NotificationHandler email;
	private static NotificationHandler sms;
	private static NotificationHandler console;
	
	private Notification(){
		email = new EmailNotification();
		sms = new SMSNotification();
		console = new ConsoleNotification();
		email.nextHandler = sms;
		sms.nextHandler = console;
	}
	
	public static Notification getInstance(){
		return instance;
	}
	
	public NotificationHandler getHandler(){
		return email;
	}
}
