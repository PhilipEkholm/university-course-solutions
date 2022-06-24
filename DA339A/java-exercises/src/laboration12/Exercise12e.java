package laboration12; 
import java.util.*;  

public class Exercise12e {     
	public void program() {         
		Population[] countries = Populations.readPopulations( "files/befolkning.txt" );         
		Arrays.sort(countries, new AlphabeticalOrder() );
		
		for( int i = 0; i < countries.length; i++ ) {             
			System.out.println(countries[ i ].toString() );         
		}     
		
	}          
	
	public static void main( String[] args ) {         
		Exercise12e e12e = new Exercise12e();         
		e12e.program();     
	} 
}