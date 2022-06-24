package laboration10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Random;

public class ColorChooser extends JPanel{
	private static final long serialVersionUID = 1L;
	private ColorController controller;
	private JLabel colorLabel = new JLabel("Välj färg");
	private Font standardFont = new Font("Arial", Font.PLAIN, 14);
	private JRadioButton rbRed = new JRadioButton("Röd"),
						rbGreen = new JRadioButton("Grön"),
						rbBlue = new JRadioButton("Blå"),
						rbRandom = new JRadioButton("Slumpmässig");

	public ColorChooser(ColorController controller){
		this.controller = controller;
		this.setLayout(new GridLayout(5, 1));
		this.setBackground(Color.RED);
		this.setButtonGroup();
		
		this.setDimensions();
		this.setFonts();
		this.addListeners();
		this.addComponents();
	}
	
	private void setButtonGroup(){
		ButtonGroup group = new ButtonGroup();
		group.add(rbRed);
		group.add(rbGreen);
		group.add(rbBlue);
		group.add(rbRandom);
		rbRed.setSelected(true);
	}
	
	private void setDimensions(){
		colorLabel.setPreferredSize(new Dimension(170, 30));
		rbRed.setPreferredSize(new Dimension(170, 20));
		rbGreen.setPreferredSize(new Dimension(170, 20));
		rbBlue.setPreferredSize(new Dimension(170, 20));
		rbRandom.setPreferredSize(new Dimension(170, 20));
	}
	
	private void setFonts(){
		colorLabel.setFont(standardFont);
	}
	
	private void addListeners(){
		ColorListener listener = new ColorListener();
		rbRed.addActionListener(listener);
		rbBlue.addActionListener(listener);
		rbGreen.addActionListener(listener);
		rbRandom.addActionListener(listener);
	}
	
	private void addComponents(){
		this.add(colorLabel);
		this.add(rbRed);
		this.add(rbGreen);
		this.add(rbBlue);
		this.add(rbRandom);
	}
	
	public class ColorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(rbRed.isSelected() == true){
				controller.setColor(new Color(255, 0 , 0));
			}
			else if(rbGreen.isSelected() == true){
				controller.setColor(new Color(0, 255, 0));
			}
			else if(rbBlue.isSelected() == true){
				controller.setColor(new Color(0, 0, 255));
			}
			else if(rbRandom.isSelected() == true){
				Random rand = new Random();
				Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				controller.setColor(color);
			}
		}
	}
}


















