package laboration15; 

import java.awt.*; 
import java.awt.geom.*;     // Behövs vid anrop till draw/fill 
import javax.swing.*;      // Behövs om du ska använda bilder 

public class Uppg3 implements Icon {       
	private final int WIDTH = 300, HEIGHT = 250;
	private Font stdFont = new Font("Arial", Font.PLAIN, 14);
	
	public void paintIcon(Component c, Graphics g, int x, int y) {         
		Color background = new Color(74, 204, 247);
		Color fields = new Color(80, 217, 56);
		Color sun = new Color(250, 237, 52);
		g.setColor(background);
		g.fillRect(0, 0, 300, 125);
		g.setColor(fields);
		g.fillRect(0, 125, 300, 125);
		g.setColor(sun);
		g.fillOval(175, 25, 50, 50);
		g.setColor(new Color(52, 92, 250));
		g.fillOval(60, 150, 80, 25);
	}      
	
	public int getIconWidth() {         
		return WIDTH; // Ersätt AAA med bildens bredd       
	}
	
	public int getIconHeight() {         
		return HEIGHT; // Ersätt AAA med bildens höjd     
	}      
	
	public static void main(String[] args)  {         
		IconWindow.showIcon(new Uppg3());     
	} 
}





























