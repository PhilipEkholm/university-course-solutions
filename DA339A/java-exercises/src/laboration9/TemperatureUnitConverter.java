package laboration9;
import javax.swing.JFrame;

public class TemperatureUnitConverter {
	public void launch(){
		JFrame window = new JFrame("Konverterare");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new TemperatureUnitConverterPanel());
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
	}
	
	public static void main(String[] args) {
		TemperatureUnitConverter app = new TemperatureUnitConverter();
		app.launch();
	}
}
