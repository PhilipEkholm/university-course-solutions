package p5;

public class RunUppg5e {
	public static void main(String[] args) {
		TestDice.test( new OrdinaryPlayer( "Rut", new SimpleDice( 6 ) ), 1000000 );
		TextWindow.println();
		TestDice.test( new Cheater( "Fuffe", new SimpleDice( 6 ) ), 1000000 );
	}
}
