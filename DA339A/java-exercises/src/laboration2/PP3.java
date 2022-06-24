package laboration2;

import javax.swing.*;

public class PP3 {
	public static void main(String[] args){
		float num1 = Float.parseFloat(JOptionPane.showInputDialog("Mata in första talet"));
		float num2 = Float.parseFloat(JOptionPane.showInputDialog("Mata in andra talet"));
		
		float sum = num1 + num2;
		float difference = num1 - num2;
		float product = num1 * num2;
		
		System.out.println("Summa: " + sum);
		System.out.println("Differens: " + difference);
		System.out.println("Produkt: " + product);
	}
}
