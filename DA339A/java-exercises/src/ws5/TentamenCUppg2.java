package ws5;

//Lösning på Uppg 2 i Tentamen C 10-12-16

public class TentamenCUppg2 {
	public static void main(String[] args) {
		boolean[][] cells = { //Samma som i tentamensexemplaret
			{false, true, true, false},
			{false, false, false, true},
			{false, true, true, true},
			{true, false, false, true}
		};
		
		boolean[][] newCells = TentamenCUppg2.createNewCells(cells);
		
		System.out.println(TentamenCUppg2.printMatrix(cells));
		System.out.println("-----------------------------");
		System.out.println(TentamenCUppg2.printMatrix(newCells));
	}
	
	public static boolean[][] createNewCells(boolean[][] array){
		boolean[][] newArray = new boolean[array.length][array[0].length];
		int boundaryX = newArray[0].length - 1, //Ena gränsen
			boundaryY = newArray.length - 1; //Andra gränsen
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				int count = 0;
				boolean setter = false;
				
				if(i != 0){
					if(array[i-1][j]){ //Kolla ovanför
						count++;
					}
					
					if(j != 0){
						if(array[i-1][j-1]){ //Kolla uppe till vänster
							count++;
						}
					}
					if(j != boundaryX){
						if(array[i-1][j+1]){ //Kolla uppe till höger
							count++;
						}
					}
				}
				
				if(j != 0){
					if(array[i][j-1]){ //Kolla till vänster
						count++;
					}
				}
				
				if(j != boundaryX){ //Kolla till höger
					if(array[i][j+1]){
						count++;
					}
				}
				
				if(i != boundaryY){ 
					if(array[i+1][j]){ //Kolla nedanför
						count++;
					}
					
					if(j != 0){ //Kolla nere till vänster
						if(array[i+1][j-1]){
							count++;
						}
					}
					
					if(j != boundaryX){ //Kolla nere till höger
						if(array[i+1][j+1]){
							count++;
						}
					}
				}
				
				if(count == 6){ //Kolla regel #1
					setter = true;
				}
				else if(count == 1 && array[i][j]){ //Kolla annars regel #2
					setter = true;
				}
				
				newArray[i][j] = setter;
			}
		}
		
		return newArray;
	}
	
	//Skriver ut arrayen i matrisform
	public static String printMatrix(boolean[][] array){
		String matrix = "[";
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				if(array[i][j]){
					matrix += "T";
				}
				else if(!array[i][j]){
					matrix += "F";
				}
				
				if(j != array[i].length - 1){
					matrix += ", ";
				}
			}
			
			if(i != array.length - 1){
				matrix += "\n";
			}
			
		}
		
		return (matrix += "]");
	}
}
