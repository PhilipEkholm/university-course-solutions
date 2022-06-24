package laboration9;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class TransportPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel questionLabel = new JLabel("Hur tar du dig till MAH?"),
				   finalLabel = new JLabel("Du använder: ");
	private JCheckBox carBox = new JCheckBox("Bil"),
					  trainBox = new JCheckBox("Tåg"),
					  busBox = new JCheckBox("Buss"),
					  bikeBox = new JCheckBox("Cykel"),
					  walkBox = new JCheckBox("Går");
	private Font stdFont = new Font("Arial", Font.PLAIN, 14);
	
	public TransportPanel(){
		this.setBackground(Color.CYAN);
		
		this.setDimensions();
		this.setFonts();
		this.addListeners();
		this.addComponents();
	}
	
	private void setDimensions(){
		this.setPreferredSize(new Dimension(300, 100));
		questionLabel.setPreferredSize(new Dimension(300, 20));
		carBox.setPreferredSize(new Dimension(50, 20));
		trainBox.setPreferredSize(new Dimension(50, 20));
		busBox.setPreferredSize(new Dimension(60, 20));
		bikeBox.setPreferredSize(new Dimension(60, 20));
		walkBox.setPreferredSize(new Dimension(50, 20));
		finalLabel.setPreferredSize(new Dimension(300, 20));
	}
	
	private void setFonts(){
		questionLabel.setFont(stdFont);
		finalLabel.setFont(stdFont);
	}
	
	private void addListeners(){
		TransportListener listener = new TransportListener();
		carBox.addItemListener(listener);
		trainBox.addItemListener(listener);
		busBox.addItemListener(listener);
		bikeBox.addItemListener(listener);
		walkBox.addItemListener(listener);
	}
	
	private void addComponents(){
		this.add(questionLabel);
		
		this.add(carBox);
		this.add(trainBox);
		this.add(busBox);
		this.add(bikeBox);
		this.add(walkBox);
		this.add(finalLabel);
	}
	
	class TransportListener implements ItemListener{

		String res = "Du använder: ";
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == carBox){
				if(carBox.isSelected()){
					res += "bil ";
				}
			}
			else if(e.getSource() == trainBox){
				if(trainBox.isSelected()){
					res += "tåg ";
				}
			}
			else if(e.getSource() == busBox){
				if(busBox.isSelected()){
					res += "buss ";
				}
			}
			else if(e.getSource() == bikeBox){
				if(bikeBox.isSelected()){
					res += "cykel ";
				}
			}
			else if(e.getSource() == walkBox){
				if(walkBox.isSelected()){
					res += "går ";
				}
			}
			
			finalLabel.setText(res);
		}
	}
}













