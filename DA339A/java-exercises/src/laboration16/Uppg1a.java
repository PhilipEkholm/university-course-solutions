package laboration16;
import javax.swing.*;

public class Uppg1a {
	public static void main(String[] args) {
		int value = 0; 
		boolean inputOK = false; 
		
		do {     
			try {         
				value = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));         
				inputOK = true;     
			}      
			catch( NumberFormatException ex ) {
				
			} 
		} 
		while( inputOK == false ); 
		
		System.out.println("Inmatat tal: " + value);
	}
}
