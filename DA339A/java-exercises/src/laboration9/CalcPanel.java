package laboration9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L; //Eclipse bad mig lägga till denna, vet inte varför dock
	private JLabel lblNbr1 = new JLabel("Tal 1"),
				   lblNbr2 = new JLabel("Tal 2"),
				   resultLabel = new JLabel("Resultat");
	private Font basicFont = new Font("SansSerif", Font.PLAIN, 18),
				 buttonFont = new Font("SansSerif", Font.PLAIN, 24);
	private JTextField textField1 = new JTextField(),
					   textField2 = new JTextField();
	private JButton btnAdd = new JButton("+"),
					btnSub = new JButton("-");
	
	public CalcPanel(){
		this.setPreferredSize(new Dimension(250, 140));
		
		this.setDimensions();
		this.setFonts();
		this.addComponents();
		this.addListeners();
	}
	
	private void setDimensions(){
		lblNbr1.setPreferredSize(new Dimension(100, 20));
		lblNbr2.setPreferredSize(new Dimension(100, 50));
		textField1.setPreferredSize(new Dimension(100, 20));
		textField2.setPreferredSize(new Dimension(100, 20));
		btnAdd.setPreferredSize(new Dimension(100, 20));
		btnSub.setPreferredSize(new Dimension(100, 20));
		resultLabel.setPreferredSize(new Dimension(200, 20));
	}
	
	private void setFonts(){
		lblNbr1.setFont(basicFont);
		lblNbr2.setFont(basicFont);
		resultLabel.setFont(basicFont);
		btnAdd.setFont(buttonFont);
		btnSub.setFont(buttonFont);
	}
	
	private void addListeners(){
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
	}
	
	private void addComponents(){
		this.add(lblNbr1);
		this.add(textField1);
		this.add(lblNbr2);
		this.add(textField2);
		this.add(btnAdd);
		this.add(btnSub);
		this.add(resultLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double nbr1, nbr2;
		String nbr1String, nbr2String, res;
		
		nbr1String = textField1.getText();
		nbr2String = textField2.getText();
		nbr1 = Double.parseDouble(nbr1String);
		nbr2 = Double.parseDouble(nbr2String);
		
		if(e.getSource() == btnAdd){
			res = nbr1String + " + " + nbr2String + " = " + (nbr1 + nbr2);
			this.resultLabel.setText(res);
		}
		else if(e.getSource() == btnSub){
			res = nbr1String + " - " + nbr2String + " = " + (nbr1 - nbr2);
			this.resultLabel.setText(res);
		}
	}
}




























