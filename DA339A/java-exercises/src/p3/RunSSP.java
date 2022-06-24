package p3;

import javax.swing.JFrame;

/*	
 * 	Skriven av Philip Ekholm (HI)
 * 
 *	Välkommen till ett härligt men enkelt spel. 
 *	Detta program är jag stolt över då det är bland de
 *	största jag skrivit än så länge, även om det inte ser ut som
 *	mycket rent grafiskt.
 *
 *	Programmet använder många specifika lösningar för att lösa
 *	de problem som uppstår med programmets natur, alla förstås
 *	väl kommenterade, däremot används en lösning flitligt igenom
 *	hela programmet och det är Enumerations, vilket är värt att läsa först om.
 *
 *	http://tutorials.jenkov.com/java/enums.html
 *
 *	Jag kommer återkomma med feedback om din kod på it's learning under torsdagen,
 *	så håll ögonen öppna!
 *
 *	philipekholm@protonmail.com
*/

public class RunSSP {
	public static void main(String[] args) {
		
		/*
		 * 	Vi börjar med att skapa alla referenser till 
		 * 	objekt, sedan ordnar upp vem som känner till vilka.
		*/
		SSPPlayer player = new SSPPlayer();
		SSPViewer viewer = new SSPViewer();
		SSPController controller = new SSPController(player, viewer);
		SSPUserInput userInput = new SSPUserInput(controller);
		
		JFrame frame1 = new JFrame("Vy");
		
		//Allmännt arbete för att få JFrames att fungera, inget främmande
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLocation(50, 50);
		frame1.add( viewer );
		frame1.pack();
		frame1.setVisible( true );
		frame1.setResizable(false); //För att minimera risken att göra något dumt kan man ej ställa in storleken själv
		
		JFrame frame2 = new JFrame("Kontroller"); //Spelkontroller, skall inte förväxlas med 'controller'
		
		//Samma sak här, sätter denna vy precis under den andra för känsla av tangentbordsplacering
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(userInput);
		frame2.setLocation(45, 240);
		frame2.pack();
		frame2.setVisible(true);
		frame2.setResizable(false); //Går inte heller att resiza denna
	}  
}




























