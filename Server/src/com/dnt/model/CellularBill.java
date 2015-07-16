package com.dnt.model;

public class CellularBill extends Bill {
	public CellularBill(){
		this.setServiceFee(0.1);
		this.setType("CellularBill");
	}
}
