package laboration4;

import javax.swing.*;

public class Program4a {
	public static void main(String[] args) {
		
		int number = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett nummer"));
		
		System.out.println(number > 100 ? "Talet är större än 100" : "");
	}
}
