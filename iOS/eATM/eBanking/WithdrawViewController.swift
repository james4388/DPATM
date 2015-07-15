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
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        submitButton.layer.cornerRadius = 5;
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
    
    
    @IBAction func didTouchedOnSubmitButton(sender: UIButton) {
        view.endEditing(true)
        
        // submit to Web service and navigate to Transaction Complete/Transaction Fail
        performSegueWithIdentifier("TransactionFailViewController", sender: self)
    }

}
