//
//  AccountLoginObject.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class AccountLoginObject: Mappable {
    var accountID : String?
    var balance : Double?
    var type : String?
    required init?(_ map: Map) {
        mapping(map)
    }
    func mapping(map: Map) {
        accountID     <- map["accountId"]
        balance  <- map["balance"]
        type  <- map["type"]
    }
}
