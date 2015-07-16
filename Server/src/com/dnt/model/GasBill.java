package com.dnt.model;

public class GasBill extends Bill {
	public GasBill(){
		this.setServiceFee(0.05);
		this.setType("GasBill");
	}
}
