package p5axel;

/**
 * 
 * Denna klassen skapar ett player-objekt
 * 
 * F�rsta konstruktorn anv�nds ifall det bara skickas med ett namn och ger d� denna spelaren en 6 sidig t�rning
 * Andra konstruktorn anv�nds ifall b�de namn och antal sidor skickas med
 * 
 * Metoden setDice g�r det m�jligt att �ndra v�rdet av dice fr�n en annan klass
 * Metoden getDice retunerar v�rdet av dice
 * Metoden throwDice retunerar v�rdet av throwDice fr�n klassen SimpleDice
 * 
 * @author Axel Bengtsson
 * 
 * @param name 		tar emot en String med ett namn p� en spelare
 * @param dice		tar emot antalet sidor p� en t�rning
 * 
 * @return dice 			retunerar v�rdet av dice
 * @return dice.throwDice 	retunerar v�rdet av throwDice fr�n klassen SimpleDice
 */

//Javadoc måste användas framför var metod!


public class OrdinaryPlayer extends Player{
	
	private Dice dice;
	
	public OrdinaryPlayer(String name){
		super (name);
		dice = new SimpleDice(6); //Kan förenklas lite och göras mer konsekvent
	}
	
	public OrdinaryPlayer(String name, Dice dice) {
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
		return dice.throwDice();
	}
}
