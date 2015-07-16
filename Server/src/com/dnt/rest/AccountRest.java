package com.dnt.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.model.Account;
import com.dnt.model.OTPChallenge;
import com.dnt.model.Transaction;
import com.dnt.model.User;
import com.dnt.service.AccountService;
import com.dnt.service.OTPService;
import com.dnt.service.ReceiptService;
import com.dnt.service.TransactionService;
import com.dnt.service.UserService;
import com.dnt.service.transaction.DepositTransaction;
import com.dnt.service.transaction.TransactionCommand;
import com.dnt.service.transaction.WithdrawTransaction;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountRest {
	
	@POST
	@Path("/login")
	public Map<String, Object> authenticate(@FormParam("userid") String userID, @FormParam("pincode") String pin){
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(userID);
		System.out.println(pin);
		User u = UserService.getInstance().getRepository().getUserById(userID);
		if (u != null && u.getPin().equals(pin)){
			result.put("result", "OK");
			result.put("userAuthenticate", true);
			result.put("user", u);
		}else{
			result.put("result", "FAIL");
			result.put("userAuthenticate", false);
			result.put("message", "Invalid userid or pincode");
		}
		return result;
	}
	
	@POST
	@Path("/changepin")
	public Map<String, Object> changePin(@FormParam("userid") String userID,
			@FormParam("pincode") String pin,
			@FormParam("newPincode") String newPin){
		Map<String, Object> result = new HashMap<String, Object>();
		User u = UserService.getInstance().getRepository().getUserById(userID);
		if (u != null && u.getPin().equals(pin)){
			result.put("result", "OK");
			result.put("userAuthenticate", true);
			u.setPin(newPin);
			result.put("user", u);
		}else{
			result.put("result", "FAIL");
			result.put("userAuthenticate", false);
			result.put("message", "Invalid userid or pincode");
		}
		return result;
	}
	
	@GET
	@Path("/{accountId}")
	public Map<String, Object> getAccount(@PathParam("accountId") String accountId){
		Map<String, Object> result = new HashMap<String, Object>();
		Account a = AccountService.getInstance().getRepository().getAccountById(accountId);
		if(a != null){
			result.put("result", "OK");
			result.put("account", a);
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid account ID");
		}
		return result;
	}
	
	@POST
	@Path("/{accountId}/withdraw")
	public Map<String, Object> withdraw(@PathParam("accountId") String accountId, 
			@FormParam("amount") double amount, 
			@FormParam("otpCode") String otp, 
			@FormParam("challengeId") String otpId,
			@FormParam("atmId") String atmID){
		Map<String, Object> result = new HashMap<String, Object>();
		Account a = AccountService.getInstance().getRepository().getAccountById(accountId);
		if(a != null){
			OTPChallenge c = OTPService.getInstance().getRepository().getOTPByID(otpId);
			if (c != null && c.getCode().equals(otp)){
				if (a.getBalance() < amount){
					result.put("result", "FAIL");
					result.put("message", "Balance is too low");
				}else{
					OTPService.getInstance().getRepository().removeOTP(c);
					Transaction t = new Transaction();
					t.setAccount(a);
					t.setAmount(amount);
					t.setType("Withdraw");
					t.setATM(atmID);
					t.setDescription("Withdraw money from ATM");
					TransactionService.getInstance().getRepository().createTransaction(t);
					TransactionCommand cmd = new WithdrawTransaction();
					cmd.execute(t);	//Will remove amount to account
					result.put("result", "OK");
					result.put("transactionId", t.getTransactionID());
				}
			}else{
				result.put("result", "FAIL");
				result.put("message", "Invalid OTP");
			}
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid account ID");
		}
		return result;
	}
	
	@POST
	@Path("/{accountId}/deposit")
	public Map<String, Object> deposit(@PathParam("accountId") String accountId, 
			@FormParam("amount") double amount, 
			@FormParam("atmId") String atmID){
		Map<String, Object> result = new HashMap<String, Object>();
		Account a = AccountService.getInstance().getRepository().getAccountById(accountId);
		if(a != null){
			Transaction t = new Transaction();
			t.setAccount(a);
			t.setAmount(amount);
			t.setType("Deposit");
			t.setATM(atmID);
			t.setDescription("Deposit money from ATM");
			TransactionService.getInstance().getRepository().createTransaction(t);
			TransactionCommand cmd = new DepositTransaction();
			cmd.execute(t);	//Will add amount to account
			result.put("result", "OK");
			result.put("transactionId", t.getTransactionID());
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid account ID");
		}
		return result;
	}
	
	@GET
	@Path("/{accountId}/print")
	public Map<String, Object> printAccount(@PathParam("accountId") String accountId){
		Map<String, Object> result = new HashMap<String, Object>();
		Account a = AccountService.getInstance().getRepository().getAccountById(accountId);
		if(a != null){
			result.put("result", "OK");
			ReceiptService.printAccount(a);
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid account ID");
		}
		return result;
	}
}
