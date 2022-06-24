package laboration12;

/*
 *	Klassen skriven av Philip Ekholm 2016-10-22
 *
 * 	Klassen erbjuder stödfunktionalitet för 
 * 	arrayer i java, då de inte har egen större funktionalitet.
 * 
 * 	Källkoden får ej lov att delas utanför gruppen.
*/

public class ArraySupporter{
	public static double sum(double[] field){
		double sum = 0;
		
		for(int i = 0; i < field.length; i++){
			sum += field[i];
		}
		
		return sum;
	}
	
	public static double sum(int[] field){
		double sum = 0;
		
		for(int i = 0; i < field.length; i++){
			sum += field[i];
		}
		
		return sum;
	}
	
	public static double sum(long[] field){
		double sum = 0;
		
		for(int i = 0; i < field.length; i++){
			sum += field[i];
		}
		
		return sum;
	}
	
	public static int[] reverse(int[] array){
		int[] reversedArray = new int[array.length];
		int k = 0;
		
		for(int i = array.length -1; i >= 0; i--){
			reversedArray[i] = array[k];
			k++;
		}
		
		return reversedArray;
	}
	
	public static double[] reverse(double[] array){
		double[] reversedArray = new double[array.length];
		int k = 0;
		
		for(int i = array.length -1; i >= 0; i--){
			reversedArray[i] = array[k];
			k++;
		}
		
		return reversedArray;
	}
	
	public static long[] reverse(long[] array){
		long[] reversedArray = new long[array.length];
		int k = 0;
		
		for(int i = array.length -1; i >= 0; i--){
			reversedArray[i] = array[k];
			k++;
		}
		
		return reversedArray;
	}
	
	public static String toString(int[] array){
		String res = "[";
		
		for(int i = 0; i < array.length; i++){
			res += array[i];
			
			if(!(i == array.length -1)){
				res += ", ";
			}
		}
		
		res += "]";
		
		return res;
	}
	
	public static String toString(double[] array){
		String res = "[";
		
		for(int i = 0; i < array.length; i++){
			res += array[i];
			
			if(!(i == array.length -1)){
				res += ", ";
			}
		}
		
		res += "]";
		
		return res;
	}
	
	public static String toString(long[] array){
		String res = "[";
		
		for(int i = 0; i < array.length; i++){
			res += array[i];
			
			if(!(i == array.length -1)){
				res += ", ";
			}
		}
		
		res += "]";
		
		return res;
	}
	
	public static int findFirstTargetIndex(int target, int[] array){
		for(int i = 0; i < array.length; i++){
			if(target == array[i]){
				return i;
			}
		}
		
		return -1;
	}
	
	public static double findFirstTargetIndex(double target, double[] array){
		for(int i = 0; i < array.length; i++){
			if(target == array[i]){
				return i;
			}
		}
		
		return -1;
	}
	
	public static long findFirstTargetIndex(long target, long[] array){
		for(int i = 0; i < array.length; i++){
			if(target == array[i]){
				return i;
			}
		}
		
		return -1;
	}
	
	public static int[] cut(int[] array, int startIndex, int stopIndex){
		int[] reducedArray;
		
		if(startIndex > stopIndex){
			int tmp;
			
			tmp = startIndex;
			startIndex = stopIndex;
			stopIndex = tmp;
		}
		
		reducedArray = new int[(stopIndex + 1) - startIndex];
		
		int k = 0;
		for(int i = startIndex; i <= stopIndex; i++){
			reducedArray[k] = array[i];
			k++;
		}
		
		return reducedArray;
	}
	
	public static double[] cut(double[] array, int startIndex, int stopIndex){
		double[] reducedArray;
		
		if(startIndex > stopIndex){
			int tmp;
			
			tmp = startIndex;
			startIndex = stopIndex;
			stopIndex = tmp;
		}
		
		reducedArray = new double[(stopIndex + 1) - startIndex];
		
		int k = 0;
		for(int i = startIndex; i <= stopIndex; i++){
			reducedArray[k] = array[i];
			k++;
		}
		
		return reducedArray;
	}
	
	public static long[] cut(long[] array, int startIndex, int stopIndex){
		long[] reducedArray;
		
		if(startIndex > stopIndex){
			int tmp;
			
			tmp = startIndex;
			startIndex = stopIndex;
			stopIndex = tmp;
		}
		
		reducedArray = new long[(stopIndex + 1) - startIndex];
		
		int k = 0;
		for(int i = startIndex; i <= stopIndex; i++){
			reducedArray[k] = array[i];
			k++;
		}
		
		return reducedArray;
	}
	
	public static int maxValue(int[] array){
		int maximalValue = Integer.MIN_VALUE;
		
		for(int key: array){
			maximalValue = Math.max(maximalValue, key);
		}
		
		return maximalValue;
	}
	
	public static double maxValue(double[] array){
		double maximalValue = Double.MIN_VALUE;
		
		for(double key: array){
			maximalValue = Math.max(maximalValue, key);
		}
		
		return maximalValue;
	}
	
	public static long maxValue(long[] array){
		long maximalValue = Long.MIN_VALUE;
		
		for(long key: array){
			maximalValue = Math.max(maximalValue, key);
		}
		
		return maximalValue;
	}
	
	public static int minValue(int[] array){
		int minimalValue = Integer.MAX_VALUE;
		
		for(int key: array){
			minimalValue = Math.min(minimalValue, key);
		}
		
		return minimalValue;
	}
	
	public static double minValue(double[] array){
		double minimalValue = Integer.MAX_VALUE;
		
		for(double key: array){
			minimalValue = Math.min(minimalValue, key);
		}
		
		return minimalValue;
	}
	
	public static long minValue(long[] array){
		long minimalValue = Integer.MAX_VALUE;
		
		for(long key: array){
			minimalValue = Math.min(minimalValue, key);
		}
		
		return minimalValue;
	}
	
	public static int[] sort(int[] array) {
	    boolean swapped = true;
	    int j = 0;
	    int tmp;
	    
	    while (swapped) {
	        swapped = false;
	        j++;
	        
	        for (int i = 0; i < array.length - j; i++) {
	            if (array[i] > array[i + 1]) {
	                tmp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = tmp;
	                swapped = true;
	            }
	        }
	    }
	    
	    return array;
	}
	
	public static double[] sort(double[] array) {
	    boolean swapped = true;
	    int j = 0;
	    double tmp;
	    
	    while (swapped) {
	        swapped = false;
	        j++;
	        
	        for (int i = 0; i < array.length - j; i++) {
	            if (array[i] > array[i + 1]) {
	                tmp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = tmp;
	                swapped = true;
	            }
	        }
	    }
	    
	    return array;
	}
	
	public static long[] sort(long[] array) {
	    boolean swapped = true;
	    int j = 0;
	    long tmp;
	    
	    while (swapped) {
	        swapped = false;
	        j++;
	        
	        for (int i = 0; i < array.length - j; i++) {
	            if (array[i] > array[i + 1]) {
	                tmp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = tmp;
	                swapped = true;
	            }
	        }
	    }
	    
	    return array;
	}
}











