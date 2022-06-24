package laboration12; 
import java.util.*;  

public class RunPopulation {     
	public void program() {         
		Population[] countries = Populations.readPopulations( "files/befolkning.txt" );         
		Arrays.sort( countries );
		
		for( int i = 0; i < countries.length; i++ ) {             
			System.out.println(countries[ i ].toString() );
		}     
	}          
	
	public static void main( String[] args ) {         
		RunPopulation app = new RunPopulation();
		app.program();
	} 
}