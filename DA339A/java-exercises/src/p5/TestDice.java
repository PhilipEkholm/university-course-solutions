package p5;

public class TestDice {
	/*
	 *	TestDice innehåller 2 klassmetoder för att analysera normalfördelning
	 *	Man slumpar 100 000 gånger, lagrar det och kollar på den "högupplösta" fördelningen.
	 */
	
	public static void test(Dice dice, int numberOfThrows){
		//Skapa en array som får plats för alla sidors utfall.
		int[] statistics = new int[dice.getSides()];
		
		//Lägg på +1 för var utfall
		for(int i = 0; i < numberOfThrows; i++){
			statistics[dice.throwDice() - 1]++;
			
		}
		
		TextWindow.println(ArraySupporter.toString(statistics));
	}
	
	/*
	 *	Den här lösningen är inte så elegant då den innehåller kod som återkommer.
	 *	Din lösning är kanske bättre här? 
	 */
	
	public static void test(Player player, int numberOfThrows){
		int[] statistics;
		
		//Kolla vilken instanstyp den är av. Skapa isf den varianten och sätt statistics-fältet.
		
		if(player instanceof Cheater){
			Cheater cheater = (Cheater)player;
			statistics = new int[cheater.getDice().getSides()];
			
			for(int i = 0; i < numberOfThrows; i++){
				statistics[cheater.throwDice() - 1]++;
			}
		}
		
		//Samma sak här, en aningens repeterande.
		else if(player instanceof OrdinaryPlayer){
			OrdinaryPlayer ordPlayer = (OrdinaryPlayer)player;
			statistics = new int[ordPlayer.getDice().getSides()];
			
			for(int i = 0; i < numberOfThrows; i++){
				statistics[ordPlayer.throwDice() - 1]++;
			}
		}
		else{
			//Förhoppningsvis kommer vi aldrig hit, då har någon ärvat en klass som inte borde existera!
			System.out.println("Spelaren är varken eller av dem!");
			statistics = new int[1];
		}
		
		TextWindow.println(ArraySupporter.toString(statistics));
	}
}
