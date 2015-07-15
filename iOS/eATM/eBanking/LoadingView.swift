//
//  LoadingView.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class LoadingView: NSObject {
    
    
    private var activityView : UIActivityIndicatorView
    
    override init() {
        activityView = UIActivityIndicatorView(activityIndicatorStyle: UIActivityIndicatorViewStyle.WhiteLarge)
        activityView.color = UIColor.redColor()
        activityView.hidesWhenStopped = true
        
        if let appDelegate = UIApplication.sharedApplication().delegate as? AppDelegate{
            if let window = appDelegate.window{
                window.addSubview(activityView)
                activityView.center = window.center
            }
        }
    }
    
    //MARK: Singleton
    private class var instance : LoadingView{
        struct Singleton {
            static let instance = LoadingView()
        }
        return Singleton.instance
    }
    
    class func sharedInstance() -> LoadingView{
        return instance
    }
    
    func startLoading(){
        activityView.startAnimating()
    }
    
    func stopLoading(){
        activityView.stopAnimating()
    }
}
