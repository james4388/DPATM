//
//  APIProxy.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class APIProxy: NSObject, APIInteface {
    
    private var realObject : APIRemoteRealObject!
    
    private class var instance : APIProxy{
        struct Singleton {
            static let instance = APIProxy()
        }
        return Singleton.instance
    }
    
    class func sharedInstance() -> APIProxy{
        return instance
    }
    
    private override init() {
        super.init()
        realObject = APIRemoteRealObject()
    }
    
    //MARK: implement APIInterface
    func login(username: String!, password: String!, completionBlock: APICompletionHandler) {
        
        // show loading view
        
        realObject.login(username, password: password) { (response: NSDictionary!, error : NSError!) -> () in
            // hide loading view
            dispatch_async(dispatch_get_main_queue(), { () -> Void in
                
                completionBlock(response, error)
            })
        }
    }
}
