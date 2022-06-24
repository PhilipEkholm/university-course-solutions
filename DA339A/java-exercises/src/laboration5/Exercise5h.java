package laboration5;

import javax.swing.*;

public class Exercise5h {
	public static void main(String[] args) {
		int year;
		do{
			year = Integer.parseInt(JOptionPane.showInputDialog("Skriv in år, mata in ett negativt tal för att avsluta programmet"));
			String res = "Något gick fel";
			
			if(year < 1582 && year >= 0){
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
		while(year > 0);
	}
}
