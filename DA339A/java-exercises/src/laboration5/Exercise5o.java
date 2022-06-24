package laboration5;

import javax.swing.*;

public class Exercise5o {
	public static void main(String[] args) {
		int startingNumber = Integer.parseInt(JOptionPane.showInputDialog("Ange startvärde")),
			sumRequired = Integer.parseInt(JOptionPane.showInputDialog("Ange lägsta summa")),
			amountOfTerms = 0,
			sum = 0;
		String numbers = "";
		
		for(int i = startingNumber; sum <= sumRequired; i++){
			amountOfTerms++;
			sum += i;
			numbers += i + ", ";
		}
		
		JOptionPane.showMessageDialog(null, "Det krävs " + amountOfTerms + " termer: [" + numbers + "]");
	}
}
