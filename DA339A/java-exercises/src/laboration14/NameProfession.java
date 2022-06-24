package laboration14; 
import java.awt.*; 
import javax.swing.*;  

public class NameProfession extends JPanel {     
	private static final long serialVersionUID = 1L;
	private JLabel 	labelName = new JLabel("Namn: "),
					labelProfession = new JLabel("Yrke: ");
	private JTextField 	field1,
						field2;
	private JPanel 	panelWest = new JPanel(new GridLayout(2, 1)),
					panelCenter = new JPanel(new GridLayout(2, 1));
	
	public NameProfession() {
		this.setLayout(new BorderLayout());
		this.setDimensions();
		this.setFonts();
		this.addComponents();
	}      
	
	// metoder som anropas från konstruktorn – vid behov
	// get-metoder     
	
	public String getName() {
		return this.field1.getText();
	}      
	
	public String getProfession() {
		return this.field2.getText();
	} 
	
	private void setDimensions(){
		labelName.setPreferredSize(new Dimension(40, 20));
		labelProfession.setPreferredSize(new Dimension(40, 20));
	}
	
	private void setFonts(){
		Font stdFont = new Font("Arial", Font.PLAIN, 16);
		labelName.setFont(stdFont);
		labelProfession.setFont(stdFont);
	}
	
	private void addComponents(){
		panelWest.add(labelName);
		panelWest.add(labelProfession);
		panelCenter.add(field1);
		panelCenter.add(field2);
		
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelWest, BorderLayout.WEST);
	}
}



































