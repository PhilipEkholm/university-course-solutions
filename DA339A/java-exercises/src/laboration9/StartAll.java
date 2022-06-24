package laboration9;
import javax.swing.JFrame;

public class StartAll {
	public static void main(String[] args) {
		JFrame window = new JFrame("Alla i en");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new AllPanels());
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
	}
}
