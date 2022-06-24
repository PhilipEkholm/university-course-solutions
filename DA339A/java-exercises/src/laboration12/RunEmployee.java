package laboration12;
import javax.swing.*;
import java.util.Arrays;

public class RunEmployee {
	public static void main(String[] args) {
		String res = ""; 
		Employee[] manpower = new Employee[ 5 ]; 
		manpower[ 0 ] = new Employee( "Grön, Bengt", "SEB", 26700 ); 
		manpower[ 1 ] = new Employee( "Edberg, Eva", "Hamnkontoret", 22400 ); 
		manpower[ 2 ] = new Employee( "Ek, Blanca", "SEB", 28200 ); 
		manpower[ 3 ] = new Employee( "Svensson, Ove", "SEB", 25500 ); 
		manpower[ 4 ] = new Employee( "Al, Berit", "Hamnkontoret", 24500 ); 
		
		Arrays.sort(manpower, new EmployeeSort()); 
		
		for( int i = 0; i < manpower.length; i++ ) {     
			res += manpower[ i ].toString() + "\n"; 
		} 
		
		JOptionPane.showMessageDialog( null, res ); 
	}
}
