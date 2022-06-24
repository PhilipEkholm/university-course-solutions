package laboration6;

import javax.swing.*;

public class PackageTest {

	public static void main( String[] args ) {
		Package pac = new Package();
		int width;

		pac.setLength( 130 );
		width = Integer.parseInt( JOptionPane.showInputDialog( "Ange paketets bredd") );
		pac.setWidth( width );
		pac.setDepth( 22 );
		pac.setWeight( 1.3 );

		System.out.println( "PAKET: " + pac.getLength() + " x " + pac.getWidth() + " x " + pac.getDepth() + ", vikt = " + pac.getWeight() + " kg");
	}
}