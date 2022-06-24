package laboration4;

import javax.swing.*;

public class Program4b {
	public static void main(String[] args) {
		int number = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett meddelande"));
		
		System.out.println(number > 100 ? "Talet är större än 100" : "Talet är högst 100");
	}
}
