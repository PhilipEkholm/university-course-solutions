package laboration2;
import javax.swing.*;

public class PP6 {
	public static void main(String[] args){
		int hours = Integer.parseInt(JOptionPane.showInputDialog("Ange antal timmar"));
		int minutes = Integer.parseInt(JOptionPane.showInputDialog("Ange antal minuter"));
		int seconds = Integer.parseInt(JOptionPane.showInputDialog("Ange antal sekunder"));
		
		System.out.println("Antal sekunder: " + (hours * 3600 + minutes * 60 + seconds) + "sekunder");
	}
}
