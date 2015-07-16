//
//  ChangePinCodeViewController.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/16/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class ChangePinCodeViewController: UIViewController {
    @IBOutlet weak var oldPinCodeTextField: UITextField!

    @IBOutlet weak var newPinCodeTextField: UITextField!
    override func viewDidLoad() {
        self.title = "Change Pin"
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

    
    @IBAction func submit(sender: UIButton) {
        
        view.endEditing(true)
        var user = UserAccountSingleton.getInstance()
        var accountId: String
        if user.accountType == 0 {
            accountId = user.getCurrentAccountNumber()
        } else {
            accountId = user.getSavingAccountNumber()
        }
        APIProxy.sharedInstance().changePinCode(UserAccountSingleton.getInstance().userInfo?.user?.userId, oldPinCode: oldPinCodeTextField.text, newPinCode: newPinCodeTextField.text) { (json : NSDictionary!, error : NSError!) -> Void in
            
            var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
            if error == nil{
                if let success = storyboard.instantiateViewControllerWithIdentifier("TransactionCompleteViewController") as? TransactionCompleteViewController{
                    success.isChangePin = true
                    self.navigationController?.pushViewController(success, animated: true)
                }
            }else{
                if let fail = storyboard.instantiateViewControllerWithIdentifier("TransactionFailViewController") as? UIViewController{
                    self.navigationController?.pushViewController(fail, animated: true)
                }
            }
        }
    }
}
