package laboration5;

import javax.swing.*;
import java.util.Random;

public class Exercise5m {
	public static void main(String[] args) {
		Random rnd = new Random();
		int number;
		
		do{
			number = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett tal mellan 10-20"));
		}while((number <= 10) || (number >= 20));
		
		System.out.print(number + ": ");
		
		for(int i = 1; i <= number; i++){
			System.out.print(i + " ");
		}
	}
}
