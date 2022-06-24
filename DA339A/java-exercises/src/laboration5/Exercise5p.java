package laboration5;

import javax.swing.*;

public class Exercise5p {
	public static void main(String[] args) {
		int totalCost = 0,
			numberOfTerms = 0;
		
		String str = JOptionPane.showInputDialog("Ange en utgift (Avbryt för att avsluta");
		
		while(str != null){
			numberOfTerms++;
			str = JOptionPane.showInputDialog("Ange en utgift (Avbryt för att avsluta");
			try{
				totalCost += Integer.parseInt(str);
			}
			finally{
				
			}
		}
		
		JOptionPane.showMessageDialog(null, "Antal inköp: " + numberOfTerms + "\nTotal kostnad: " + totalCost);
	}
}
