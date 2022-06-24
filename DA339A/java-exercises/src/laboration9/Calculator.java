package laboration9;
import javax.swing.JFrame;

public class Calculator {
	public void launch(){
		JFrame window = new JFrame("Kalkylator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.add(new CalcPanel());
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
		
	}
	
	public static void main(String[] args) {
		Calculator app = new Calculator();
		app.launch();
	}
}
