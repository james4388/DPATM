package com.dnt.repository.impl;

import java.util.LinkedList;
import java.util.List;

import com.dnt.model.Bill;
import com.dnt.model.User;
import com.dnt.repository.BillRepository;

public class BillInMemoryRepo implements BillRepository {
	private List<Bill> bills;
	
	public BillInMemoryRepo() {
		bills = InMemoryDatabaseBuilder.getInstance().getBills();
	}

	@Override
	public List<Bill> getAllBill() {
		return bills;
	}

	@Override
	public List<Bill> getBillByUser(User u) {
		List<Bill> billByU = new LinkedList<Bill>();
		for (Bill b: bills){
			if(b.getOwner().equals(u)){
				billByU.add(b);
			}
		}
		return billByU;
	}

	@Override
	public Bill getBillById(String id) {
		for(Bill b: bills){
			if (b.getId().equals(id))
				return b;
		}
		return null;
	}

	@Override
	public void removeBill(Bill b) {
		bills.remove(b);
	}

}
