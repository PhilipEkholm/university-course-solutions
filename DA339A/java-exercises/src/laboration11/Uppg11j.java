package laboration11;

import java.util.Random;

public class Uppg11j {
	public static void main(String[] args) {
		Random dice1 = new Random(),
			   dice2 = new Random(),
			   dice3 = new Random();
					
		int[] sum = new int[20];
		int currentSum = 0;
		
		for(int i = 0; i < 100000; i++){
			currentSum = dice1.nextInt(7) + dice2.nextInt(7) + dice3.nextInt(7) + 3;
			
			sum[currentSum - 3]++;
		}
		
		System.out.println("Summa  " + "Antal");
		for(int i = 3; i <= 18; i++){
			System.out.println(i + "   " + sum[i - 3]);
		}
	}
}
