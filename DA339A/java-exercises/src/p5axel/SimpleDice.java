package p5axel;

import java.util.Random;


/**
 *  
 * Denna klassen skapar ett t�rningsobjekt med ett antal sidor
 * 
 * F�rsta konstuktorn anv�nds endast ifall den andra inte anv�nds och d� f�r t�rningen 6 sidor.
 * Andra konstruktorn l�ter anv�ndaren mata in ett v�rde
 * 
 * Metoden throwDice genererar fram en slumpad siffra baserat p� antalet sidor 
 * Metoden getSides retunerar sides n�r man kallar p� den
 * 
 * @author Axel Bengtsson
 * 
 * @param sides		tar emot antalet sidor som anv�ndaren har matat in
 * 
 * @return sides 	retunerar antalet sidor som t�rningen har n�r man kallar p� metoden getSides
 *
 */

//Javadoc måste användas framför var metod!

public class SimpleDice implements Dice {
	
	int diceThrows; //Se nedan
	private int sides;
	
	Random rand = new Random(); //Instansvariabler här har paketsynlighet, slarvigt.
	
	public SimpleDice(){
		this(6);
	}

	public SimpleDice(int sides){
		this.sides = sides;
		if (sides<=0){
			throw new NegativeSidesException("T�rning m�ste ha flera sidor: " + sides);
		}
	}
	
	public int throwDice() {
		int diceThrows;
		diceThrows=rand.nextInt(sides)+1;
		return diceThrows;
	}

	public int getSides() {
		return sides;
	}
}
