package laboration5;

import javax.swing.*;

public class Exercise5L {
	public static void main(String[] args) {
		int minimumInterval = Integer.parseInt(JOptionPane.showInputDialog("Ange lägre intervall")),
			maximumInterval,
			sumOfInterval = 0;
		
		String numbersInInterval = "";
		
		do{
			maximumInterval = Integer.parseInt(JOptionPane.showInputDialog("Ange högre intervall"));
		}
		while(maximumInterval <= minimumInterval);
		
		for(int i = minimumInterval; i <= maximumInterval; i++){
			numbersInInterval += i + ", ";
			sumOfInterval += i;
		}
		
		JOptionPane.showMessageDialog(null, "Intervall: [" + minimumInterval  + ", " + maximumInterval + "]\n" + "Tal i intervallet: " + numbersInInterval + "\n" + "Talens summa: " + sumOfInterval);
	}
}
