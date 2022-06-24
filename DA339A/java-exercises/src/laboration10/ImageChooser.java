package laboration10; 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  

public class ImageChooser extends JPanel {     
	private Controller controller;     
	private JRadioButton rbImage1 = new JRadioButton( "London" );     
	private JRadioButton rbImage2 = new JRadioButton( "FilmLogga" );    
	private JRadioButton rbImage3 = new JRadioButton( "Lugi" );    
	private JRadioButton rbImage4 = new JRadioButton( "Tandem" );    
	private JRadioButton rbImage5 = new JRadioButton( "Detta program" );     
	private ButtonGroup buttonGroup = new ButtonGroup();     
	private JButton btnErase = new JButton( "Ta bort bild" );
	
	/** Creates new form ImageChooser */     
	public ImageChooser( Controller controller ) {         
		JPanel pnlRadioButtons = new JPanel( new GridLayout(5,1) );         
		this.controller = controller;         
		setLayout( new BorderLayout() );         
		setPreferredSize( new Dimension( 200, 190 ) );         
		buttonGroup.add( rbImage1 );         
		buttonGroup.add( rbImage2 );         
		buttonGroup.add( rbImage3 );         
		buttonGroup.add( rbImage4 );
		buttonGroup.add( rbImage5 );
		btnErase.setBounds(10, 130, 200, 23);
		addListeners();
		pnlRadioButtons.add( rbImage1 );
		pnlRadioButtons.add( rbImage2 );
		pnlRadioButtons.add( rbImage3 );
		pnlRadioButtons.add( rbImage4 );
		pnlRadioButtons.add( rbImage5 );
		add(pnlRadioButtons, BorderLayout.CENTER);         
		add( btnErase, BorderLayout.SOUTH );     
	}          
	
	public void addListeners() {         
		ImageListener listener = new ImageListener();         
		rbImage1.addActionListener( listener );         
		rbImage2.addActionListener( listener );         
		rbImage3.addActionListener( listener );         
		rbImage4.addActionListener( listener );         
		rbImage5.addActionListener( listener );         
		btnErase.addActionListener( new EraseListener() );     
	}          
	
	private class EraseListener implements ActionListener {        
		public void actionPerformed(ActionEvent e) {             
			controller.eraseImage();         
		}     
	}          
	
	private class ImageListener implements ActionListener {         
		public void actionPerformed(ActionEvent e){             
			if (rbImage1.isSelected())                 
				controller.newImage("images/london06.jpg");             
			else if (rbImage2.isSelected())                 
				controller.newImage("images/filmlogga.jpg");             
			else if (rbImage3.isSelected())                 
				controller.newImage("images/lugi.gif");            
			else if (rbImage4.isSelected())                 
				controller.newImage("images/tandem1.jpg");             
			else if (rbImage5.isSelected())                 
				controller.newImage("images/program.bmp");         
			}    
	} 
}
















