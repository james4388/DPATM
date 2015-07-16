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
    
    func printAccountBalance(accountID : String!, completionBlock handler : APICompletionHandler)
    
    func printTransactionBalance(transactionID : String!, completionBlock handler : APICompletionHandler)
    
}