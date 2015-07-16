package com.dnt.repository.impl;

import java.util.LinkedList;
import java.util.List;

import com.dnt.model.ATM;
import com.dnt.model.Account;
import com.dnt.model.Bill;
import com.dnt.model.CellularBill;
import com.dnt.model.Current;
import com.dnt.model.ElectricityBill;
import com.dnt.model.GasBill;
import com.dnt.model.OTPChallenge;
import com.dnt.model.Saving;
import com.dnt.model.Transaction;
import com.dnt.model.User;

public class InMemoryDatabaseBuilder {
	private static InMemoryDatabaseBuilder instance = new InMemoryDatabaseBuilder();
	private static List<User> users;
	private static List<Account> accounts;
	private static List<OTPChallenge> otps;
	private static List<Transaction> trans;
	private static List<ATM> atms;
	private static List<Bill> bills;
	
	public static InMemoryDatabaseBuilder getInstance(){
		return instance;
	}
	
	private InMemoryDatabaseBuilder(){
		users = new LinkedList<User>();
		//Tai
		User tai = new User();
		tai.setFirstName("Tai");
		tai.setLastName("Ho");
		tai.setEmail("hohuutai.uns@gmail.com");
		tai.setPhoneNumber("4143593567");
		tai.setUserId("9000001");
		tai.setPin("123456");
		//Dat
		User dat = new User();
		dat.setFirstName("Dat");
		dat.setLastName("Tran");
		dat.setEmail("datct0407@gmail.com");
		dat.setPhoneNumber("4143593567");
		dat.setUserId("9000002");
		dat.setPin("123456");
		//Nhu
		User nhu = new User();
		nhu.setFirstName("Nhu");
		nhu.setLastName("Trinh");
		nhu.setEmail("trinhhoangnhu@gmail.com");
		nhu.setPhoneNumber("4143593067");
		nhu.setUserId("9000003");
		nhu.setPin("123456");
		
		users.add(tai);
		users.add(nhu);
		users.add(dat);
		
		
		accounts = new LinkedList<Account>();
		//Tai accounts
		Account taiSaving = new Saving();
		taiSaving.setAccountId("A000001");
		taiSaving.setBalance(10000);
		taiSaving.setOwner(tai);
		tai.addAccount(taiSaving);
		
		Account taiChecking = new Current();
		taiChecking.setAccountId("A000002");
		taiChecking.setBalance(5000);
		taiChecking.setOwner(tai);
		tai.addAccount(taiChecking);
		
		//Dat accounts
		Account datSaving = new Saving();
		datSaving.setAccountId("A000003");
		datSaving.setBalance(15000);
		datSaving.setOwner(dat);
		dat.addAccount(datSaving);

		Account datChecking = new Current();
		datChecking.setAccountId("A000004");
		datChecking.setBalance(7000);
		datChecking.setOwner(dat);
		dat.addAccount(datChecking);
		
		//Nhu accounts
		Account nhuSaving = new Saving();
		nhuSaving.setAccountId("A000005");
		nhuSaving.setBalance(20000);
		nhuSaving.setOwner(nhu);
		nhu.addAccount(nhuSaving);

		Account nhuChecking = new Current();
		nhuChecking.setAccountId("A000006");
		nhuChecking.setBalance(9000);
		nhuChecking.setOwner(nhu);
		nhu.addAccount(nhuChecking);
		
		accounts.add(taiSaving);
		accounts.add(taiChecking);
		accounts.add(datSaving);
		accounts.add(datChecking);
		accounts.add(nhuSaving);
		accounts.add(nhuChecking);
		
		otps = new LinkedList<OTPChallenge>();
		trans = new LinkedList<Transaction>();
		atms = new LinkedList<ATM>();
		ATM mum = new ATM();
		mum.setId("ATM@MUM");
		mum.setName("MUM ATM");
		mum.setStatus("good");
		
		bills = new LinkedList<Bill>();
		
		//Tai Bill
		Bill taiCell = new CellularBill();
		taiCell.setAmount(20);
		taiCell.setCompany("Tmobile");
		taiCell.setId("B001");
		taiCell.setName("Tmobile July");
		taiCell.setOwner(tai);
		
		Bill taiGas = new GasBill();
		taiGas.setAmount(50);
		taiGas.setCompany("Petro");
		taiGas.setId("B002");
		taiGas.setName("Petro July");
		taiGas.setOwner(tai);
		
		Bill taielec = new ElectricityBill();
		taielec.setAmount(40);
		taielec.setCompany("Thunder");
		taielec.setId("B003");
		taielec.setName("Petro July");
		taielec.setOwner(tai);
		
		bills.add(taiCell);
		bills.add(taiGas);
		bills.add(taielec);
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public List<Account> getAccounts(){
		return accounts;
	}
	public List<OTPChallenge> getOTPs(){
		return otps;
	}
	public List<Transaction> getTransactions(){
		return trans;
	}
	public List<ATM> getATMs(){
		return atms;
	}
	public List<Bill> getBills(){
		return bills;
	}
}
