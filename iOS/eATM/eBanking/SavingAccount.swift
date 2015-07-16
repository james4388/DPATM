//
//  SavingAccount.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/16/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class SavingAccount: NSObject, IAccount {
    var _accountId : String?
    var _balance : Double
    
    override init() {
        _accountId = ""
        _balance = 0
    }
    
    var accountId : String? {
        get{
            return _accountId
        }
        
        set{
            _accountId = newValue
        }
    }
    var balance : Double {
        get{
            return _balance
        }
        
        set{
            _balance = newValue
        }
    }
    
    func deposite(amount: Double) -> Bool {
        return true
    }
    
    func withdraw(amount: Double) -> Bool {
        _balance -= amount
        
        return true
    }
}
