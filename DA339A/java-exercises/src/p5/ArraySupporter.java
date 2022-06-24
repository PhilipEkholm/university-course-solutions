package p5;

/*
 *	Klassen skriven av Philip Ekholm 2016-10-22
 *
 * 	Klassen erbjuder stödfunktionalitet för 
 * 	arrayer i java, då de inte har egen större funktionalitet.
*/

public class ArraySupporter{
	
	public static double average(int[] array){
		double sum = 0;
		
		for(int key: array){
			sum += key;
		}
		
		return (sum / array.length);
	}
	
	public static double average(double[] array){
		double sum = 0;
		
		for(double key: array){
			sum += key;
		}
		
		return (sum / array.length);
	}
	
	public static double average(long[] array){
		double sum = 0;
		
		for(double key: array){
			sum += key;
		}
		
		return (sum / array.length);
	}
	
	public static int[] copy(int[] array){
		int[] newArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		
		return newArray;
	}
	
	public static double[] copy(double[] array){
		double[] newArray = new double[array.length];
		
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		
		return newArray;
	}
	
	public static long[] copy(long[] array){
		long[] newArray = new long[array.length];
		
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		
		return newArray;
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
	
	public static double median(int[] array){
		int[] newArray = ArraySupporter.copy(array);
		
		ArraySupporter.sort(newArray);
		
		int count = newArray.length;
		float position;
				
		
		if(count % 2 != 0){
			position = ((count -1) / 2); //Tar fram mittersta värdet, går något fel under testning kan det vara positionen
			return newArray[(int)position];
		}
		else if(count % 2 == 0){ //Antalet värden är jämnt
			int a, b;
			position = (count / 2);
			
			a = newArray[(int)position];
			b = newArray[((int)position) - 1];
			
			position = ((a + b) / 2);
			return newArray[(int)position];
		}
		else{
			System.out.println("Något gick fel i median-metoden");
			return newArray[0];
		}
	}

	public static String[] merge(String[] array1, String[] array2){
		int totalLength = array1.length + array2.length;
		
		String[] merged = new String[totalLength];
		
		for(int i = 0; i < totalLength; i++){
			if(array1.length > i){
				merged[i] = array1[i];
			}
			else{
				merged[i] = array2[i - array1.length];
			}
		}
		
		return merged;
	}

	public static int[] merge(int[] array1, int[] array2){
		int totalLength = array1.length + array2.length;
		
		int[] merged = new int[totalLength];
		
		for(int i = 0; i < totalLength; i++){
			if(array1.length > i){
				merged[i] = array1[i];
			}
			else{
				merged[i] = array2[i - array1.length];
			}
		}
		
		return merged;
	}

	public static double[] merge(double[] array1, double[] array2){
		int totalLength = array1.length + array2.length;
		
		double[] merged = new double[totalLength];
		
		for(int i = 0; i < totalLength; i++){
			if(array1.length > i){
				merged[i] = array1[i];
			}
			else{
				merged[i] = array2[i - array1.length];
			}
		}
		
		return merged;
	}

	public static long[] merge(long[] array1, long[] array2){
		int totalLength = array1.length + array2.length;
		
		long[] merged = new long[totalLength];
		
		for(int i = 0; i < totalLength; i++){
			if(array1.length > i){
				merged[i] = array1[i];
			}
			else{
				merged[i] = array2[i - array1.length];
			}
		}
		
		return merged;
	}
	
	public static int mostCommonNumber(int[] a){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
	  
		for (int i = 0; i < (a.length - 1); i++){
			temp = a[i];
			tempCount = 0;
			
			for (int j = 1; j < a.length; j++){
				if (temp == a[j]){
					tempCount++;
				}
			}
	    
			if (tempCount > count){
				popular = temp;
				count = tempCount;
			}
		}
		
		return popular;
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
	
	public static int[] reverse(int[] array){
		int[] reversedArray = new int[array.length];
		int k = 0;
		
		for(int i = array.length -1; i >= 0; i--){
			reversedArray[i] = array[k];
			k++;
		}
		
		for(int i = 0; i < array.length; i++){
			array[i] = reversedArray[i];
		}
		
		return array;
	}
	
	public static double[] reverse(double[] array){
		double[] reversedArray = new double[array.length];
		int k = 0;
		
		for(int i = array.length -1; i >= 0; i--){
			reversedArray[i] = array[k];
			k++;
		}
		
		for(int i = 0; i < array.length; i++){
			array[i] = reversedArray[i];
		}
		
		return array;
	}
	
	public static long[] reverse(long[] array){
		long[] reversedArray = new long[array.length];
		int k = 0;
		
		for(int i = array.length -1; i >= 0; i--){
			reversedArray[i] = array[k];
			k++;
		}
		
		for(int i = 0; i < array.length; i++){
			array[i] = reversedArray[i];
		}
		
		return array;
	}
	
	public static int range(int[] array){
		return (ArraySupporter.maxValue(array) - ArraySupporter.minValue(array));
	}
	
	public static double range(double[] array){
		return (ArraySupporter.maxValue(array) - ArraySupporter.minValue(array));
	}
	
	public static long range(long[] array){
		return (ArraySupporter.maxValue(array) - ArraySupporter.minValue(array));
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
	
	public static double sum(double[] array){
		double sum = 0;
		
		for(double key: array){
			sum += key;
		}
		
		return sum;
	}
	
	public static int sum(int[] array){
		int sum = 0;
		
		for(int key: array){
			sum += key;
		}
		
		return sum;
	}
	
	public static double sum(long[] array){
		double sum = 0;
		
		for(double key: array){
			sum += key;
		}
		
		return sum;
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
	
	public static int[] sortDesc(int[] array){
		ArraySupporter.sort(array); //Detta fungerar då du skickar referens och inte kopia
		ArraySupporter.reverse(array); //Jag har redan skrivit en reverse funktion
		
		return array;
	}
	
	public static double[] sortDesc(double[] array){
		ArraySupporter.sort(array); //Detta fungerar då du skickar referens och inte kopia
		ArraySupporter.reverse(array); //Jag har redan skrivit en reverse funktion
		
		return array;
	}
	
	public static long[] sortDesc(long[] array){
		ArraySupporter.sort(array); //Detta fungerar då du skickar referens och inte kopia
		ArraySupporter.reverse(array); //Jag har redan skrivit en reverse funktion
		
		return array;
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

	public static String toString(String[] array){
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
}











