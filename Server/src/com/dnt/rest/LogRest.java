package com.dnt.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dnt.service.TransactionService;

@Path("/log")
@Produces(MediaType.APPLICATION_JSON)
public class LogRest {
	
	@GET
	@Path("/all")
	public Map<String, Object> viewLog(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "OK");
		result.put("transactions", TransactionService.getInstance().getRepository().getAll());
		return result;
	}
	
}
