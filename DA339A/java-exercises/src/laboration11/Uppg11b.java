package laboration11;  

public class Uppg11b {          
	public void greaterThan8( double[] array ) {
		for(double key : array){
			if(key > 8){
				System.out.print(key + " ");
			}
		}
		
		System.out.println();
	}             
		
	public void negativeNumbers( double[] array ) {         
		for(double key : array){
			if(key < 0){
				System.out.print(key + " ");
			}
		}
		
		System.out.println();
	}
		
	public void reverse( double[] array ) {   
		String res = "Talen baklänges: ";
		
		for(int i = array.length - 1; i >= 0; i--){
			res += array[i] + " ";
		}
		
		System.out.println(res);
	}
		
	public void everyThirdReverse( double[] array ) {   
		String res = "Vart tredje tal baklänges: ";
		
		for(int i = array.length - 1; i >= 0; i -= 3){
			res += array[i] + " ";
		}  
		
		System.out.println(res);
	}
		
	public void action() {         
		//double[] numbers={ 23.2, 14.7, 17.0, -5.9, -11.1, 26.3, 8.3, 7.6 };         
		double[] numbers = { -1, 2, 5, 8, 11, 14, 10, 6, 2, -4 };                  

		greaterThan8(numbers);
		negativeNumbers(numbers);
		reverse(numbers);
		everyThirdReverse(numbers);
	}
		
	public static void main( String[] args ) {         
		Uppg11b e11b = new Uppg11b();         
		e11b.action();     
	}
}