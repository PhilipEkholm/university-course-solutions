package ws5;

public class Uppg3Avg {
	public static void main(String[] args) {
		int[][] A = {
			{3, 5, 1},
			{2, 1, 5},
			{4, 14, 2}
		};
		int[][] B = {
			{2, 7, 1},
			{2, 0, 8},
			{1, 3, 2}
		};
		double[][] C = new double[B.length][B[0].length];
		
		double sum = 0;
		
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				sum = A[i][j] + B[i][j];
				C[i][j] = sum / 2;
			}
		}
		
		System.out.println(ArraySupporter.toString(C[0]));
		System.out.println(ArraySupporter.toString(C[1]));
		System.out.println(ArraySupporter.toString(C[2]));
	}
}
