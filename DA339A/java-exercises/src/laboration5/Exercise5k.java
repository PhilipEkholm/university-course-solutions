package laboration5;

import java.util.Random;

public class Exercise5k {
	public void kasta(){
		Random rand = new Random();
		int kast, antal = 0;
		
		kast = rand.nextInt(6) + 1;
		
		while(kast != 1){
			antal += 1;
			System.out.println("Detta gav: " + kast);
			kast = rand.nextInt(6) + 1;
		}
		
		System.out.println("Antalet kast utan etta: " + antal);
	}
	
	public static void main(String[] args) {
		Exercise5k rndDice = new Exercise5k();
		
		rndDice.kasta();
	}
}
