//
//  HomeViewController.swift
//  eBanking
//
//  Created by Dat Tran on 7/15/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class HomeViewController: UIViewController {

    @IBOutlet weak var checkBalanceButton: UIButton!
    
    @IBOutlet weak var payBillButton: UIButton!
    
    @IBOutlet weak var changePinCodeButton: UIButton!
    
    @IBOutlet weak var draw20Button: UIButton!
    
    @IBOutlet weak var draw50Button: UIButton!
    
    @IBOutlet weak var drawAnotherButton: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        checkBalanceButton.addTarget(self, action: "solveCheckBalanceButtonClick:", forControlEvents: .TouchUpInside)
        payBillButton.addTarget(self, action: "solvePayBillButtonClick:", forControlEvents: .TouchUpInside)
        changePinCodeButton.addTarget(self, action: "solveChangePinCodeButtonClick:", forControlEvents: .TouchUpInside)
        draw20Button.addTarget(self, action: "solveDraw20ButtonClick:", forControlEvents: .TouchUpInside)
        draw50Button.addTarget(self, action: "solveDraw50ButtonClick:", forControlEvents: .TouchUpInside)
        drawAnotherButton.addTarget(self, action: "solveDrawAnotherButtonClick:", forControlEvents: .TouchUpInside)

        // keep track Home screen
        if let appDelegate = UIApplication.sharedApplication().delegate as? AppDelegate{
            appDelegate.homeScreen = self
        }

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func solveCheckBalanceButtonClick(sender: UIButton!) {
        self.performSegueWithIdentifier("BalanceViewController", sender:self)
    }
    
    func solvePayBillButtonClick(sender: UIButton!) {
        var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
        if let payBill = storyboard.instantiateViewControllerWithIdentifier("PayBillViewController") as? UIViewController{
            navigationController?.pushViewController(payBill, animated: true)
        }
        
    }
    
    func solveChangePinCodeButtonClick(sender: UIButton!) {
        var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
        if let changePinCode = storyboard.instantiateViewControllerWithIdentifier("ChangePinCodeViewController") as? UIViewController{
            navigationController?.pushViewController(changePinCode, animated: true)
        }
    }
    
    func solveDraw20ButtonClick(sender: UIButton!) {
        var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
        if let withdraw = storyboard.instantiateViewControllerWithIdentifier("WithdrawViewController") as? WithdrawViewController{
            withdraw.amount = 20;
            navigationController?.pushViewController(withdraw, animated: true)
        }
    }
    
    func solveDraw50ButtonClick(sender: UIButton!) {
        var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
        if let withdraw = storyboard.instantiateViewControllerWithIdentifier("WithdrawViewController") as? WithdrawViewController{
            withdraw.amount = 50;
            navigationController?.pushViewController(withdraw, animated: true)
        }
    }
    
    func solveDrawAnotherButtonClick(sender: UIButton!) {
        var storyboard = UIStoryboard(name: "Transaction", bundle: nil)
        if let withdraw = storyboard.instantiateViewControllerWithIdentifier("WithdrawViewController") as? WithdrawViewController{
            navigationController?.pushViewController(withdraw, animated: true)
        }
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
