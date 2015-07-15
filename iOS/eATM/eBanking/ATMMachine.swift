//
//  ATMMachine.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class ATMMachine: NSObject {
    
    var servicingState : ATMState?
    var runOutOfMoney : ATMState?
    var outOfService : ATMState?
    
    private var state : ATMState?
    
    private var amount : Double = 100000000
    
    private override init() {
        super.init()
        
        servicingState = ServicingState(machine: self)
        runOutOfMoney = RunOutOfMoneyState(machine: self)
        outOfService = OutOfServiceState(machine: self)
        
        state = ServicingState(machine: self)
    }
    
    //MARK: Singleton
    private class var instance : ATMMachine{
        struct Singleton {
            static let instance = ATMMachine()
        }
        return Singleton.instance
    }
    
    class func sharedInstance() -> ATMMachine{
        return instance
    }

}
