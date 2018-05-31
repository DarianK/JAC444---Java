/**
Submitted By: Darian Koarga
Course: JAC444
Date: May 31, 2018
Contains Task 4, Checking Account Implementation
*/
public class Checking extends Account {
  private double overdraft = -1000; //account can be overdrawn by up to $1000
  Checking(int id_, double balance_) {super(id_, balance_);} //invoke superclass constructor to create a checking account
  public double withdraw(double amount) { //withdraw specified amount from account
    if((super.getBalance() - amount) < overdraft) {
      System.out.println("You have exceeded your overdraw limit of $1000");
      return super.getBalance();
    }
    else {
      return super.withdraw(amount);
    }
  }
}
