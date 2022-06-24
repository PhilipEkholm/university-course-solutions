package laboration5;

import java.util.Random;
import javax.swing.JOptionPane;

public class Exercise5g {
	public void exer5g() {     
		int number, randomValue, sum = 0;  
		Random rand = new Random();     
		number = Integer.parseInt( JOptionPane.showInputDialog( "Antal slumptal" ) );     
		
		System.out.println( "Slumptal: " );     
		
		for( int i = 1 ; i <= number ; i++ ) {         
			randomValue = rand.nextInt(20) + 5;         
			System.out.print( randomValue + " " );
			sum += randomValue;
		}
		
		System.out.println();
		
		System.out.println("Antal slumptal: " + number);
		System.out.println("Summan av slumptalen: " + sum);
	}
	
	public static void main(String[] args) {
		Exercise5g exercise = new Exercise5g();
		
		exercise.exer5g();
		
		
	}
}
