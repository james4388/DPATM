//
//  UserLoginiObject.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class UserLoginiObject: Mappable {
    var userId : String?
    var firstName: String?
    var lastName: String?
    var email: String?
    var accounts: [AccountLoginObject]?
    
    required init?(_ map: Map) {
        mapping(map)
    }
    func mapping(map: Map) {
        userId     <- map["userId"]
        firstName  <- map["firstName"]
        lastName     <- map["lastName"]
        email  <- map["email"]
        accounts     <- map["accounts"]
    }
}
