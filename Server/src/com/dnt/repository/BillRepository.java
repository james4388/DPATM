package com.dnt.repository;

import java.util.List;

import com.dnt.model.Bill;
import com.dnt.model.User;

public interface BillRepository {
	public List<Bill> getAllBill();
	public Bill getBillById(String id);
	public List<Bill> getBillByUser(User u);
	public void removeBill(Bill b);
}
