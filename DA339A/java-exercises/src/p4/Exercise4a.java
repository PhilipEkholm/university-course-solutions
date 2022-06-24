package p4;

import javax.swing.JOptionPane;

import arrays.IntegerArray;

public class Exercise4a {
	public static int[] parseString( String str ) {
		String[] nbr = str.split( "," ); // Ex: strängen "13,4,7,9" blir arrayen {"13","4","7","9"}
		int[] res = new int[ nbr.length ];
		for( int i = 0; i < nbr.length; i++ ) {
			res[ i ] = Integer.parseInt( nbr[i] );
		}
		return res;
	}
	
    public static void main(String[] args) {
    	String message = "";
        String str = JOptionPane.showInputDialog( null, "Mata in heltal separerade med komma-tecken", "1,5,3,4,6,5,3,5,9,7,6");
        int[] test1 = parseString( str );
        int[] test2;
        
        message += "Vektor: " + IntegerArray.toString( test1 ) + "\n";
        message += "Störst: " + IntegerArray.max( test1 ) + "\n";
        message += "Minst: " + IntegerArray.min( test1 ) + "\n";
        message += "Summa: " + IntegerArray.sum( test1 ) + "\n";
        message += "Medelvärde: " + String.format( "%1.2f", IntegerArray.average( test1 ) ) + "\n";
        message += "Range: " + IntegerArray.range(test1) + "\n";
        test2 = IntegerArray.copy(test1);
        message += "test2: " + IntegerArray.toString( test2 ) + "\n";
        IntegerArray.sortAsc(test1);
        IntegerArray.sortDesc(test2);
        message += "test1: " + IntegerArray.toString( test1 ) + "\n";
        message += "test2: " + IntegerArray.toString( test2 ) + "\n";
        
        message += "Median: " + IntegerArray.median(test2) + "\n";
        message += "Typvärde: " + IntegerArray.mode(test2) + "\n";
        JOptionPane.showMessageDialog( null, message );
    }
}
