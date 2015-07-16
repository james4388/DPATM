//
//  ATMState.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

protocol ATMState {
    func withdraw(#amount : Double, account : IAccount) -> NSError?
}
