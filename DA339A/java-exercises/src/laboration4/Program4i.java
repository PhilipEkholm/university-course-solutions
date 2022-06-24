package laboration4;

import javax.swing.*;

public class Program4i {
	public static void main(String[] args) {
		int year = Integer.parseInt(JOptionPane.showInputDialog("Skriv in år"));
		String res = "Något gick fel";
		
		if(year < 1582){
			res = "Året är före den gregorianska kalendern";
		}
		else if(year % 4 == 0){
			if(year % 100 == 0){
				res = "Året är inte ett skottår";
			}
			else{
				res = "Året är ett skottår";
			}
		}
		else{
			res = "Året är inte ett skottår";
		}
		
		System.out.println(res);
	}
}
