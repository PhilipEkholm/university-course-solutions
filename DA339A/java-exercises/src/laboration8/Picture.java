package laboration8;
import javax.swing.ImageIcon;

public class Picture {
	private ImageIcon icon;
	private int x,
				y,
				dx,
				dy;
	
	public Picture(ImageIcon icon, int x, int y){
		this.icon = icon;
		this.x = x;
		this.y = y;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public void move(){
		this.x += this.dx;
		this.y += this.dy;
	}
	
	public boolean containsX(int minX, int maxX){
		if(this.x >= minX && this.x <= maxX){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean containsY(int minY, int maxY){
		if(this.y >= minY && this.y <= maxY){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void changeXDirection(){
		this.dx = -this.dx;
	}
	
	public void changeYDirection(){
		this.dy = -this.dy;
	}
}


















