package ws5;

public class TentamenC {
	public int[][] arrayWithNeighbors(boolean[][] array){
		int[][] newArray = new int[array.length][array[0].length];
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				int counter = 0;
				int boundaryX = array[0].length - 1,
					boundaryY = array.length - 1;
				
				if(array[i][j]){
					counter++; //Kolla sig själv
				}
				
				if(i != 0){ //Kolla ovanför
					if(array[i-1][j]){
						counter++;
					}
					if(j != 0){ //Kolla uppe till vänster
						if(array[i-1][j-1]){
							counter++;
						}
					}
				}
				
				if(j != 0){ //Kolla vänster
					if(array[i][j-1]){
						counter++;
					}
					if(i != boundaryY){ //Kolla nere till vänster
						if(array[i+1][j-1]){
							counter++;
						}
					}
				}
				
				if(i != boundaryY){ //Kolla nedanför
					if(array[i+1][j]){
						counter++;
					}
					
					if(j != boundaryX){
						if(array[i+1][j+1]){ //Kolla nere till höger
							counter++;
						}
					}
				}
				
				if(j != boundaryX){ //Kolla till höger
					if(array[i][j+1]){
						counter++;
					}
					
					if(i != 0){ //Kolla uppe till höger
						if(array[i-1][j+1]){
							counter++;
						}
					}
				}
				
				newArray[i][j] = counter;
			}
		}
		
		return newArray;
	}
	
	public static void main(String[] args) {
		boolean[][] array = {
			{true, false, true, true, false},
			{false, false, true, false, true},
			{false, false, true, true, true},
			{true, false, true, true, true},
		};
		
		TentamenC app = new TentamenC();
		
		int[][] checkedArray = app.arrayWithNeighbors(array);
		
		System.out.print("[");
		for(int i = 0; i < checkedArray.length; i++){
			for(int j = 0; j < checkedArray[i].length; j++){
				System.out.print(checkedArray[i][j] + ", ");
			} 
			System.out.println();
		}
		
		System.out.println("]");
	}
}
