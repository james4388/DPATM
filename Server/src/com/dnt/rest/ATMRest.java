package com.dnt.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.model.ATM;
import com.dnt.service.ATMService;

@Path("/atm")
@Produces(MediaType.APPLICATION_JSON)
public class ATMRest {
	
	@POST
	@Path("/{atmID}/changestatus")
	public Map<String, Object> changeStatus(@PathParam("atmID") String atmID,
			@FormParam("newStatus") String newStatus){
		Map<String, Object> result = new HashMap<String, Object>();
		ATM a = ATMService.getInstance().getRepository().getATMById(atmID);
		if(a!=null){
			a.setStatus(newStatus);
			result.put("result", "OK");
		}else{
			result.put("result", "FAIL");
			result.put("message", "Invalid ATM ID");
		}
		return result;
	}
	
}
