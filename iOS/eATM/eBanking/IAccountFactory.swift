//
//  IAccountFactory.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/16/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import Foundation

protocol IAccountFactory{
    func createAccount(type : String!) -> IAccount
}