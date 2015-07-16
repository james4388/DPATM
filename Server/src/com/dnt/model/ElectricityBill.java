package com.dnt.model;

public class ElectricityBill extends Bill {
	public ElectricityBill(){
		this.setServiceFee(0.2);
		this.setType("ElectricityBill");
	}
}
