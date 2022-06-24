package laboration10;
import javax.swing.*;

public class Laboration10d {
	private void showFrame(String title, int x, int y, JPanel panel) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setLocation(x, y);
		frame.setVisible(true);
	}
	
	public void action() {         
		ColorView view = new ColorView();
		ColorController controller = new ColorController(view);
		ColorChooser colorPanel = new ColorChooser(controller);
		this.showFrame("Color Viewer", 200, 200, view);
		this.showFrame("Color Chooser", 50, 50, colorPanel);
	}
	
	public static void main(String[] args) {         
		Laboration10d lab10d = new Laboration10d();         
		lab10d.action();
	}
}
