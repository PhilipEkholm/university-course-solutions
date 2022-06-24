package p5;

public class RunUppg5b {
	public static void main(String[] args) {
		SimpleDice tärning = new SimpleDice( 6 );
		Player spelare1 = new OrdinaryPlayer( "Gustav", tärning );
		Player spelare2 = new OrdinaryPlayer( "Valborg", tärning );
		Game spel = new Game( spelare1, spelare2 );
		spel.play( true );
	}
}
