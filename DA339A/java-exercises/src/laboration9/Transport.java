package laboration9;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Transport {
	public static void main(String[] args) {
		TransportPanel panel = new TransportPanel();
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JOptionPane.showMessageDialog(null, panel);
	}
}
