package laboration13;

public class RunMedia {
	public static void main(String[] args) {
		String[] mel = { "Mel 1", "Melodi 2", "Melodi 3", "Mel 4" }; 
		CD cd = new CD( 39488852, "TITEL" ,"ARTIST", mel ); 
		System.out.println( "----- Test av get-metoder -----" ); 
		System.out.println( cd.getId() + ", " + cd.getArtist() + ", " +                      
		cd.getTitle() ); System.out.println( "----- Test av toString -----" ); 
		System.out.println( cd.toString() ); 
		System.out.println( "----- Test av set-metoder -----" ); 
		cd.setArtist( "Ulf Lundell" ); 
		cd.setTitle( "Vargmåne" ); 
		cd.setSongs( new String[]{ "M1", "M2", "M3", "M4", "M5", "M6" } ); 
		System.out.println( cd.toString());
	}
}
