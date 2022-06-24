package laboration10;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SurveyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblName = new JLabel("Namn: ");
	private JTextField tfName = new JTextField();
	private JRadioButton rb0To17 = new JRadioButton("0 - 17"), 
						 rb18To64 = new JRadioButton("18 - 64"), 
						 rb65 = new JRadioButton(" 65 -");
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbSport = new JCheckBox("Idrott"), 
					  cbDance = new JCheckBox("Folkdans"), 
					  cbBirds = new JCheckBox("Fågelskådning"), 
					  cbBridge = new JCheckBox("Bridge"), 
					  cbSong = new JCheckBox("Körsång");
	
	private JButton btnSummary = new JButton("Sammanfattning");
	private JTextArea taSummary = new JTextArea();
	private JPanel pnlNorth = new JPanel(new BorderLayout()),
				   pnlNorthNorth = new JPanel(new BorderLayout()),
				   pnlNorthCenter = new JPanel(new GridLayout(1, 2)),
				   pnlAge = new JPanel(new GridLayout(5, 1)),
				   pnlHobby = new JPanel(new GridLayout(5, 1));
	
	public SurveyPanel(){
		this.setPreferredSize(new Dimension(300, 600));
		this.setLayout(new BorderLayout());
		this.setBorders();
		this.addListeners();
		this.addComponents();
		this.addButtonGroups();
		this.addToSubpanels();
	}
	
	private void setBorders(){
		pnlAge.setBorder(BorderFactory.createTitledBorder("Ålder"));
		pnlHobby.setBorder(BorderFactory.createTitledBorder("Hobby"));
	}
	
	private void addToSubpanels(){
		pnlNorthNorth.add(lblName, BorderLayout.WEST);
		pnlNorthNorth.add(tfName, BorderLayout.CENTER);
		pnlNorthCenter.add(pnlAge);
		pnlNorthCenter.add(pnlHobby);
		
		pnlAge.add(rb0To17);
		pnlAge.add(rb18To64);
		pnlAge.add(rb65);
		
		pnlNorth.add(pnlNorthNorth, BorderLayout.NORTH);
		pnlNorth.add(pnlNorthCenter, BorderLayout.CENTER);
		pnlNorth.add(btnSummary, BorderLayout.SOUTH);
		
		pnlHobby.add(cbSport);
		pnlHobby.add(cbDance);
		pnlHobby.add(cbBirds);
		pnlHobby.add(cbBridge);
		pnlHobby.add(cbSong);
	}
	
	private void addListeners(){
		btnSummary.addActionListener(new SummaryListener());
	}
	
	private class SummaryListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			this.summary();
		}

		private void summary() {
			String res = tfName.getText() + "\n";
			
			if(rb0To17.isSelected()){
				res += "Ålder: " + "0 - 17 år\n";
			}
			else if(rb18To64.isSelected()){
				res += "Ålder: " + "18 - 64 år\n";
			}
			else if(rb65.isSelected()){
				res += "Ålder: " + "65 - år\n";
			}
			
			res += "Hobby: ";
			
			if(cbSport.isSelected()){
				res += " Idrott";
			}
			if(cbDance.isSelected()){
				res += " Folkdans";
			}
			if(cbBirds.isSelected()){
				res += " Fågelskådning";
			}
			if(cbBridge.isSelected()){
				res += " Bridge";
			}
			if(cbSong.isSelected()){
				res += " Körsång";
			}
			res+= "\n";
			
			//Visa texten
			taSummary.setText(res);
		}
	}
	
	private void addButtonGroups(){
		buttonGroup.add(rb0To17);
		buttonGroup.add(rb18To64);
		buttonGroup.add(rb65);
		
		rb0To17.setSelected(true);
	}
	
	private void addComponents(){
		this.add(taSummary, BorderLayout.CENTER);
		this.add(pnlNorth, BorderLayout.NORTH);
	}
}
