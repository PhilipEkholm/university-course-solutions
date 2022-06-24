package ws5;

public class Uppg4RedData {
	public static void main(String[] args) {
		int[] machine = {
			52, 49, 49, 50, 0, 0, 0, 13, 0, 42,
		},
				newArray;
		
		int count = 0;
		
		for(int i = 0; i < machine.length; i++){
			if(machine[i] != 0){
				count++;
			}
		}
		
		newArray = new int[count];
		
		count = 0;
		for(int i = 0; i < machine.length; i++){
			if(machine[i] != 0){
				newArray[count] = machine[i];
				count++;
			}
		}
		
		System.out.println(ArraySupporter.toString(newArray));
	}
}
