package laboration4;

import javax.swing.JOptionPane;

public class Program4c {
	public static void main(String[] args) {
		int age = Integer.parseInt(JOptionPane.showInputDialog("Skriv in din ålder"));
		
		System.out.println(age <= 17 ? "Du är ett barn" : "Du är vuxen");
	}
}
