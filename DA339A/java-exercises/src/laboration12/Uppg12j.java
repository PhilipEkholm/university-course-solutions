package laboration12;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Uppg12j {
	public static void main(String[] args) {
		Employee[] manpower = new Employee[ 4 ]; 
		
		String res = ""; manpower[ 0 ] = new Employee( "Grön, Bengt", "SEB", 26700 ); 
		manpower[ 1 ] = new Employee( "Al, Eva", "Hamnkontoret", 22400 ); 
		manpower[ 2 ] = new Employee( "Ek, Blanca", "Hemköp", 28200 ); 
		manpower[ 3 ] = new Employee( "Svensson, Ove", "Stadium", 25500 ); 
		
		Arrays.sort(manpower, new AlphabeticalEmployeeOrder()); 
		
		for( int i = 0; i < manpower.length; i++ ) {     
			res += manpower[ i ].toString() + "\n"; 
		} 
		
		JOptionPane.showMessageDialog( null, res );
	}
}
