/**
Submitted By: Darian Koarga
Course: JAC444
Date: May 31, 2018
Contains Task 3, Account menu implementation
*/

import java.util.Date;
import java.util.Scanner;

public class Accounts {
		private int id = 0; //id for the account
		private double balance = 0; //balance for the account
		private double annualInterestRate = 0; //stores the current interest rate
		private Date dateCreated = new java.util.Date(); //stores date when the account was created
		Accounts() { //no argument constructor
			id = 0;
			balance = 0;
			annualInterestRate = 0;
		}

		Accounts(int id_, double balance_) { //create account with specified id, initial balance
			id = id_;
			balance = balance_;
		}

		//accessor methods for id, balance, annualInterestRate
		public int getId() { return id; }
		public double getBalance() { return balance; }
		public double getAnnualInterestRate() { return annualInterestRate; }

		//mutator methods for id, balance, annualInterestRate
		void setId(int id_) { id = id_; }
		void setBalance(double balance_) { balance = balance_; }
		void setAnnualInterestRate(double annualInterestRate_) { annualInterestRate = annualInterestRate_; }

		//accessor for dateCreated
		Date getDate() { return dateCreated; }

		double getMonthlyInterestRate() { //return monthly interest rate
			return annualInterestRate / 12;
		}
		double getMonthlyInterest() { //return monthly interest
			double monthlyInterestRate = getMonthlyInterestRate();
			return balance * monthlyInterestRate;
		}
		double withdraw(double amount) { //withdraw specified amount from account
			return balance -= amount;
		}
		double deposit(double amount) { //deposit specified amount to account
			return balance += amount;
		}

	public static void main(String[] args) {
		//create an array of 10 accounts with ids 0,1,...,9 and set initial balance to 100
		Accounts[] a = new Accounts[10];
		for(int i = 0; i != a.length; i++) {
			a[i] = new Accounts();
			a[i].setBalance(100);
		}
		Scanner input = new Scanner(System.in);
		while(true) { //create a continuous loop
			System.out.print("Enter an id: ");
			int id = input.nextInt(); //user enters id
			if(id < 0 || id > 9) { //terminate program if user inputs invalid account i
				System.out.println("Invalid id entered. Terminating program.");
				System.exit(0);
			}
			int option = 0;
			while(option != 4) {
				System.out.print("Main menu" + "\n" +
				"1. check balance" + "\n" +
				"2. withdraw" + "\n" +
				"3. deposit" + "\n" +
				"4. exit" + "\n" +
				"Enter a choice: ");
				option = input.nextInt(); //user selects option from menu
				if(option < 0 || option > 4) {
					System.out.println("Invalid option. Please enter a menu option between 1 and 4.");
				}
			switch(option) {
				case 1: //output account balance
				System.out.print("The balance is ");
				System.out.println(a[id].getBalance() + "\n");
				break;
				case 2: //user inputs withdrawl amount
				System.out.print("Enter an amount to withdraw: ");
				double amount = input.nextInt();
				a[id].withdraw(amount);
				System.out.print("\n");
				break;
				case 3: //user inputs deposit amount
				System.out.print("Enter an amount to deposit: ");
				double amount_ = input.nextInt();
				a[id].deposit(amount_);
				System.out.print("\n");
				break;
				case 4: //return to id select
				System.out.print("\n");
				break;
				}
			}
		}
	}
}

