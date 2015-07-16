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
    func withdraw(#amount: Double, account : UserAccountSingleton) -> NSError? {
        
        if mc.amount == 0{
            mc.state = mc.runOutOfMoney
            
            return NSError(domain: "eATM", code: 1001, userInfo: [NSLocalizedDescriptionKey : "Run out of money"])
        }
        
        var success = mc.returnMoney(amount)
        
        if success{
            return nil
        }else{
            return NSError(domain: "eATM", code: 1001, userInfo: [NSLocalizedDescriptionKey : "Your amount exeeds the current amount in ATM"])
        }
    }
}
