package p5;

import java.util.Random;

/**
 * Klassen SimpleDice är en abstraktion av en tärning. 
 * Man kan ge den hur många sidor som helst av naturlig talmängd.
 * Man kan också simulera ett godtyckligt kast.
 * 
 * When overriding a method, you might want to use the @Override annotation 
 * that instructs the compiler that you intend to override a method in the superclass. 
 * If, for some reason, the compiler detects that the method does not exist in one of 
 * the superclasses, then it will generate an error. For more information on @Override, see Annotations.
 * 
 * @version 1.0
 * @author Philip Ekholm
 */

public class SimpleDice implements Dice{
	private int sides;
	private Random rand = new Random();
	
	/**
     * Konstruerar ett SimpleDice-objekt. Då antal sidor inte matas in ges
     * sex sidor som standard.
     */
	public SimpleDice(){
		this(6);
	}
	
	/**
	 * 	Konstruerar ett SimpleDice-objekt. Inargument anger antal sidor och kastar
	 * 	Ett undantag som det är felaktigt.
	 * 
	 * 	@param sides antalet sidor
	*/
	public SimpleDice(int sides){
		if(sides <= 0){
			throw new NegativeSidesException("En tärning kan inte innehava negativa sidor eller inga. Inmatad sida: " + this.sides);
		}
		else{
			this.sides = sides;
		}
	}
	
	/**
	 *	Simulerar ett godtyckligt tärningskast. random-objekt används
	 *	och +1 för att undvika 0.
	 *
	 * 	@return "slumpmässigt" värde från 1...antal sidor
	*/

	@Override
	public int throwDice() {
		return (rand.nextInt(this.sides) + 1);
	}
	
	/**
	 *	En getter för att komma åt antalet sidor tärningen har.
	 *	@return antalet sidor 
	*/

	@Override
	public int getSides() {
		return this.sides;
	}

}
