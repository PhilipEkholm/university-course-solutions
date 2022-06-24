package laboration14;

import java.awt.Color;

import paintwindow.PaintWindow;

public class RunNSides {
	public static void main(String[] args) {
		Point[] p = { 
			new Point(0, 40), 
			new Point(30, 30), 
			new Point(40, 0),
			new Point(50, 30), 
			new Point(80, 40), 
			new Point(50, 50),               
			new Point(40, 80), 
			new Point(30, 50) 
		}; 
		
		NSides star1 = new NSides(50, 100, p, Color.RED); 
		NSides star2 = new NSides(100, 150, p, Color.GREEN); 
		NSides star3 = new NSides(175, 125, p, Color.BLUE); 
		
		PaintWindow window = new PaintWindow();
		window.setSize(600, 400);
		window.setTitle("Uppgift 4b");
		window.setBackground(Color.WHITE);
		
		star1.paint(window); 
		star2.paint(window);
		star3.paint(window);
	}
}
