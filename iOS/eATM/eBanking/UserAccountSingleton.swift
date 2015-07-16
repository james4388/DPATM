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
    
    private var currentAccountNumber: String?
    private var savingAccountNumber: String?
    private var currentBalance: Double?
    private var savingBalance: Double?
    var accountType = 0
    
    var currentAccount : IAccount?
    var savingAccount : IAccount?
    
    var userInfo : LoginReturnObject?
    
    private override init() {
    }
    
    class func getInstance() -> UserAccountSingleton {
        if (instance == nil) {
            instance = UserAccountSingleton()
        }
        return instance
    }
    
    func setCurrentAccountNumber(accountNumber: String) {
        self.currentAccountNumber = accountNumber
    }
    
    func getCurrentAccountNumber() -> String {
        return currentAccountNumber!
    }
    
    func setSavingAccountNumber(accountNumber: String) {
        self.savingAccountNumber = accountNumber
    }
    
    func getSavingAccountNumber() -> String {
        return savingAccountNumber!
    }
    
    func setSavingBalance(savingBalance: Double) {
        self.savingBalance = savingBalance
    }
    
    func getSavingBalance() -> Double {
        return savingBalance!
    }
    
    func setCurrentBalance(currentBalance: Double) {
        self.currentBalance = currentBalance
    }
    
    func getCurrentBalance() -> Double {
        return currentBalance!
    }
}
