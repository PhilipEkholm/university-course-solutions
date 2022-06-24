package laboration10; 
import javax.swing.*; 
import java.awt.*;  

public class ImageViewer extends JPanel {     
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle = new JLabel();     
	private JLabel lblImage = new JLabel("INGEN BILD VALD", JLabel.CENTER);
	public ImageViewer() {
		setLayout( new BorderLayout() );         
		lblImage.setPreferredSize( new Dimension( 640, 480 ) );         
		add(lblTitle, BorderLayout.NORTH);
		add(lblImage, BorderLayout.CENTER);
	}      
	
	public void showImage(String filename) {
		lblTitle.setText(filename);
		lblImage.setText("");
		lblImage.setIcon(new ImageIcon(filename));
	}
	
	public void noImage() {
		lblImage.setText("INGEN BILD VALD");
		lblImage.setIcon(null);
	}      
	
	public static void main(String args[]) {
		ImageViewer viewer = new ImageViewer();
		viewer.showImage("images/filmlogga.jpg");  // alt. viewer.noImage();         
		JOptionPane.showMessageDialog(null, viewer);
	}
}
