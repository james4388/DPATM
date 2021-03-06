//
//  RunoutOfMoneyState.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class RunOutOfMoneyState: NSObject, ATMState {
    
    private var mc : ATMMachine
    
    init(machine : ATMMachine){
        mc = machine
    }
    
    //MARK: ATMState interface
    func withdraw(#amount: Double, account : IAccount) -> NSError? {
        return NSError(domain: "eATM", code: 1001, userInfo: [NSLocalizedDescriptionKey : "Runs out of money"])
    }
}
