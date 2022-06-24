package laboration5;
import gu1.PaintWindow_GU1;

import javax.swing.ImageIcon;

public class ImageController {
    /**
     * Metoden flyttar bilden en bildbredd till vänster. Bilden flyttas aldrig 
     * förbi vänster fönsterkant.
     */
    public void left() {
    	String icon = PaintWindow.getString("ImageController_name", "");
    	int x = PaintWindow.getIconX(icon); // Bildens x-position
    	int y = PaintWindow.getIconY(icon); // Bildens y-position
        int iconWidth = PaintWindow.getIconWidth(icon);  // Bildens bredd
        if (x > iconWidth) {  // om bildens x-koordinat är större än bildens bredd
        	PaintWindow.setIconXY(icon,x-iconWidth,y); // flytta hel bildbredd
        } else {                    // annars
        	PaintWindow.setIconXY(icon, 0, y);       // flytta lika långt som bilden är till höger om fönstrets vänsterkant
        }
    }

    /**
     * Metoden flyttar bilden en bildbredd till höger. Bilden flyttas aldrig 
     * förbi höger kant på bakgrunden.
     */
    public void right() {
    	String icon = PaintWindow.getString("ImageController_name", "");
    	int x = PaintWindow.getIconX(icon);
    	int y = PaintWindow.getIconY(icon);
        int iconWidth = PaintWindow.getIconWidth(icon); 
        int backgroundWidth = PaintWindow.getBackgroundWidth();
        int maxX = backgroundWidth - iconWidth;
        if (x<maxX-iconWidth) { // bildens x-koordinat 
        	PaintWindow.setIconXY(icon,x+iconWidth,y); // flytta hel bildbredd
        } else {
        	PaintWindow.setIconXY(icon,maxX,y); 
        }
    }

    /**
     * Metoden flyttar bilden en bildhöjd uppåt i fönstret. Bilden flyttas
     * aldrig förbi fönstrets övre kant.
     */
    public void up() {
    	String icon = PaintWindow.getString("ImageController_name", "");
    	int x = PaintWindow.getIconX(icon);
    	int y = PaintWindow.getIconY(icon);
        int iconHeight = PaintWindow.getIconHeight(icon);  // Bildens höjd
        if (y > iconHeight) {
        	PaintWindow.setIconXY(icon,x,y-iconHeight); // flytta hel bildhöjd
        } else {
        	PaintWindow.setIconXY(icon,x,0); // flytta del av bildhöjd
        }
    }


    /**
     * Metoden flyttar bilden en bildhöjd nedåt i fönstret. Bilden flyttas
     * aldrig förbi fönstrets nedre kant.
     */
    public void down() {
    	String icon = PaintWindow.getString("ImageController_name", "");
    	int x = PaintWindow.getIconX(icon);
    	int y = PaintWindow.getIconY(icon);
        int iconHeight = PaintWindow.getIconHeight(icon);  // Bildens höjd
        int maxY = PaintWindow.getBackgroundHeight() - iconHeight;  // Största y-värde som bilden kan ha och ändå vara helt synlig
        if (y < maxY-iconHeight) {  // om det går att flytta hel bildhöjd  
        	PaintWindow.setIconXY(icon,x,y+iconHeight); // flytta hel bildhöjd
        } else {                            // annars
        	PaintWindow.setIconXY(icon,x,maxY); // flytta hel bildhöjd
        }
    }

}
