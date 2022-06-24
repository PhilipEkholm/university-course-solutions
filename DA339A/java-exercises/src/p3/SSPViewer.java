package p3;

//För optimeringens skull är alla individuella paket importerade.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SSPViewer extends JPanel{
	private static final long serialVersionUID = 1L; //Måste finnas här då eclipse ger en varning annars
	/*
	 * 	Skriven av Philip Ekholm (HI)
	 * 
	 * 	Vi skapar alla komponenter som vi behöver
	 * 	För vyn att visa allt vi behöver
	 * 
	 * 	Vyn är indelad i titelfönster och övriga fönstret.
	 * 	Då jag inte lyckades få texten i övriga fönstret att centreras
	 * 	Valde jag att köra en "NullLayout" för att få det rätt.
	 * 
	 * 	Arial används som font för sin simplicitet
	*/
	private JLabel labelTitle = new JLabel("Sten, sax, påse"),
				   labelHuman = new JLabel("Människa"),
				   labelComputer = new JLabel("Dator"),
				   labelPointsHuman = new JLabel("0"),
				   labelPointsComputer = new JLabel("0"),
				   labelChoiceHuman = new JLabel("Sten"),
				   labelChoiceComputer = new JLabel("Sax");
	private JPanel northPanel = new JPanel(new FlowLayout()),
				   centerPanel = new JPanel(null);
	private Font titleFont = new Font("Arial", Font.PLAIN, 24), //Denna är lite större än den andra
				 standardFont = new Font("Arial", Font.PLAIN, 16);
	
	//Konstruktor för att bestämma fönsterstorlek, sätta layout
	public SSPViewer(){
		this.setPreferredSize(new Dimension(280, 150));
        this.setLayout(new BorderLayout());
        
        /*
         *	För att göra konstruktorn hanterbar är koden uppdelad i flera
         *	privata metoder. Jag anser dem ganska självförklarande. 
        */
        this.setDimensions();
		this.setFonts();
		this.addComponents();
	}
	
	private void setFonts(){
		labelTitle.setFont(titleFont);
		labelHuman.setFont(standardFont);
		labelComputer.setFont(standardFont);
		labelPointsHuman.setFont(titleFont);
		labelPointsComputer.setFont(titleFont);
		labelChoiceHuman.setFont(standardFont);
		labelChoiceComputer.setFont(standardFont);
	}
	
	/*
	 *	Vi bestämmer x, y, width, height för nästan alla komponenter här,
	 *	då nulllayout kräver det. 
	*/
	
	private void setDimensions(){
		centerPanel.setBounds(0, 0, 280, 150);
		labelHuman.setBounds(20, 20, 200, 30);
		labelComputer.setBounds(200, 20, 100, 30);
		labelPointsHuman.setBounds(42, 55, 30, 20);
		labelPointsComputer.setBounds(210, 55, 30, 20);
		labelChoiceHuman.setBounds(32, 90, 40, 20);
		labelChoiceComputer.setBounds(200, 90, 40, 20);
	}
	
	private void addComponents(){
		northPanel.add(labelTitle);
		centerPanel.add(labelHuman);
		centerPanel.add(labelComputer);
		centerPanel.add(labelPointsHuman);
		centerPanel.add(labelPointsComputer);
		centerPanel.add(labelChoiceHuman);
		centerPanel.add(labelChoiceComputer);
		
		//Sätt titeln i norr och resten i center.
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
	}
	
	/*
	 *	Metoderna  updateTitle, updatePoints och updateChoices
	 *	är till för att uppdatera den grafiska vyn med information
	 *	som är lämplig för användaren att se. De är ganska simpla då
	 *	argument passeras in och sätts till labels.
	 *
	 *	updateChoices är lite speciell. Den använder sig utav enumerations
	*/
	
	public void updateTitle(String title){
		labelTitle.setText(title);
	}
	
	public void updatePoints(int humanPoints, int computerPoints){
		//Integer.toString används för att kunna parsa heltalen rakt igenom till text.
		labelPointsHuman.setText(Integer.toString(humanPoints));
		labelPointsComputer.setText(Integer.toString(computerPoints));
	}
	
	public void updateChoices(ChoiceHuman cHuman, ChoiceComputer cComp){
		/*
		 *	Kontrollern kan vad som har valts, 
		 *	dessa skickas som en enumeration state 
		 *	som översätts till text via en switch-sats
		*/
		
		switch(cHuman){
		case STONE:
			labelChoiceHuman.setText("Sten");
			break;
		case SCISSORS:
			labelChoiceHuman.setText("Sax");
			break;
		case BAG:
			labelChoiceHuman.setText("Påse");
			break;
		default: 
			labelChoiceHuman.setText("ERROR");
			break;
		}
		
		//Gör likadant för datorn. Default cases finns för eventuell felsökning
		
		switch(cComp){
		case STONE:
			labelChoiceComputer.setText("Sten");
			break;
		case SCISSORS:
			labelChoiceComputer.setText("Sax");
			break;
		case BAG:
			labelChoiceComputer.setText("Påse");
			break;
		default: 
			labelChoiceHuman.setText("ERROR");
			break;
		}
	}
	
	//Denna krävs om man vill starta nytt spel
	
	public void resetChoices(){
		labelChoiceHuman.setText("");
		labelChoiceComputer.setText("");
	}
}





























