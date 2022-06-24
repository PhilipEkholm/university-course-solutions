package arrays;

public class Integer2DArrays {
	public static int elements(int[][] array) {
		int elements = 0;
		
		for (int[] key: array)
			elements += key.length;
		
		return elements;
	}
	
	public static int max(int[][] array) {
		int max = array[0][0];
		
		for (int[] key: array) {
			max = (max < IntegerArray.max(key) ? IntegerArray.max(key): max); 
		}
		
		return max;
	}
	
	public static int min(int[][] array) {
		int min = 0;
		
		for (int[] key: array) {
			min = (min > IntegerArray.min(key) ? IntegerArray.min(key): min); 
		}
		
		return min;
	}
	
	public static int sum(int[][] array) {
		int sum = 0;
		
		for (int[] key: array) {
			sum += IntegerArray.sum(key);
		}
		
		return sum;
	}
	
	public static double average(int[][] array) {
		return (double)Integer2DArrays.sum(array) / Integer2DArrays.elements(array);
	}
	
	public static String toString(int[][] array) {
		String res = "";
		
		for (int[] key: array)
			res += IntegerArray.toString(key) + ",";
		
		res = res.substring(0, res.length() - 1);
		
		return ("{" + res + "}");
	}
}
