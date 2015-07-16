package com.dnt.sms.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.dnt.sms.SMSGateway;

/*
 * SMS gateway, apply Singleton
 */
public class TwilioGateway implements SMSGateway {
	private static final SMSGateway instance = new TwilioGateway();
	private String ACCOUNT_SID;
	private String AUTH_TOKEN;
	private String fromNumber;
	private String url = "https://api.twilio.com/2010-04-01/Accounts/ACbd7b1c03957ad6d936b2d82d7b5b54ad/Messages.json";
	private CredentialsProvider credsProvider;
	
	/*
	 * Using hardcoded configuration.
	 * TODO use external gateway config
	 */
	private TwilioGateway() {
		ACCOUNT_SID = "ACbd7b1c03957ad6d936b2d82d7b5b54ad";
		AUTH_TOKEN = "f1d28e3ace81cb6e7c0b23d8dc66c70c";
		fromNumber = "+14157024240";
		credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
                new AuthScope("api.twilio.com", 443),
                new UsernamePasswordCredentials(ACCOUNT_SID, AUTH_TOKEN));
	}
	
	public static SMSGateway getInstance(){
		return instance;
	}

	@Override
	public void send(String toNumber, String content) {
		System.out.println("Send SMS to " + toNumber + ": " + content);	
		CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
		try {
			HttpPost httppost = new HttpPost(url);
			List<NameValuePair> postparams = new ArrayList<NameValuePair>();
			postparams.add(new BasicNameValuePair("To", toNumber));
			postparams.add(new BasicNameValuePair("From", fromNumber));
			postparams.add(new BasicNameValuePair("Body", content));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postparams, Consts.UTF_8);
			httppost.setEntity(entity);
			
			try {
				CloseableHttpResponse response = httpclient.execute(httppost);
				System.out.println(response.getStatusLine());
                EntityUtils.consume(response.getEntity());
                response.close();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}finally {
            try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
	}

}
