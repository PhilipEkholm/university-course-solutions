package p5axel;

import java.util.Random;

/**
 * 
 * Denna klassen skapar ett cheater-objekt 
 * 
 * F�rsta konstruktorn anv�nds ifall det bara skickas med ett namn och ger d� denna spelaren en 6 sidig t�rning
 * Andra konstruktorn anv�nds ifall b�de namn och antal sidor skickas med
 * 
 * Metoden setDice g�r det m�jligt att �ndra v�rdet av dice fr�n en annan klass
 * Metoden getDice retunerar v�rdet av dice
 * Metoden throwDice kollar ifall det slagna talet �r det st�rsta och om inte s� l�ggs antingen 1 eller 0 till p� den slagan siffran och lagras d� i cheatResult
 * 
 * @author Axel Bengtsson
 * 
 * @param name 		Tar emot en String med ett namn p� en spelare.
 * @param dice		Tar emot antalet sidor p� en t�rning.
 * 
 * @return dice 			Retunerar v�rdet av dice.
 * @return cheatResult		Retunerar v�rdet av cheatResult.
 *
 */

//Javadoc måste användas framför var metod!

public class Cheater extends Player {
private Dice dice; //Fel indentering här
private Random rand = new Random();
	
	public Cheater(String name){
		super (name);
		dice = new SimpleDice(6); //Kan göras mer konsekvent
	}
	
	public Cheater(String name, Dice dice) {
		super (name);
		this.dice=dice;
	}

	public void setDice(Dice dice){
		this.dice=dice;
	}
	
	public Dice getDice(){
		return dice;
	}

	public int throwDice() {
		int cheatResult = dice.throwDice();
		int cheat=rand.nextInt(2);
		
		if (cheatResult!=dice.getSides()){
			cheatResult=cheatResult+cheat;
		}
		
		return cheatResult;
	}
}
