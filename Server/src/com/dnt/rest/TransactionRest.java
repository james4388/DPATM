package com.dnt.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.model.Transaction;
import com.dnt.service.ReceiptService;
import com.dnt.service.TransactionService;
import com.dnt.service.transaction.TransactionCommand;
import com.dnt.service.transaction.WithdrawTransaction;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionRest {
	
	@GET
	@Path("/{transactionID}/print")
	public Map<String, Object> printTransaction(@PathParam("transactionID") String transactionID){
		Map<String, Object> result = new HashMap<String, Object>();
		Transaction t = TransactionService.getInstance().getRepository().getTransactionById(transactionID);
		if(t != null){
			result.put("result", "OK");
			ReceiptService.printReceipt(t);
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid transaction");
		}
		return result;
	}
	
	@POST
	@Path("/{transactionID}/rollback")
	public Map<String, Object> rollbackTransaction(@PathParam("transactionID") String transactionID){
		Map<String, Object> result = new HashMap<String, Object>();
		Transaction t = TransactionService.getInstance().getRepository().getTransactionById(transactionID);
		if(t != null){
			TransactionCommand cmd = null;
			if(t.getType().equals("Withdraw")){
				cmd = new WithdrawTransaction();
			}
			if(t.getType().equals("Deposit")){
				cmd = new WithdrawTransaction();
			}
			if(cmd != null){
				cmd.reverse(t);
				TransactionService.getInstance().getRepository().removeTransaction(t);
				result.put("result", "OK");
			}
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid transaction");
		}
		return result;
	}

}
