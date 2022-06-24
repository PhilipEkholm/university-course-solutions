package laboration10;
import java.awt.*;

public class ColorController {
	private ColorView viewer;
	
	public ColorController(ColorView view){
		this.viewer = view;
	}
	
	public void setColor(Color color){
		viewer.setColor(color);
	}
}
