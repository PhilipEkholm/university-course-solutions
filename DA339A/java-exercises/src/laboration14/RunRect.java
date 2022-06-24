package laboration14;

import java.awt.Color;

import paintwindow.PaintWindow;

public class RunRect {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle( 100, 50, 200, 150, Color.BLACK ); 
		Rectangle rect2 = new Rectangle( 80, 150, 100, 150, Color.RED); 
		PaintWindow window = new PaintWindow();
		
		window.setSize(600, 400);
		window.setTitle("Uppgift 4a");
		window.setBackground(Color.WHITE);
		rect1.paint( window ); rect2.paint( window );
	}
}
