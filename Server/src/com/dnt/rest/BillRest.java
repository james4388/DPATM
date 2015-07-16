package com.dnt.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.model.Account;
import com.dnt.model.Bill;
import com.dnt.model.Transaction;
import com.dnt.model.User;
import com.dnt.repository.BillRepository;
import com.dnt.service.AccountService;
import com.dnt.service.BillService;
import com.dnt.service.UserService;
import com.dnt.service.transaction.TransactionCommand;
import com.dnt.service.transaction.WithdrawTransaction;

@Path("/bill")
@Produces(MediaType.APPLICATION_JSON)
public class BillRest {
	
	@POST
	@Path("/userbill")
	public Map<String, Object> getUserBill(@FormParam("userid") String userID){
		Map<String, Object> result = new HashMap<String, Object>();
		User u = UserService.getInstance().getRepository().getUserById(userID);
		if (u != null){
			List<Bill> bills = BillService.getInstance().getRepository().getBillByUser(u);
			result.put("result", "OK");
			result.put("bills", bills);
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid userid");
		}
		return result;
	}
	
	@POST
	@Path("/{billId}/pay")
	public Map<String, Object> payBill(@PathParam("billId") String billId,
			@FormParam("accountId") String accountId,
			@FormParam("atmId") String atmId){
		Map<String, Object> result = new HashMap<String, Object>();
		Bill b = BillService.getInstance().getRepository().getBillById(billId);
		Account a = AccountService.getInstance().getRepository().getAccountById(accountId);
		if(b != null && a != null){
			Transaction t = new Transaction();
			t.setAccount(a);
			t.setAmount(b.getAmount() + b.getAmount()*b.getServiceFee());
			t.setATM(atmId);
			t.setDescription("Pay Bill #" + b.getId());
			t.setType("Withdraw");
			TransactionCommand cmd = new WithdrawTransaction();
			cmd.execute(t);
			BillService.getInstance().getRepository().removeBill(b);
			result.put("result", "OK");
			result.put("transactionId", t.getTransactionID());
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid billId or account id");
		}
		return result;
	}
	
}
