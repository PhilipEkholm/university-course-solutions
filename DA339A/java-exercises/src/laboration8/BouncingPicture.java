package laboration8;

import gu2.PaintWindow_GU2;

public class BouncingPicture {
	private PaintWindow_GU2 window;
	private Picture picture;
	private int minX, maxX, minY, maxY;
	
	public BouncingPicture(PaintWindow_GU2 window, Picture picture, int minX, int maxX, int minY, int maxY){
		this.window = window;
		this.picture = picture;
		
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}
	
	public void setDx(int dx){
		picture.setDx(dx);
	}
	
	public void setDy(int dy){
		picture.setDy(dy);
	}
	
	public void addPicture(){
		window.addIcon(picture.getIcon(), picture.getX(), picture.getY(), true);
	}
	
	private void showPicture() {
		window.setIconXY(picture.getIcon(), picture.getX(), picture.getY());
	}
	
	public void move(){
		picture.move();
			showPicture();
		if(!picture.containsX(minX, maxX - picture.getIcon().getIconWidth())) {
			picture.changeXDirection();
		}
		if(!picture.containsY(minY, maxY - picture.getIcon().getIconHeight())) {
			picture.changeYDirection();
		}
	}
	
}
