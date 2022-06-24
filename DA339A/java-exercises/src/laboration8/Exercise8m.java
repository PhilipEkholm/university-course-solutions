package laboration8;

import gu2.PaintWindow_GU2;
import javax.swing.ImageIcon;

public class Exercise8m {
	private PaintWindow_GU2 window;
	private Picture man1, man2;
	private int minX, maxX, minY, maxY;
	
    public void action1() {
        ImageIcon image1 = new ImageIcon("images/sommar.jpg");
        ImageIcon image2 = new ImageIcon("images/liggande_gubbe.jpg");
        ImageIcon image3 = new ImageIcon("images/gubbe.jpg");

        window = new PaintWindow_GU2(800,600,"Uppgift 7m",image1,0,0);
        
        int width = window.getCameraWidth();
        int height = window.getCameraHeight();
        
        man1 = new Picture(image2,0,(height-image2.getIconHeight())/2);
        man2 = new Picture(image3,(width-image3.getIconWidth())/2, height-image3.getIconHeight());
        addPicture(man1);
        addPicture(man2);

        minX = window.getCameraX();
        maxX = minX+width-man1.getIcon().getIconWidth(); // Antagande: kvadratiska bilder, samma storlek
        minY = window.getCameraY();
        maxY = minY+height-man1.getIcon().getIconHeight(); // Antagande: se ovan
        move();
    }
    
    public void move() {
    	man1.setDx(3);
    	man1.setDy(-1);
    	man2.setDx(2);
    	man2.setDy(-3);
    	while(true) {
    		move(man1);
    		move(man2);
    		PaintWindow_GU2.pause(20);
    	}
    }
    
    private void move(Picture picture) {
        picture.move();
		movePicture(picture);
        if(picture.containsX(minX, maxX)==false) {
        	picture.changeXDirection();
        }
        if(!picture.containsY(minY, maxY)) {
        	picture.changeYDirection();
        }
    }
    
    public void addPicture(Picture picture) {
    	window.addIcon(picture.getIcon(), picture.getX(), picture.getY(), true);
    }
    
    public void movePicture(Picture picture) {
    	window.setIconXY(picture.getIcon(), picture.getX(), picture.getY());
    }

    public static void main(String[] args) {
        Exercise8m u8m = new Exercise8m();
        u8m.action1();
    }
}
