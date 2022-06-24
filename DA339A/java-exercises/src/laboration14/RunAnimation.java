package laboration14;

import java.awt.Color;
import javax.swing.ImageIcon;

import paintwindow.PaintWindow;

public class RunAnimation {
	public static void main(String[] args) {
		PaintWindow window = new PaintWindow();
		window.setSize(800, 600);
		window.setTitle("Uppgift 5");
		window.setBackground(Color.WHITE);
		ImageIcon[] images = new ImageIcon[10]; 
		
		for(int i=0; i<images.length; i++) {     
			images[i] = new ImageIcon("images/lab14/new" + (i+1) + ".jpg"); 
		} 
		
		Animation anim = new Animation(images, 100, 100); 
		
		for(int i=0; i<100; i++) {     
			anim.paint(window);
			PaintWindow.pause(50);
		}
	}
}











