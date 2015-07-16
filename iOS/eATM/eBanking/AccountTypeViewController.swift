//
//  AccountTypeViewController.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class AccountTypeViewController: UIViewController {
    @IBOutlet weak var currentAccountButton: UIButton!

    @IBOutlet weak var savingAccountButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Choose Account"
        currentAccountButton.addTarget(self, action: "solveCurrentAccountButtonClick:", forControlEvents: .TouchUpInside)
        savingAccountButton.addTarget(self, action: "solveSavingAccountButtonClick:", forControlEvents: .TouchUpInside)
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func solveCurrentAccountButtonClick(sender: UIButton!) {
        UserAccountSingleton.getInstance().accountType = 0
        UserAccountSingleton.getInstance().currentAccount = ATMAccountFactory.factory().createAccount(0)
        self.performSegueWithIdentifier("HomeViewController", sender:self)
    }
    
    func solveSavingAccountButtonClick(sender: UIButton!) {
        UserAccountSingleton.getInstance().accountType = 1
        UserAccountSingleton.getInstance().currentAccount = ATMAccountFactory.factory().createAccount(1)
        
        self.performSegueWithIdentifier("HomeViewController", sender:self)
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
