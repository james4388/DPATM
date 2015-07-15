//
//  UserAccountSingleton.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class UserAccountSingleton: NSObject {
    private static var instance : UserAccountSingleton!
    
    private var accountNumber: String!
    
    private override init() {
    }
    
    class func getInstance() -> UserAccountSingleton {
        if (instance == nil) {
            instance = UserAccountSingleton()
        }
        return instance
    }
    
    func setAccountNumber(accountNumber: String) {
        self.accountNumber = accountNumber
    }
    
    func getAccountNumber() -> String {
        return accountNumber
    }
}
