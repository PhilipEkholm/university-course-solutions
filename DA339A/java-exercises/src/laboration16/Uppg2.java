package laboration16; 
import resources.InOut;  

public class Uppg2 {    
	public static void main( String[] args ) {         
		double real;         
		int nbr;         
		real = InOut.readDouble();         
		
		System.out.println( "Inmatat tal: " + real );         
		real = InOut.readDouble( "Mata in ett stort decimaltal" );         
		System.out.println( "Inmatat tal: " + real );        
		nbr = InOut.readInt();         
		System.out.println( "Inmatat tal: " + nbr );         
		nbr = InOut.readInt("Mata in ett positivt heltal");
		System.out.println( "Inmatat tal: " + nbr );     } }