//
//  ServicingState.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class ServicingState: NSObject, ATMState {
    
    private var mc : ATMMachine
    
    init(machine : ATMMachine){
        mc = machine
    }
    
    //MARK: ATMState interface
    func withdraw(#amount: Double, account : IAccount) -> NSError? {
        
        // check Money amount in ATM
        if mc.amount == 0{
            mc.state = mc.runOutOfMoney
            
            return NSError(domain: "eATM", code: 1001, userInfo: [NSLocalizedDescriptionKey : "Run out of money"])
        }
        
        if mc.canReturnMoney(amount){
            if account.withdraw(amount){
                mc.returnMoney(amount)
            }else{
                return NSError(domain: "eATM", code: 1001, userInfo: [NSLocalizedDescriptionKey : "Amount exceeds your balance"])
            }
        }else{
            return NSError(domain: "eATM", code: 1001, userInfo: [NSLocalizedDescriptionKey : "Your amount exeeds the current amount in ATM"])
        }
        
        return nil
    }
}
