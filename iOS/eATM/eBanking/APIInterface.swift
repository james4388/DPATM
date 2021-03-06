//
//  APIInterface.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import Foundation

typealias APICompletionHandler = (NSDictionary!, NSError!) -> Void

protocol APIInteface{

    func login(username: String!, password: String!, completionBlock handler: APICompletionHandler)
    
    func printBalance(accountId: String!, username: String!, completionBlock handler: APICompletionHandler)
    
    func printTransactionBalance(transactionID : String!, completionBlock handler : APICompletionHandler)
    
    
    func changePinCode(userId : String!, oldPinCode : String!, newPinCode : String!, completionBlock handler : APICompletionHandler)
    
    func getAllBill(userID : String!, completionBlock handler : APICompletionHandler)
    
    func payBill(billID : String!, atmID : String!, accountID : String!, completionBlock handler : APICompletionHandler)
    
    func getOTP(atmID: String!, accountID: String!, completionBlock handler : APICompletionHandler)
    
    func withdraw(amount : String!, accountId : String!, challengID : String!, otpCode : String!, atmID : String!, completionBlock handler : APICompletionHandler)
    
}