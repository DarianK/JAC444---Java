/**
Submitted By: Darian Koarga
Course: JAC444
Date: May 31, 2018
Contains Task 4, Saving Account Implementation
*/
public class Saving extends Account {
  private double overdraft = 0; //prevents account from being overdrawn
  Saving(int id_, double balance_) { super(id_, balance_); } //invoke superclass constructor to create a saving account
  public double withdraw(double amount) {
    //if amount withdrawn exceeds account balance, print error message
    if((super.getBalance() - amount) < overdraft) {
      System.out.println("Account cannot be overdrawn");
      return super.getBalance(); //return the balance without withdrawing
    }
    else {
      return super.withdraw(amount); //withdraw the amount and reutrn new balance
    }
  }
}
