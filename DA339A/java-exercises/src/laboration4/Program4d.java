package laboration4;

import javax.swing.*;

public class Program4d {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Skriv in ditt förnamn");
		
		System.out.println(name.length() < 6 ? "”AAAA, ditt namn är kort och fint!" : "AAAA, ditt namn är långt och svårstavat!");
	}
}
