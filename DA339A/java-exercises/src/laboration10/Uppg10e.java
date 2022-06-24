package laboration10;
import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

public class Uppg10e extends JPanel{
	private JLabel labelTopic = new JLabel("Rubrikrad"),
				   labelRPGH = new JLabel("Ange RPGH"),
				   labelProgramStatus = new JLabel("Programmets status");
	private JButton btnPink = new JButton("Rosa Knapp"),
					btnGray = new JButton("Grå Knapp"),
					btnCyan = new JButton("Cyan Knapp"),
					btn1 = new JButton("Knapp 1"),
					btn2 = new JButton("Knapp 2");
	private JTextField fieldInput = new JTextField();
	private JTextArea textarea = new JTextArea();
	private JPanel northButtonPanel = new JPanel(new GridLayout(1, 2)), 
				   northPanel = new JPanel(new GridLayout(2, 1)), 
				   textFieldPanel = new JPanel(new BorderLayout()), 
				   westPanel = new JPanel(new GridLayout(3, 1)), 
				   centerPanel = new JPanel(new BorderLayout());
	
	public Uppg10e(){
		this.setPreferredSize(new Dimension(800, 400));
		this.setLayout(new BorderLayout());
		
		northButtonPanel.add(btn1);
		northButtonPanel.add(btn2);
		northPanel.add(labelTopic);
		northPanel.add(northButtonPanel);
		textFieldPanel.add(labelRPGH, BorderLayout.WEST);
		textFieldPanel.add(fieldInput, BorderLayout.CENTER);
		
		btnPink.setBackground(Color.PINK);
		btnPink.setPreferredSize(new Dimension(50, 100));
		btnGray.setBackground(Color.GRAY);
		btnGray.setPreferredSize(new Dimension(50, 100));
		btnCyan.setBackground(Color.BLUE);
		btnCyan.setPreferredSize(new Dimension(50, 100));
		
		westPanel.add(btnPink);
		westPanel.add(btnGray);
		westPanel.add(btnCyan);
		
		centerPanel.add(northPanel, BorderLayout.NORTH);
		centerPanel.add(textarea, BorderLayout.CENTER);
		centerPanel.add(textFieldPanel, BorderLayout.SOUTH);
		
		this.add(westPanel, BorderLayout.WEST);
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Uppg10e());
		
		frame.pack();
		frame.setVisible(true);
	}
}
