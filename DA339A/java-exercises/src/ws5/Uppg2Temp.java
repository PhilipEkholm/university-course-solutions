package ws5;

public class Uppg2Temp {
	public static void main(String[] args) {
		int[] temperatures = {
				5, 10, 13, 17, 23, 25, 27, 27, 27, 28, 26, 24, 20, 17, 14, 10, 10, 10, 9
		};
		
		int sum = ArraySupporter.sum(temperatures);
		
		System.out.println(sum/temperatures.length);
	}
}
