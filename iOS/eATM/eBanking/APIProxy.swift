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
    
    //MARK: Singleton
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
        LoadingView.sharedInstance().startLoading()
        realObject.login(username, password: password) { (response: NSDictionary!, error : NSError!) -> () in
            // hide loading view
            dispatch_async(dispatch_get_main_queue(), { () -> Void in
                completionBlock(response, error)
                LoadingView.sharedInstance().stopLoading()
            })
        }
    }
    
    
    func printTransactionBalance(transactionID: String!, completionBlock handler: APICompletionHandler) {
        // show loading view
        LoadingView.sharedInstance().startLoading()
        realObject.printTransactionBalance(transactionID, completionBlock: { (json : NSDictionary!, error : NSError!) -> Void in
            // hide loading view
            dispatch_async(dispatch_get_main_queue(), { () -> Void in
                handler(json, error)
                LoadingView.sharedInstance().stopLoading()
            })

        })
    }

        
    func printBalance(accountId: String!, username: String!, completionBlock handler: APICompletionHandler) {
        
        // show loading view
        LoadingView.sharedInstance().startLoading()
        realObject.printBalance(accountId, username: username) { (response: NSDictionary!, error : NSError!) -> () in
            // hide loading view
            dispatch_async(dispatch_get_main_queue(), { () -> Void in
                handler(response, error)
                LoadingView.sharedInstance().stopLoading()
            })
        }
    }

}
