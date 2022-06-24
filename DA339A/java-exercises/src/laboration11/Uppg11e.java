package laboration11;

public class Uppg11e {
	public int member(int nbr, int[] array){
		return ArraySupporter.findFirstTargetIndex(nbr, array);
	}
	
	public static void main(String[] args) {
		Uppg11e app = new Uppg11e(); 
		int[] array = { 1, 2, 3, 9, 5, 9 }; 
		int index; index = app.member( 7, array ); 
		
		System.out.println( "Position för 7: " + index );
		index = app.member( 9, array);
		System.out.println( "Position för 9: " + index );
	}
}
