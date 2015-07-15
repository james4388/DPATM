//
//  LoginViewController.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {
    
    @IBOutlet weak var accountNumberTextField: UITextField!
    
    @IBOutlet weak var pinCodeTextField: UITextField!
    
    @IBOutlet weak var loginButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loginButton.addTarget(self, action: "solveLoginButtonClick:", forControlEvents: .TouchUpInside)
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func solveLoginButtonClick(sender: UIButton!) {
        var accountNumber = accountNumberTextField.text
        var pinCode = pinCodeTextField.text
        APIProxy.sharedInstance().login(accountNumber, password: pinCode, completionBlock: { (json: NSDictionary!, error: NSError!) -> () in
            if error != nil {
                AlertSingleton.getInstance().showAlert(self, message: "Login failed, try again!")
            } else {
                UserAccountSingleton.getInstance().setAccountNumber(accountNumber)
                self.performSegueWithIdentifier("AccountTypeViewController", sender:self)
            }
        })
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
