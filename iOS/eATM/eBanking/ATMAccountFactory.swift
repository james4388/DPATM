//
//  ATMAccountFactory.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/16/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class ATMAccountFactory: NSObject,IAccountFactory {
    func createAccount(type : String!) -> IAccount{
        if type == "Saving"{
            return SavingAccount()
        }else{
            return CurrentAccount()
        }
    }
}
