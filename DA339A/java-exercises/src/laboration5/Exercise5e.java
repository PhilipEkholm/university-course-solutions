package laboration5;
import java.awt.Color;

import paintwindow.PaintWindow;

import javax.swing.ImageIcon;
/**
 * Flytta bild i ett PaintWindow_GU1-fönster
 * @author tsroax
 */
public class Exercise5e {
    
    public void leftRight() {
        int x = PaintWindow.getIconX("Gubbe");
        int y = PaintWindow.getIconY("Gubbe");
        int width = PaintWindow.getCameraWidth();
        int iconWidth = PaintWindow.getIconWidth("Gubbe");
        int maxX = width - iconWidth;
        
        while(x<maxX) {
        	x += 7;
        	PaintWindow.setIconXY("Gubbe", x, y);
            PaintWindow.pause(20);
        }
    }
    
    public void rightLeft() {
    	int x = PaintWindow.getIconX("Gubbe");
        int y = PaintWindow.getIconY("Gubbe");
        
        while(x>0){
        	x -= 7;
        	PaintWindow_GU1.setIconXY("Gubbe", x, y);
        	PaintWindow_GU1.pause(20);
        }
    }
        
    public void upDown() {
    	int x = PaintWindow.getIconX("Gubbe");
        int y = PaintWindow.getIconY("Gubbe");
        int width = PaintWindow.getCameraWidth();
        int height = PaintWindow.getCameraHeight();
        int iconWidth = PaintWindow.getIconWidth("Gubbe");
        int maxY = height - PaintWindow.getIconHeight("Gubbe");
        
        while(y > 0){
        	y -= 7;
        	PaintWindow.setIconXY("Gubbe", x, y);
        	PaintWindow.pause(20);
        }
        
        while(y <= maxY){
        	y += 7;
        	PaintWindow.setIconXY("Gubbe", x, y);
        	PaintWindow.pause(20);
        }
    }
        
    public void downUp() {
    	int x = PaintWindow.getIconX("Gubbe");
        int y = PaintWindow.getIconY("Gubbe");
        int width = PaintWindow.getCameraWidth();
        int height = PaintWindow.getCameraHeight();
        int iconWidth = PaintWindow.getIconWidth("Gubbe");
        int maxY = height - PaintWindow.getIconHeight("Gubbe");
        
        while(y > 0){
        	y -= 7;
        	PaintWindow_GU1.setIconXY("Gubbe", x, y);
        	PaintWindow_GU1.pause(20);
        }
    }
    
    public static void main(String[] args) {
        Exercise5e e5e = new Exercise5e();
        PaintWindow.showWindow(600, 400, "Exercise5e", Color.WHITE);
        ImageIcon man = new ImageIcon("images/Gubbe.jpg");
        
        PaintWindow.addIcon("Gubbe", man, 0, 150, true);
        e5e.leftRight();
        
//      PaintWindow_GU1.addIcon("Gubbe", man, 500, 150, true);
        e5e.rightLeft();
        
//      PaintWindow_GU1.addIcon("Gubbe", man, 250, 0, true);
        e5e.upDown();
        
//      PaintWindow_GU1.addIcon("Gubbe", man, 250, 300, true);
        e5e.downUp();
        
    }
}
