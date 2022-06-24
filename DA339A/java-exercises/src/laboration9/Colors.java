package laboration9;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Colors {
	public static void main(String[] args) {
		ColorPanel panel = new ColorPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JOptionPane.showMessageDialog(null, panel);
	}
}
