package laboration4;

import javax.swing.*;

public class Program4l {
	//Löser simpla förstagradsekvationer av formen ax + b = 0
	
	public static void main(String[] args) {
		float a = Float.parseFloat(JOptionPane.showInputDialog("Skriv in a (Om x inte har en koefficient skriv in 1)")),
			b = Float.parseFloat(JOptionPane.showInputDialog("Skriv in konstanten b"));
		String res = "Något gick fel";
		
		if (a == 0){
			res = "Inte en ekvation då a = 0";
		}
		else{
			res = "x = " + -(b/a);
		}
		
		System.out.println(res);
	}
}
