package arrays;

import java.util.Arrays;

public class IntegerArray {
	public static int max(int[] array) {
		int max = array[0];
		
		for (int key: array) {
			if (max < key)
				max = key;
		}
		
		return max;
	}
	
	public static int min(int[] array) {
		int min = array[0];
		
		for (int key: array) {
			if (min > key)
				min = key;
		}
		
		return min;
	}
	
	public static int sum(int[] array) {
		int sum = 0;
		
		for (int key: array) {
			sum += key;
		}
		
		return sum;
	}
	
	public static double average(int[] array) {
		return (double)IntegerArray.sum(array) / array.length;
	}
	
	public static int range(int[] array) {
		return Math.abs((IntegerArray.max(array) - IntegerArray.min(array)));
	}
	
	public static void sortAsc(int[] array) {
		Arrays.sort(array);
	}
	
	public static void sortDesc(int[] array) {
		Arrays.sort(array);
		IntegerArray.reverse(array);
	}
	
	public static void reverse(int[] array) {
		int[] newArray = new int[array.length];
		
		for (int i = 0; i < array.length; ++i) {
			newArray[(array.length - 1) - i] = array[i];
		}
		
		for (int i = 0; i < array.length; ++i) {
			array[i] = newArray[i];
		}
	}
	
	public static int[] copy(int[] array) {
		int[] newArray = new int[array.length];
		
		for (int i = 0; i < array.length; ++i) {
			newArray[i] = array[i];
		}
		
		return newArray;
	}
	
	public static int median(int[] array) {
		int[] sortedArray = IntegerArray.copy(array);
		int centerIndex, median;
		
		IntegerArray.sortAsc(sortedArray);
		
		/* Check if array has an odd number of elements */
		if (array.length % 2 == 1) {
			/* Take the middle value */
			median = sortedArray[sortedArray.length / 2];
		}
		/* Array has an even number of elements */
		else {
			centerIndex = (sortedArray.length - 1) / 2;
			median = (sortedArray[centerIndex] + sortedArray[centerIndex + 1]) / 2;
		}
		
		return median;
	}
	
	public static int mode(int[] array) {
		int[] sortedArray = IntegerArray.copy(array);
		int consecs = 0, longestConsec = 0, mode = 0;
		
		IntegerArray.sortAsc(sortedArray);
		
		for (int i = 0; i < sortedArray.length -1; ++i) {
			if (sortedArray[i] == sortedArray[i + 1])
				consecs++;
			else 
				consecs = 0;
			
			if (consecs > longestConsec) {
				longestConsec = consecs;
				mode = sortedArray[i];
			}
		}
		
		return mode;
	}
	
	public static String toString(int[] array) {
		String res = "";
		
		for (int key: array) {
			res += key + ",";
		}
		
		res = res.substring(0, res.length() - 1);
		
		return ("{" + res + "}");
	}
}





