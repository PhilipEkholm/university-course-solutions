package laboration6;

import javax.swing.JOptionPane;

public class BankAccount {
	private String accountNbr;
	private double 	balance,
					interestRate;
	
	public void init(String accountNbr, double balance, double interestRate) {
		this.accountNbr = accountNbr;
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
}
