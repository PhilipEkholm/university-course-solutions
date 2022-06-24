package laboration12;
import java.util.*;
import java.io.*;

/**
 * Metoden readPopultaions läser in ett antal länder och deras invånareantal i objekt av
 * typen Population. Popultation-objekten returneras i en Popultation-array.
 * @author Rolf
 */
public class Populations {
    private static Population[] read( String filename ) throws IOException {
        ArrayList<Population> population = new ArrayList<>();
        BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( filename ), "ISO-8859-1" ) );
        String input;
        String[] data;
        
        while( ( input = br.readLine() ) != null ) {
            data = input.split( "," );
            population.add( new Population( data[1], Integer.parseInt( data[2].replaceAll(" ","") ) ) );
        }
        br.close();
        return ( Population[] )population.toArray( new Population[]{} );
    }
    
    public static Population[] readPopulations( String filename ) {
        Population[] populations = {};
        try {
            populations = read( filename );
        }
        catch( IOException e ) {
            System.out.println( e );
        }
        return populations;
    }
    
    public static void main( String[] args ) {
        Population[] invåndare = Populations.readPopulations( "files/befolkning.txt" );
        System.out.printf( "%-30s%15s\n", "LAND", "INVÅNARE" );
        for(int i = 0; i < invåndare.length; i++ ) {
            System.out.println( invåndare[ i ].toString() );
        }
    }
}
