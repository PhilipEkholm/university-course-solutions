package laboration4;

import javax.swing.*;

//Ett progaram för att lösa fullständiga andragradsekvationer på formen x^2+px+q=0

public class Program4n {
	public static void main(String[] args) {
		double p = Double.parseDouble(JOptionPane.showInputDialog("Skriv in p")),
			   q = Double.parseDouble(JOptionPane.showInputDialog("Skriv in q"));
		
		if(Math.pow(p, 2)/4 - q < 0){
			JOptionPane.showMessageDialog(null, "Funktionen saknar reela rötter!");
		}
		else if (Math.pow(p, 2)/4 - q == 0){
			JOptionPane.showMessageDialog(null, "Dubbelrot. Funktionen har enbart en lösning då x = " + -(p/2));
		}
		else{
			double x1 = -(p/2) + Math.sqrt( Math.pow(p/2, 2) - q),
					x2 = -(p/2) - Math.sqrt( Math.pow(p/2, 2) - q);
			JOptionPane.showMessageDialog(null, "Funktionen har två lösningar, x1 = " + x1 + ", och x2 = " + x2);
		}
	}
}
