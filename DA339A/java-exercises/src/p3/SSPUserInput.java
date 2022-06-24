package p3;
//För optimeringens skull är alla individuella paket importerade.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/*
 * 	Klassen skriven av Philip Ekholm (HI)
 * 	
 *	Denna panel är ansvarig för användarens val. Här finns knapparna, 
 *	eventlyssnare till kontrollers och allt det som jag hoppas är ganska
 *	förståeligt.
 *
 *	Vyn är uppdelad i en övre panel och en underpanel. Den övre panelen kör
 *	GridLayout då jag tycker det passar bättre med valen man har. Hela fönstret
 *	kör en BorderLayout. 
 *	
 *	Underpanelen består av en enklare FlowLayout då den använder sig utav en knapp och en checkbox.
*/

public class SSPUserInput extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L; //Måste finnas här då eclipse ger en varning annars
	/*
	 *	Vi har en referens till kontroller, 7 knappar och en checkbox. 
	*/
	private SSPController controller; 
	private JButton btnStone = new JButton("Sten"),
					btnScissors = new JButton("Sax"),
					btnBag = new JButton("Påse"),
					btnNewRound3 = new JButton("3 Poäng"),
					btnNewRound5 = new JButton("5 Poäng"),
					btnNewRound10 = new JButton("10 Poäng"),
					btnExit = new JButton("Avsluta");
	private JCheckBox checkBoxHardMode = new JCheckBox("Hard mode");
	private JPanel upperButtonPanel = new JPanel(new GridLayout(2, 3, 10, 10)), //rader, kolumner, horisontal-marginal, vertikal-marginal
				   lowerButtonPanel = new JPanel(new FlowLayout());
	
	/*
	 *	Konstruktorn för klassen. Den här konstruktorn är lite större 
	 *	än de andra, denna klass har lite mer "house keeping".
	*/
	public SSPUserInput(SSPController controller){
		this.controller = controller;
		//Ha kontroller-referens, sätt dimensioner på vyn, sätt den till BorderLayout
		this.setPreferredSize(new Dimension(290, 100));
		this.setLayout(new BorderLayout());
		
		lowerButtonPanel.setLocation(getX(), 50);
		btnExit.setPreferredSize(new Dimension(150, 25)); //Gör den lite bredare då jag anser den kan vara det.
		/*
		 * 	Det jag gör under här är att skicka med en referens av sig själv till kontrollern,
		 * 	så den kan sätta objektet och jag kan dimma knapparna!
		*/
		this.controller.setUserInput(this); 
		this.enableChoiceButtons(false); //dimmar valknapparna av default
		
		this.addListeners();
		this.addComponents();
	}
	
	private void addComponents(){
		upperButtonPanel.add(btnStone);
		upperButtonPanel.add(btnScissors);
		upperButtonPanel.add(btnBag);
		upperButtonPanel.add(btnNewRound3);
		upperButtonPanel.add(btnNewRound5);
		upperButtonPanel.add(btnNewRound10);
		
		lowerButtonPanel.add(btnExit);
		lowerButtonPanel.add(checkBoxHardMode);
		
		//Lägg knapparna i "center", och avsluta/hard mode i syd
		this.add(upperButtonPanel, BorderLayout.CENTER);
		this.add(lowerButtonPanel, BorderLayout.SOUTH);
	}
	
	//Metod för att koppla in listeners
	private void addListeners(){
		btnStone.addActionListener(this);
		btnScissors.addActionListener(this);
		btnBag.addActionListener(this);
		btnNewRound3.addActionListener(this);
		btnNewRound5.addActionListener(this);
		btnNewRound10.addActionListener(this);
		checkBoxHardMode.addActionListener(this);
		
		btnExit.addActionListener(this);
	}
	
	/*
	 *	Som du vet redan, men här skickas anrop till kontrollern
	 *	beroende på vilken knapp man klickar på. Om det är en ny attack skickas en enum-state till.
	 *
	 *	Är det rondknapparna skickas nytt game med max poäng.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStone){
			controller.newAttack(ChoiceHuman.STONE);
		}
		else if(e.getSource() == btnScissors){
			controller.newAttack(ChoiceHuman.SCISSORS);
		}
		else if(e.getSource() == btnBag){
			controller.newAttack(ChoiceHuman.BAG);
		}
		else if(e.getSource() == btnNewRound3){
			controller.newGame(3);
		}
		else if(e.getSource() == btnNewRound5){
			controller.newGame(5);
		}
		else if(e.getSource() == btnNewRound10){
			controller.newGame(10);
		}
		else if(e.getSource() == checkBoxHardMode){
			controller.setMode(checkBoxHardMode.isSelected());
		}
		else if(e.getSource() == btnExit){
			controller.exit();
		}
	}
	
	/*
	 *	Alla knappgrupper som hör till varandra togglas här beroende på
	 *	vad man skickar med.  
	 */
	
	public void enableChoiceButtons(boolean toggle){
		btnStone.setEnabled(toggle);
		btnScissors.setEnabled(toggle);
		btnBag.setEnabled(toggle);
	}
	
	public void enableRoundButtons(boolean toggle){
		btnNewRound3.setEnabled(toggle);
		btnNewRound5.setEnabled(toggle);
		btnNewRound10.setEnabled(toggle);
	}
}






























