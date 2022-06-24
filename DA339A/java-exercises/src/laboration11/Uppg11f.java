package laboration11;

import javax.swing.JOptionPane;

public class Uppg11f {
	public static void main(String[] args) {
		int[] integers = new int[10];
		
		for(int i = 0; i < integers.length; i++) {
			integers[i] = Integer.parseInt(JOptionPane.showInputDialog("Mata in heltal"));
		}
		
		System.out.println("Heltalen inmtade: " + ArraySupporter.toString(integers));
		System.out.print("Vartannat tal: ");
		
		for(int i = 0; i < integers.length; i += 2){
			System.out.print(integers[i] + " ");
		}
		
		integers = ArraySupporter.reverse(integers);
		System.out.println();
		System.out.println(ArraySupporter.toString(integers));
	}
}
