package laboration11;

public class Uppg11a {     
	public void action() {         
		double[] numbers = { 23.2, 14.7, 17.0, -5.9, -11.1, 26.3, 8.3, 7.6 };
		//double[] numbers = { -1, 2, 5, 8, 11, 14, 10, 6, 2, -4 };         
		int counter = 0;         
		double sum = 0;         
		String res = "Talen baklänges: ";                 
		
		for(double key : numbers){
			if(key > 8){
				counter++;
			}
		}
		
		System.out.println(counter);
	}
	
	public static void main(String[] args ) {         
		Uppg11a e11a = new Uppg11a();         
		e11a.action();     
	}
}