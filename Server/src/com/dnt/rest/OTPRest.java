package com.dnt.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.model.Account;
import com.dnt.model.OTPChallenge;
import com.dnt.otp.OTPSendStrategy;
import com.dnt.otp.sender.OTPByEmail;
import com.dnt.service.AccountService;
import com.dnt.service.OTPService;

@Path("/otp")
@Produces(MediaType.APPLICATION_JSON)
public class OTPRest {
	
	@POST
	public Map<String, Object> getOTP(@FormParam("atmId") String atmID, @FormParam("accountId") String aId){
		Map<String, Object> result = new HashMap<String, Object>();
		Account a = AccountService.getInstance().getRepository().getAccountById(aId);
		if (a != null){
			result.put("result", "OK");
			OTPChallenge c = OTPService.getInstance().createOTP(a, atmID);
			result.put("challenge", c);
			OTPSendStrategy email = new OTPByEmail();
			email.sendOTP(a.getOwner(), c);
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid account ID");
		}
		return result;
	}
}
