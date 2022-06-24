package laboration7;

import javax.swing.JOptionPane;

public class BankAccount {
	private String accountNbr;
	private double 	balance,
					interestRate;
	
	public BankAccount(String accountNumber) {
		this.accountNbr = accountNumber;
		balance = 0;
		interestRate = 0.005;
	}
	
	public BankAccount(String accountNumber, double balance, double interestRate) {
		this.accountNbr = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdrawal(double amount) {
		balance -= amount;
	}
	
	public void info() {
		JOptionPane.showMessageDialog(null, "Account number: " + accountNbr + "\n" + "Balance: " + balance);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getAccountNbr() {
		return accountNbr;
	}

	public double getBalance() {
		return balance;
	}
}
