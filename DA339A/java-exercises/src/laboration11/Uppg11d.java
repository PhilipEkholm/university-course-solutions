package laboration11;

public class Uppg11d{
	public static void main(String[] args) {
		Uppg11d app = new Uppg11d(); 
		
		int[] arr1 = { 1, 2, 3 }; 
		int[] arr2 = { 1000, 100, 10, 1 }; 
		
		System.out.print( "Array 1 baklänges: " ); 
		app.reverse( arr1 ); 
		System.out.println(); 
		System.out.print( "Array 2 baklänges: " ); 
		app.reverse( arr2 ); 
		System.out.println();
	}
	
	public void reverse(int[] array){
		int[] reversedArray = ArraySupporter.reverse(array);
		
		for(int i = 0; i < reversedArray.length; i++){
			System.out.print(reversedArray[i]);
			
			if(!(i == reversedArray.length - 1)){
				System.out.print(", ");
			}
		}
	}
}
