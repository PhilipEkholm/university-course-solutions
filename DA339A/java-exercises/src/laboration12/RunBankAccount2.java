package laboration12;
import java.util.*;
import javax.swing.*;

public class RunBankAccount2 {
	public static void main(String[] args) {
		BankAccount[] accounts = new BankAccount[ 5 ]; 
		String res = "";
		accounts[ 0 ] = new BankAccount( "28397652", 5000, 0.01 ); 
		
		accounts[ 1 ] = new BankAccount( "78537465", 3000, 0.02 ); 
		accounts[ 2 ] = new BankAccount( "19567835", 15000, 0.015 ); 
		accounts[ 3 ] = new BankAccount( "48728775", 11000, 0.002 ); 
		accounts[ 4 ] = new BankAccount( "46786562", 4000, 0.003 ); 
		
		Arrays.sort(accounts, new BalanceDescending()); 
		
		for( int i = 0; i < accounts.length; i++ ) {     
			res += "Konto: " + accounts[ i ].getAccountNbr() + ", saldo = " + accounts[ i ].getBalance() 
				+ ", ränta = " + accounts[ i ].getInterestRate() + "\n"; } JOptionPane.showMessageDialog( null, res );
	}
}
