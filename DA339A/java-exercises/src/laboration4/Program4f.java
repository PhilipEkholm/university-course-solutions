package laboration4;

import javax.swing.*;

public class Program4f {
	public static void main(String[] args) {
		int firstNumber = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett förstatal")),
			secondNumber = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett andratal"));
		String res = "";
		
		if(firstNumber > secondNumber){
			res = "Det första talet är större än det andra";
		}
		else if(firstNumber < secondNumber){
			res = "Det andra talet är större än det första";
		}
		else if(firstNumber == secondNumber){
			res = "De är lika stora";
		}
		else{
			res = "Något gick fel";
		}
		
		System.out.println(res);
	}
}
