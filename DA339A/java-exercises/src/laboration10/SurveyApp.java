package laboration10;
import javax.swing.*;

public class SurveyApp {
	public void launch(){
		JFrame window = new JFrame("Personundersökning");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new SurveyPanel());
		
		//Paneler MÅSTE läggas till INNAN detta
		window.pack();
		window.setVisible(true);
		window.setResizable(true);
	}
	
	public static void main(String[] args) {
		SurveyApp app = new SurveyApp();
		app.launch();
	}
}
