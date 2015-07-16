package com.dnt.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;

import com.dnt.model.Account;
import com.dnt.model.Transaction;

public class ReceiptService {
	
	private static void print(String content){
		Runnable printThread = new Runnable() {
			public void run() {
				InputStream html = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				DocFlavor pFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
				Doc myDoc = new SimpleDoc(html, pFormat, null);
				PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
				aset.add(MediaSizeName.ISO_A4);
				PrintService service = PrintServiceLookup.lookupDefaultPrintService(); //PrintServiceLookup.lookupPrintServices(pFormat, aset);
				if (service != null) {
					DocPrintJob job = service.createPrintJob();
					try {
						job.print(myDoc, aset);
					} catch (PrintException pe) {
					}
				}
				System.out.println(content);
			}
		};
		
		Thread thread = new Thread(printThread);
		thread.start();
	}

	public static void printReceipt(Transaction t) {
		String content = "Bank of MUM\r\n"+
				"-----------------------------\r\n"+
				"Transaction date: "+t.getCreatedDate().toString()+"\r\n"+
				"Account: "+t.getAccount().getAccountId()+"\r\n" +
				"Name: "+t.getAccount().getOwner()+"\r\nAmount: $"+t.getAmount()+"\r\n"+
				"Detail: "+ t.getDescription() + "\r\n"+
				"-----------------------------";
		print(content);
	}
	
	public static void printAccount(Account a){
		String content = "Bank of MUM\r\n"+
				"-----------------------------\r\n"+
				"Transaction date: "+new Date().toString()+"\r\n"+
				"Account: "+a.getAccountId()+"\r\n" +
				"Name: "+a.getOwner()+"\r\nAmount: $"+a.getBalance()+"\r\n"+
				"-----------------------------";
		print(content);
	}

}
