package laboration2;
import javax.swing.*;

public class Program2i {
	public static void main(String[] args){
		String name = JOptionPane.showInputDialog("Ange ditt namn");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Ange din ålder"));
		int year = Integer.parseInt(JOptionPane.showInputDialog("Ange år"));
		
		System.out.println(name + ", år " + ((year - age) + 100) + " fyller du 100 år");
	}
}
