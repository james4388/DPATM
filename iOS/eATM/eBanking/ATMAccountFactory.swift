//
//  ATMAccountFactory.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/16/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class ATMAccountFactory: NSObject,IAccountFactory {
    
    //MARK: Singleton
    private class var instance : ATMAccountFactory{
        struct Singleton {
            static let instance = ATMAccountFactory()
        }
        return Singleton.instance
    }
    
    class func factory() -> ATMAccountFactory{
        return instance
    }
    
    private override init() {
        super.init()
    }
    
    func createAccount(type : Int!) -> IAccount?{
        if let accounts = UserAccountSingleton.getInstance().userInfo?.user?.accounts as [AccountLoginObject]?{
            if type == 1{
                return SavingAccount(accountLoginObject: accounts[1])
            }else{
                return CurrentAccount(accountLoginObject: accounts[0])
            }
        }
        return nil
    }
}
