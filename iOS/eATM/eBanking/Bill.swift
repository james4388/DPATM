//
//  Bill.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/14/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class Bill: NSObject {
    var billID: String?
    var billName: String?
   
    override init(){
        
    }
    
    init(ID: String!, name: String!){
        billID = ID
        billName = name
    }
    
}
