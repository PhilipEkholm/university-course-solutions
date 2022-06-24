package p5;

import java.util.Random;

/**
 * Klassen OrdinaryPlayer syftar på en godtycklig spelare.
 * Spelaren har en tärning och ett tilldelat namn.
 * 
 * @version 1.0
 * @author Philip Ekholm
 */

public class Cheater extends Player{
	private Dice dice;
	private Random rand = new Random();
	
	/**
	 * 	Konstruerar en fuskare. Inargument anger namn på fuskaren som är obligatoriskt.
	 * 	En ny tärning skapas också med 6 sidor som standard.
	 * 
	 * 	@param name fuskarens namn
	*/
	
	public Cheater(String name) {
		this(name, new SimpleDice());
	}
	
	/**
	 * 	Konstruerar en fuskare. Inargument anger namn på fuskaren som är obligatoriskt,
	 * 	och en tärning med n antal sidor.
	 * 
	 * 	@param name fuskarens namn
	 * 	@param dice tärning
	*/
	
	public Cheater(String name, Dice dice){
		super(name);
		this.dice = dice;
	}
	
	/**
	 * 	Simulera ett tärningskast som tidigare, men denna gång utför extra uppgifter.
	 * 	Så länge resultatet inte är max (lika med antalet sidor), och nextBool är sann (50/50), kommer vi inkrementera med 1.
	 * 	Annars returnerar vi som vanligt.
	 * 
	 * 	@return slumpmässigt värde från (1...(antal sidor - 1)) +1 om #1 sann, annars 1...antal sidor
	*/

	@Override
	public int throwDice() {
		int result = rand.nextInt(this.dice.getSides()) + 1;
		
		//Om antalet sidor på tärningen INTE är lika med resultatet (alltså max) OCH bool är sann (50% av gången) lägg på en till
		if(!(this.dice.getSides() == result) && (rand.nextBoolean())){
			result++; //Gör INTE detta direkt i return då den kommer returnera först, sedan inkrementera
			return result;
		}
		else{
			return result;
		}
	}
	
	/**
	 * 	En getter för att komma åt tärningen inuti cheater-objektet
	 * 
	 * 	@return tärning tilldelad cheater-objektet
	*/

	public Dice getDice() {
		return dice;
	}
	
	/**
	 *	En setter för att tilldela fuskaren en ny tärning
	 *
	 * 	@param dice ny tärning
	*/

	public void setDice(Dice dice) {
		this.dice = dice;
	}
}
