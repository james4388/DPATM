//
//  AlertSingleton.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class AlertSingleton: NSObject {
    private static var instance : AlertSingleton!
    private override init() {
        
    }
    class func getInstance() -> AlertSingleton {
        if instance == nil {
            instance = AlertSingleton()
        }
        return instance
    }
    
    func showAlert(controller: UIViewController, message: String) {
        var refreshAlert = UIAlertController(title: "EBanking Alert", message: message, preferredStyle: UIAlertControllerStyle.Alert)
        
        refreshAlert.addAction(UIAlertAction(title: "Ok", style: .Default, handler: { (action: UIAlertAction!) in
            
        }))
        
        controller.presentViewController(refreshAlert, animated: true, completion: nil)
    }
}
