//
//  IAccount.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

protocol IAccount {
    var accountId : String? { set get }
    var balance : Double? { set get }
    func deposite()
}
