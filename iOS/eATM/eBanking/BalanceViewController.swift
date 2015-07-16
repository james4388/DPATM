//
//  BalanceViewController.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class BalanceViewController: UIViewController {

    @IBOutlet weak var balanceLabel: UILabel!
    
    @IBOutlet weak var printButton: UIButton!
    
    @IBOutlet weak var doneButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Check Balance"
        loadBalance()
        doneButton.addTarget(self, action: "solveDoneButtonClick:", forControlEvents: .TouchUpInside)
        printButton.addTarget(self, action: "solvePrintButtonClick:", forControlEvents: .TouchUpInside)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func loadBalance() {
        var user = UserAccountSingleton.getInstance()
        var balance: Double
        if user.accountType == 0 {
            balance = user.getCurrentBalance()
        } else {
            balance = user.getSavingBalance()
        }
        balanceLabel.text = "Your balance: " + balance.description
    }

    func solveDoneButtonClick(sender: UIButton!) {
        navigationController?.popViewControllerAnimated(true)
    }
    
    func solvePrintButtonClick(sender: UIButton!) {
        var user = UserAccountSingleton.getInstance()
        var accountId: String
        if user.accountType == 0 {
            accountId = user.getCurrentAccountNumber()
        } else {
            accountId = user.getSavingAccountNumber()
        }
        APIProxy.sharedInstance().printBalance(accountId, username: accountId, completionBlock: { (json: NSDictionary!, error: NSError!) -> () in
//            if error != nil {
//                AlertSingleton.getInstance().showAlert(self, message: "Print failed, try again!")
//            } else {
                AlertSingleton.getInstance().showAlert(self, message: "Print successful!")
//            }
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
