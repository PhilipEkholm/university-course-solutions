package laboration5;

import gu1.PaintWindow_GU1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public class Exercise5f {
	
	public void putIcons() {
        ImageIcon man = new ImageIcon("images/Gubbe.jpg");
        PaintWindow_GU1.addIcon("Gubbe", man, 350, 250, true);
        PaintWindow_GU1.addIcon("btnLeft", new ImageIcon("images/left.png"), 20, 580, true);
        PaintWindow_GU1.addIcon("btnRight", new ImageIcon("images/right.png"), 420, 580, true);
        PaintWindow_GU1.addIcon("btnUp", new ImageIcon("images/up.png"), 20, 680, true);
        PaintWindow_GU1.addIcon("btnDown", new ImageIcon("images/down.png"), 420, 680, true);        
	}
	
	public void setActions() {
		Exercise5f classWithMethod = new Exercise5f();
		
		// Metoden leftRight, i objektet som classWithMethod refererar till, kopplas till "btnRight"-ikonen
        PaintWindow_GU1.setIconAction("btnRight", classWithMethod, "leftRight"); // koppla klick på bild till metod
        PaintWindow_GU1.setIconAction("btnLeft", classWithMethod, "rightLeft");
        PaintWindow_GU1.setIconAction("btnUp", classWithMethod, "upDown");
        PaintWindow_GU1.setIconAction("btnDown", classWithMethod, "downUp");
        
        PaintWindow_GU1.putBoolean("icon_moving", false);
}
    
	public void leftRight() {
		if(PaintWindow_GU1.getBoolean("icon_moving", false) == false){
			PaintWindow_GU1.putBoolean("icon_moving", true); 
			
			int x = PaintWindow_GU1.getIconX("Gubbe");
			int y = PaintWindow_GU1.getIconY("Gubbe");
			for(int i=1; i<=100; i++) {
				PaintWindow_GU1.setIconXY("Gubbe", x+i, y);
				PaintWindow_GU1.pause(20);
			}
		}
		
		PaintWindow_GU1.putBoolean("icon_moving", false); 
	}
    
	public void rightLeft() {
		if(PaintWindow_GU1.getBoolean("icon_moving", false) == false){
			PaintWindow_GU1.putBoolean("icon_moving", true); 
			
			int x = PaintWindow_GU1.getIconX("Gubbe");
			int y = PaintWindow_GU1.getIconY("Gubbe");
			for(int i=1; i<=100; i++) {
				PaintWindow_GU1.setIconXY("Gubbe", x-i, y);
				PaintWindow_GU1.pause(20);
			}
		}
		
		PaintWindow_GU1.putBoolean("icon_moving", false); 
	}
        
	public void upDown() {
		if(PaintWindow_GU1.getBoolean("icon_moving", false) == false){
			PaintWindow_GU1.putBoolean("icon_moving", true); 
			
			int x = PaintWindow_GU1.getIconX("Gubbe");
			int y = PaintWindow_GU1.getIconY("Gubbe");
			for(int i=1; i<=100; i++) {
				PaintWindow_GU1.setIconXY("Gubbe", x, y-i);
				PaintWindow_GU1.pause(20);
			}
		}
		
		PaintWindow_GU1.putBoolean("icon_moving", false); 
	}

	public void downUp() {
		if(PaintWindow_GU1.getBoolean("icon_moving", false) == false){
			PaintWindow_GU1.putBoolean("icon_moving", true); 
			
			int x = PaintWindow_GU1.getIconX("Gubbe");
			int y = PaintWindow_GU1.getIconY("Gubbe");
			for(int i=1; i<=100; i++) {
				PaintWindow_GU1.setIconXY("Gubbe", x, y+i);
				PaintWindow_GU1.pause(20);
			}
		}
		
		PaintWindow_GU1.putBoolean("icon_moving", false); 
	}
    
    public static void main(String[] args) {
        Exercise5f e5f = new Exercise5f();
        PaintWindow_GU1.showWindow(800, 800, "Exercise5f", Color.WHITE);
        e5f.putIcons();
        e5f.setActions();
    }
}
