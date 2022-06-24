package laboration10; 
import java.awt.*; 
import javax.swing.*;  
// LabelPanel 

public class ColorView extends JPanel {     
	private static final long serialVersionUID = 1L;
	private JLabel lblColor = new JLabel();
	
	public ColorView() {
		this.setPreferredSize(new Dimension(300,200));
		lblColor.setBackground(new Color(255, 0, 0));
		this.setLayout(new BorderLayout());
		lblColor.setOpaque(true);
		this.add(lblColor, BorderLayout.CENTER);
	}
	
	public void setColor(Color color) {         
		lblColor.setBackground(color);
		System.out.println(color);
	} 
}