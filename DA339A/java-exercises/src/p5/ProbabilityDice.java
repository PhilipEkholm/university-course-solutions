package p5;

import java.util.Random;

/**
 * 	Den här klassen skapar en tärning med justerbar normalfördelning.
 * 	Simpledice har det som kallas för rektangulär normalfördelning (samma sannolikhet för alla utfall).
 * 	
 * 	Med denna klass kan man ändra på detta och skapa en justerad normalfördelning. 
 * @author Philip Ekholm
 */

public class ProbabilityDice implements Dice{
	private int sides;
	private Random rand;
	private int[] integratedNormalDistribution; //Normalfördelningsjusteringen som passeras in
	
	/**
	 * 	Konstruktor som sätter lite variabler
	 * 	@param integratedNormalDistribution klyddigt ord för integralen av normalkurvan, får aldrig vara skilt från 100
	 */
	
	public ProbabilityDice(int[] integratedNormalDistribution){
		//Kontrollera att totala sannolikheten för hela systemet är 100%, annars kastas olaglig sannolikhet som undantag.
		
		if(ArraySupporter.sum(integratedNormalDistribution) != 100){
			throw new BadProbabilityException("Olaglig normalfördelning!");
		}
		
		//Sätt lite variabler och dylikt. Sätt antalet sidor lika med antalet tal i fältet.
		
		this.sides = integratedNormalDistribution.length;
		this.rand = new Random();
		this.integratedNormalDistribution = integratedNormalDistribution;
		this.throwDice();
	}
	
	/**
	 *	Jag är stolt över den här, en mycket fin algoritm
	 *	för att praktiskt utföra normalfördelningen.
	 *
	 * 	Min lösning är att ha en fältrepresentation som är 100 platser stor, var plats är 1%.
	 * 	Sedan fylls platserna proportionellt med en viss siffra (som motsvarar sidan), och på detta sätt kan man enkelt sen
	 * 
	 * 	Köra en rand.nextInt från (0...99) + 1 för att slumpa en viss sida. Jag finner den briljant, men du kanske har en ännu mer elegant algoritm?
	 * 	Skulle gärna vilja få se den isf!
	 * 
	 * @return något slumpmässigt valt
	 */

	@Override
	public int throwDice() {
		int	count = 0,
			result;
		int[] fieldRepresentation = new int[100];
		
		
		for(int i = 0; i < this.integratedNormalDistribution.length; i++){
			for(int j = 0; j < this.integratedNormalDistribution[i]; j++){
				fieldRepresentation[count] = i;
				count++; //En extra räknare behövs då j nollställs för var i
			}
		}
		
		result = (fieldRepresentation[rand.nextInt(100)] + 1);
		
		return result;
	}
	
	/**
	 *	Getter för att få tag på antalet sidor om man önskar det 
	 *	@return antal sidor
	 */

	@Override
	public int getSides() {
		return this.sides;
	}
	
}
