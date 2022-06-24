package laboration15;  

public class TestWageFilter {     
	public static void main( String[] args ) {         
		WageFilter filter = (WageFilter) new Interval(20000, 21000);
		
		WageEmployee[] employees = { 
			new FullTime( 19938278, 21500 ),                
			new Commission( 19278865, 0.10 ),                
			new Hours( 17233534, 95.0 ),                
			new FullTime( 27348263, 18000 )
		};         
		
		((Commission)employees[ 1 ]).setSales( 208000 );         
		(( Hours )employees[ 2 ]).setHours( 128 ); 
		
		for( int i = 0; i < employees.length; i++ ) {             
			if( filter.accept( employees[ i ] ) ) {                 
				System.out.println( employees[ i ] );             
			}         
		}     
	} 
}