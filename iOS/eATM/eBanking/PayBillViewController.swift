//
//  PayBillViewController.swift
//  eBanking
//
//  Created by Tai Huu Ho on 7/14/15.
//  Copyright (c) 2015 Tai Huu Ho. All rights reserved.
//

import UIKit

class PayBillViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var headerLabel: UILabel!
    
    var bills = [Bill]()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        //dummy data
        
        bills.append(Bill(ID: "1", name: "Cellular(30$)"))
        bills.append(Bill(ID: "2", name: "Net(20$)"))
        bills.append(Bill(ID: "3", name: "Water(20$)"))
        bills.append(Bill(ID: "4", name: "Electricity(30$)"))
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
    
    //MARK: Handler
    
    @IBAction func didTouchedOnBillItem(sender: UIButton) {
        
        bills.removeAtIndex(sender.tag)
        
        tableView.beginUpdates()
        tableView.deleteRowsAtIndexPaths([NSIndexPath(forRow: sender.tag, inSection: 0)], withRowAnimation: .Left)
        tableView.endUpdates()
        
        tableView.reloadData()
        
        var random = arc4random_uniform(5)
        if random % 2 == 1{
            performSegueWithIdentifier("TransactionCompleteViewController", sender: self)
        }else{
            performSegueWithIdentifier("TransactionFailViewController", sender: self)
        }
        
    }

    //MARK: UITableViewDelegate, UITableViewDataSource
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1;
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if bills.count > 0{
            headerLabel.text = "Bills to pay"
        }else{
            headerLabel.text = "No bill"
        }
        return bills.count
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        var bill = bills[indexPath.row]
        
        var cell = tableView.dequeueReusableCellWithIdentifier("PayBillTableViewCell") as! PayBillTableViewCell
        cell.billButton.tag = indexPath.row
        cell.billButton.setTitle(bill.billName, forState: .Normal)
        
        return cell
    }
}
