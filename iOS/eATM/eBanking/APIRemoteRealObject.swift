//
//  APIRealObject.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class APIRemoteRealObject: NSObject, APIInteface {
    
    var endpoint : NSURL!
    
    override init() {
        super.init()
        endpoint = NSURL(string : "http://10.10.14.18:8080")
    }
    
    private func paramsKeyPairString(params : Dictionary<String, String>!) -> String{
        var result = NSMutableArray()
        for (key : String, value : String) in params{
            result.addObject(String(format: "%@=%@", key, value))
        }
        return result.componentsJoinedByString("&")
    }
    
    private func createRequestForPath(requestPath : String!, method : String!, params : Dictionary<String, String>!) -> NSMutableURLRequest{
        var request = NSMutableURLRequest(URL: NSURL(string: requestPath, relativeToURL: endpoint)!)
        request.timeoutInterval = 7
        request.HTTPMethod = method
        if params != nil {
            request.HTTPBody = paramsKeyPairString(params).dataUsingEncoding(NSUTF8StringEncoding, allowLossyConversion: false)
        }
        
        return request
    }
    
    private func sendGetRequest(requestPath: String!, params : Dictionary<String, String>!, completionBlock handler: (NSDictionary?, NSError?) -> ()){
        var request = createRequestForPath(requestPath, method: "GET", params: params)
        
        NSURLConnection.sendAsynchronousRequest(request, queue: NSOperationQueue.mainQueue()) { (response : NSURLResponse!, data : NSData!, error : NSError!) -> Void in
            if error != nil{
                handler(nil, error)
            }else{
                if let json = NSJSONSerialization.JSONObjectWithData(data, options: NSJSONReadingOptions.AllowFragments, error: nil) as? NSDictionary{
                    if json["result"] as? String == "OK"{
                        handler(json, nil)
                    }else{
                        handler(nil, NSError(domain: "eATM", code: 1000, userInfo: [NSLocalizedDescriptionKey : json["message"] as! String]))
                    }
                    
                }else{
                    handler(nil, NSError(domain: "eATM", code: 100, userInfo: [NSLocalizedDescriptionKey : "Wrong JSON format"]))
                }
            }
            
        }
    }
    

    private func sendPOSTRequest(requestPath: String!, params : Dictionary<String, String>!, completionBlock handler: (NSDictionary?, NSError?) -> ()){
        var request = createRequestForPath(requestPath, method: "POST", params: params)
        
        NSURLConnection.sendAsynchronousRequest(request, queue: NSOperationQueue.mainQueue()) { (response : NSURLResponse!, data : NSData!, error : NSError!) -> Void in
            if error != nil{
                handler(nil, error)
            }else{
                if let json = NSJSONSerialization.JSONObjectWithData(data, options: NSJSONReadingOptions.AllowFragments, error: nil) as? NSDictionary{
                    if json["result"] as? String == "OK"{
                        handler(json, nil)
                    }else{
                        handler(nil, NSError(domain: "eATM", code: 1000, userInfo: [NSLocalizedDescriptionKey : json["message"] as! String]))
                    }
                }else{
                    handler(nil, NSError(domain: "eATM", code: 100, userInfo: [NSLocalizedDescriptionKey : "Wrong JSON format"]))
                }
            }
            
        }
    }
    
    //MARK: Implement APIInterface
    func login(username: String!, password: String!, completionBlock handler: APICompletionHandler) {
        sendPOSTRequest("account/login", params: ["userid" : username, "pincode" : password ]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    
    func printTransactionBalance(transactionID: String!, completionBlock handler: APICompletionHandler) {
        sendGetRequest(String(format: "transaction/%@/print", transactionID), params: nil) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    func printBalance(accountId: String!, username: String!, completionBlock handler: APICompletionHandler) {
        sendGetRequest("account/" + accountId + "/print/", params: ["userid" : username]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    func changePinCode(userId : String!, oldPinCode: String!, newPinCode: String!, completionBlock handler: APICompletionHandler) {
        sendPOSTRequest("account/changepin", params: ["userid" : userId,"pincode" : oldPinCode, "newPincode" : newPinCode ]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    func getAllBill(userID: String!, completionBlock handler: APICompletionHandler) {
        
        sendPOSTRequest("bill/userbill", params: ["userid" : userID]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    func payBill(billID: String!, atmID: String!, accountID: String!, completionBlock handler: APICompletionHandler) {
        sendPOSTRequest(String(format: "bill/%@/pay", billID), params: ["accountId" : accountID, "atmId" : atmID]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    func getOTP(atmID: String!, accountID: String!, completionBlock handler: APICompletionHandler) {
        sendPOSTRequest("otp", params: ["accountId" : accountID, "atmId" : atmID]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
    
    func withdraw(amount: String!, accountId : String!, challengID: String!, otpCode: String!, atmID: String!, completionBlock handler: APICompletionHandler) {
        
        sendPOSTRequest(String(format: "account/%@/withdraw", accountId), params: ["amount" : amount, "challengeId" : challengID, "otpCode" : otpCode, "atmId" : atmID]) { (json : NSDictionary?, error : NSError?) -> () in
            handler(json, error)
        }
    }
}
