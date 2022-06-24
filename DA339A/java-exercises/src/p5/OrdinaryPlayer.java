package p5;

/**
 * Klassen OrdinaryPlayer syftar på en godtycklig spelare.
 * Spelaren har en tärning och ett tilldelat namn.
 * 
 * @version 1.0
 * @author Philip Ekholm
 */

public class OrdinaryPlayer extends Player{
	private Dice dice;
	
	/**
	 * 	Konstruerar en vanlig spelare. Inargument anger namn på spelaren som är obligatoriskt.
	 * 	En ny tärning skapas också med 6 sidor som standard.
	 * 
	 * 	@param name spelarens namn
	*/
	public OrdinaryPlayer(String name){
		this(name, new SimpleDice());
	}
	
	/**
	 * 	Konstruerar en vanlig spelare. Inargument anger namn på spelaren som är obligatoriskt,
	 * 	och en tärning med n antal sidor.
	 * 
	 * 	@param name spelarens namn
	 * 	@param dice tärning
	*/
	public OrdinaryPlayer(String name, Dice dice){
		super(name);
		this.dice = dice;
	}
	
	/**
	 * 	Simulerar ett tärningskast, notera + 1 för att undvika 0
	 * 
	 * 	@return slumpmässigt värde från 1...antal sidor
	*/

	@Override
	public int throwDice() {
		return dice.throwDice();
	}
	
	/**
	 * 	En getter för att komma åt tärningen inuti player-objektet
	 * 
	 * 	@return tärning tilldelad player-objektet
	*/

	public Dice getDice() {
		return dice;
	}
	
	/**
	 *	En setter för att tilldela spelaren en ny tärning
	 *
	 * 	@param dice ny tärning
	*/

	public void setDice(Dice dice) {
		this.dice = dice;
	}
}
