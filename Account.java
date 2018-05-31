/**
Submitted By: Darian Koarga
Course: JAC444
Date: May 28, 2018
Contains Task 2, Account implementation
*/

import java.util.Date;

public class Account {
		private int id = 0; //id for the account
		private double balance = 0; //balance for the account
		private double annualInterestRate = 0; //stores the current interest rate
		private Date dateCreated = new java.util.Date(); //stores date when the account was created
		Account() { //no argument constructor
			id = 0;
			balance = 0;
			annualInterestRate = 0;
		}

		Account(int id_, double balance_) { //create account with specified id, initial balance
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
		public double withdraw(double amount) { //withdraw specified amount from account
			return balance -= amount;
		}
		public double deposit(double amount) { //deposit specified amount to account
			return balance += amount;
		}

		public String toString() {
			return "ID: " + id + " " +
			"Balance: " + balance + " " +
			"Annual Interest Rate: " + annualInterestRate + " " +
			"Date Created: " + dateCreated;
		}

	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		Account saving = new Saving(1133, 3000);
		Account checking = new Checking(1144, 3000);
		account.setAnnualInterestRate(4.5);

		//Test code for Task 2 - Account class
		System.out.println("Testing for Account - ");
		System.out.println("Current Account Balance: " + account.getBalance());
		System.out.println("Withdrawing $2500 from account");
		account.withdraw(2000);
		System.out.println("Depositing $3000 to account");
		account.deposit(3000);
		System.out.println("Balance " + account.getBalance());
		System.out.println("Annual Interest Rate " + account.getAnnualInterestRate());
		System.out.println("Date Created " + account.getDate());
		System.out.print("\n");
		//Test code for Task 4 - Demonstrate overdraw functionality
		//for Saving account
		System.out.println("Testing for Saving - ");
		System.out.println("Withdrawing $1000 from saving account");
		saving.withdraw(1000);
		System.out.println(saving.getBalance());
		System.out.println("Withdrawing $2001 from saving account");
		saving.withdraw(2001);
		System.out.println(saving.getBalance());
		System.out.print("\n");
		//for Checking account
		System.out.println("Testing for Checking - ");
		System.out.println("Withdrawing $3500 from checking account");
		checking.withdraw(3500);
		System.out.println(checking.getBalance());
		System.out.println("Withdrawing $1500 from checking account");
		checking.withdraw(1500);
		System.out.println(checking.getBalance());
		System.out.print("\n");

		//invoking toString() methods
		System.out.println("Invoking toString() methods for account, saving and checking");
		System.out.println(account.toString());
		System.out.println(saving.toString());
		System.out.println(checking.toString());
	}
}
