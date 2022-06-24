package laboration2;
import javax.swing.*;

public class PP4 {
	public static void main(String[] args){
		int temp = Integer.parseInt(JOptionPane.showInputDialog("Ener the temperature in Fahrenheit"));
		
		System.out.println("Temperature in Celsius: " + ((temp - 32)/1.8) + "degrees Celsius");
	}
}
