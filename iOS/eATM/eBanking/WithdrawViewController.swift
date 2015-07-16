//
//  WithdrawViewController.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/14/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class WithdrawViewController: UIViewController {

    @IBOutlet weak var amountTextField: UITextField!
    
    @IBOutlet weak var otpCodeTextField: UITextField!
    
    @IBOutlet weak var submitButton: UIButton!
    
    var amount : Double?
    
    var challengeID : String?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        submitButton.layer.cornerRadius = 5;
        
        if let amount = amount{
            amountTextField.text = String(format: "%.0f", amount)
            amountTextField.userInteractionEnabled = false
            
        }
        
        getOTP()
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
    
    private func getOTP(){
    
        APIProxy.sharedInstance().getOTP(ATMMachine.sharedInstance().atmID, accountID: UserAccountSingleton.getInstance().currentAccount?.accountId) { (json : NSDictionary!, error : NSError!) -> Void in
            if error == nil{
                if let subJson = json["challenge"] as? NSDictionary{
                    self.challengeID = subJson["challengeId"] as? String
                    
                    AlertSingleton.getInstance().showAlert(self, message: "An OTP Code is sent to your email. Please check and get OTP Code in order to proceed this transaction")
                }
                
            }else{
                self.challengeID = nil
            }
        }
    }
    
    @IBAction func didTouchedOnSubmitButton(sender: UIButton) {
        view.endEditing(true)
        // submit to Web service and navigate to Transaction Complete/Transaction Fail
        APIProxy.sharedInstance().withdraw(amountTextField.text, accountId: UserAccountSingleton.getInstance().currentAccount?.accountId, challengID: self.challengeID, otpCode: otpCodeTextField.text, atmID: ATMMachine.sharedInstance().atmID) { (json : NSDictionary!, error : NSError!) -> Void in
            if error == nil{
                
                var err = ATMMachine.sharedInstance().withdrawAmount((self.amountTextField.text as NSString).doubleValue)
                if err == nil{
                    var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
                    if let completed = storyboard.instantiateViewControllerWithIdentifier("TransactionCompleteViewController") as? TransactionCompleteViewController{
                        if let transactionID = json["transactionId"] as? String{
                            completed.transactionID = transactionID
                            self.navigationController?.pushViewController(completed, animated: true)
                        }
                        
                    }
                }else{
                    if let message = err!.userInfo![NSLocalizedDescriptionKey] as? String{
                        AlertSingleton.getInstance().showAlert(self, message: message)
                    }
                }
                
            }else{
                if let message = error.userInfo![NSLocalizedDescriptionKey] as? String{
                    AlertSingleton.getInstance().showAlert(self, message: message)
                }
                
            }
        }
        
    }

}
