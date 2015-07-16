//
//  IAccount.swift
//  eBanking
//

//  Created by Tai Huu Ho on 7/16/15.

//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

protocol IAccount {
    var accountId : String? { set get }

    var balance : Double { set get }
    
    func deposite(amount: Double) -> Bool
    func withdraw(amount: Double) -> Bool
}
