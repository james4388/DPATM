//
//  TransactionCompleteViewController.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/14/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class TransactionCompleteViewController: UIViewController {

    @IBOutlet weak var printButton: UIButton!
    var transactionID : String?
    var isChangePin = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        if isChangePin {
            printButton.hidden = true
        } else {
            printButton.hidden = false
        }
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

    @IBAction func print(sender: UIButton) {
        // send Prind command to server
        APIProxy.sharedInstance().printTransactionBalance(self.transactionID, completionBlock: { (json : NSDictionary!, error: NSError!) -> Void in
            if error == nil{
                AlertSingleton.getInstance().showAlert(self, message: "Check the Printer to get your Receipt")
            }else{
                if let message = error.userInfo![NSLocalizedDescriptionKey] as? String{
                    AlertSingleton.getInstance().showAlert(self, message: message)
                }
            }
        })
    }
    
    
    @IBAction func yes(sender: UIButton) {
        // go back Home screen
        if let appDelegate = UIApplication.sharedApplication().delegate as? AppDelegate{
            if let homeScreen = appDelegate.homeScreen{
                navigationController?.popToViewController(homeScreen, animated: true)
            }
        }
    }
    
}
