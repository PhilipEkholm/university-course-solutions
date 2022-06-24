package laboration11;

public class Uppg11g {
	
	public double[] reverse(double[] array){
		return ArraySupporter.reverse(array);
	}
	
	public static void main(String[] args) {
		Uppg11g app = new Uppg11g();
		
		double[] array = { 3.2, 4.7, -13.1, 14, 17.25 };  
		double[] copy = app.reverse( array ); 
		
		for( int i = 0; i < array.length; i++ ){
			System.out.print( array[ i ] + "  " );
		}
		
		System.out.println(); 
		
		for( int i = 0; i < copy.length; i++ ){ 
			System.out.print(copy[ i ] + "  " ); 
		}
		
		System.out.println();
	}
}
