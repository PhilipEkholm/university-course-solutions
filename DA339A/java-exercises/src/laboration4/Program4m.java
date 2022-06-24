package laboration4;

import javax.swing.*;

public class Program4m {
	public static void main(String[] args) {
		int a = Integer.parseInt(JOptionPane.showInputDialog("Skriv in första talet")),
			b = Integer.parseInt(JOptionPane.showInputDialog("Skriv in andra talet")),
			c = Integer.parseInt(JOptionPane.showInputDialog("Skriv in tredje talet"));
		
		int tal1,
			tal2,
			tal3;
		
		tal1 = Math.min(Math.min(a, b), c);
		tal3 = Math.max(Math.max(a, b), c);
		
		
	}
}
