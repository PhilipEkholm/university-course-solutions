package laboration9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TemperatureUnitConverterPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel degreesLabel = new JLabel("Grader: "),
				   resultLabel = new JLabel("Resultat: ");
	private JTextField inputField = new JTextField();
	private JButton btnConvertFC = new JButton("Till Celsius"),
					btnConvertCF = new JButton("Till Fahrenheit"),
					btnFinish = new JButton("Avsluta");
	private Font standardFont = new Font("Arial", Font.PLAIN, 14),
				buttonFont = new Font("Arial", Font.PLAIN, 12);
	

	public TemperatureUnitConverterPanel(){
		this.setPreferredSize(new Dimension(200, 150));
		this.setDimensions();
		this.setFonts();
		this.addListeners();
		this.addComponents();
		this.setBackground(Color.WHITE);
	}
	
	private void setDimensions(){
		degreesLabel.setPreferredSize(new Dimension(60, 20));
		inputField.setPreferredSize(new Dimension(140, 20));
		resultLabel.setPreferredSize(new Dimension(200, 20));
		btnConvertFC.setPreferredSize(new Dimension(150, 20));
		btnConvertCF.setPreferredSize(new Dimension(50, 20));
		
		btnFinish.setPreferredSize(new Dimension(200, 20));
	}
	
	private void setFonts(){
		degreesLabel.setFont(standardFont);
		resultLabel.setFont(standardFont);
		btnConvertFC.setFont(buttonFont);
		btnConvertCF.setFont(buttonFont);
		btnFinish.setFont(buttonFont);
	}
	
	private void addListeners(){
		btnConvertFC.addActionListener(this);
		btnConvertCF.addActionListener(this);
		btnFinish.addActionListener(this);
	}
	
	private void addComponents(){
		this.add(degreesLabel);
		this.add(inputField);
		this.add(resultLabel);
		this.add(btnConvertFC);
		this.add(btnConvertCF);
		this.add(btnFinish);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnFinish){
			System.exit(0);
		}
		else if(e.getSource() == btnConvertFC){
			double C = (Double.parseDouble(inputField.getText()) - 32) / 1.8;
			String result = String.format("3 decimaler: %1.3f", C) + " grader C";
			resultLabel.setText(result);
		}
		else if(e.getSource() == btnConvertCF){
			double F = 32 + (1.8 * Double.parseDouble(inputField.getText()));
			String result = String.format("Fahrenheit: %1.3f", F) + " grader F";
			resultLabel.setText(result);
			
		}
	}
}

















