package laboration12;
import java.util.*;

import javax.swing.JOptionPane;

public class Uppg12h {
	public static void main(String[] args) {
		int[] elements = new int[10];
		Random rand = new Random();
		Uppg12h app = new Uppg12h();
		
		for(int i = 0; i < elements.length; i++){
			elements[i] = rand.nextInt(101) + 100;
		}
		
		app.printElements(elements);
	}
	
	private void printElements(int[] array){
		String res = "";
		ArraySupporter.reverse(array);
		
		for(int i = 0; i < array.length; i++){
			res += Integer.toString(array[i]) + ", ";
			//Bryt linje var 10:e element
			if(i % 5 == 0){
				res += "\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, res);
	}
}
