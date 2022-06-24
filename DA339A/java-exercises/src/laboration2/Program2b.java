package laboration2;

import javax.swing.JOptionPane;

public class Program2b {
    public void info() {
    	String name = JOptionPane.showInputDialog("Ange ditt namn");
    	int numberOfPrograms = Integer.parseInt(JOptionPane.showInputDialog("Hur många Java-program har du skrivit?"));
    	
        System.out.println("Hej, mitt namn är " + name + ".");
        System.out.println("Jag har skrivit " + numberOfPrograms + " program i Java.");
        System.out.println("Det ör KUL med Java!!!");
    }

    public static void main( String[] args ) {
        Program2b p2 = new Program2b();
        p2.info();
    }
}