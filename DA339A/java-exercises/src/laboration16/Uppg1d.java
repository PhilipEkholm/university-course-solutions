package laboration16;

import resources.InOut;

public class Uppg1d {
	public static void main( String[] args ) {         
		InOut io = new InOut();         
		double nbr = io.readDouble( "Mata in ett flyttal" );         
		
		System.out.println("Inmatat tal: " + nbr);     
	}
}
