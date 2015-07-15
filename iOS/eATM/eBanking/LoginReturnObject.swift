//
//  LoginReturnObject.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class LoginReturnObject: Mappable {
    var result: String?
//    var userAuthenticate: Boolean?
    var user: UserLoginiObject?
    required init?(_ map: Map) {
        mapping(map)
    }
    func mapping(map: Map) {
        result     <- map["result"]
//        userAuthenticate  <- map["userAuthenticate"]
        user  <- map["user"]
    }
}
