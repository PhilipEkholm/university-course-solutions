package laboration2;

import javax.swing.*;

public class PP2 {
	public float getAverage(int arg1, int arg2, int arg3){
		return (arg1 + arg2 + arg3) / 3;
	}
	
	public static void main(String[] args){
		PP2 prg = new PP2();
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ange första tal"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ange andra tal"));
		int num3 = Integer.parseInt(JOptionPane.showInputDialog("Ange tredje tal"));
		
		System.out.println(prg.getAverage(num1, num2, num3));
	}
}
