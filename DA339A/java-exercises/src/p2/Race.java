package p2;
import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;
import gu2.PaintWindow_GU2;
import paintpanel.*;

/*
 * 	Välkommen till det fetaste spel av de alla! 
 * 	Hoppas du läser detta i förhand då du kan behöva 
 * 	skruva ner volymen innan du börjar spela, bra 
 * 	ljudeffekter garanteras!
 * 
 * 	Där finns inget i världen som racing, speciellt 
 * 	int spel byggda på racing. Två bilar möts och 
 * 	tävlar om äran. Detta spel kommer snart till App Store (Hoppas jag)!
*/

public class Race {
	private PaintWindow_GU2 window; //Vårat fönster
	private Car redCar, blueCar; //De olika bilarna, skapade som instanser av bil-klassen.
	private Sound music = null, //Musik som kommer startas upp senare.
				  start1 = null,
				  start2 = null;
	private Text winner; //Text som ska visas sedan för att 
	
	/*
	 * 	Konstruktor som bygger objekt och sätter instansvariabler.
	*/
	
	public Race(PaintWindow_GU2 window, Car car1, Car car2){
		this.window = window;
		this.redCar = car1;
		this.blueCar = car2;
	}
	
	/*	Denna metod skulle man kunna sätta all kod i, men 
	 * 	det skulle bli fruktansvärt, spelet är uppdelat i 
	 * 	flera privata metoder som exekverar varandra.
	*/
	
	public void action(){
		this.drawGraphics();
		this.initializeSoundSystems();
		this.countDown();
	}
	
	//Metoden ritar upp banan, lägger till all nödvändig grafik och sätter ut positioner.
	private void drawGraphics(){
		
		/*
		 *	 Vi tar in alla nödvändiga bilder som ska användas för spelet.
		 *	PaintWindow tillåter mig inte att använda samma bild för att lägga till
		 *	Två ikoner, så jag får köra med två objekt med samma bild...
		*/
		ImageIcon finishLine1 = new ImageIcon("images/finishLine.jpg"),
				finishLine2 = new ImageIcon("images/finishLine.jpg"),
				background = new ImageIcon("images/grass.jpg");
		
		window.setBackground(background); //Sätter bakgrunden på skärmen
		
		//Positionera bilarna
		redCar.moveTo(860, 233); //Sätter startpositionerna på bilarna, därefter trackar vi var de är hela tiden
		blueCar.moveTo(860, 433);
		window.addIcon(redCar.getImage(), redCar.getX(), redCar.getY(), true); //Lägg till ikonerna av bilarna
		window.addIcon(blueCar.getImage(), blueCar.getX(), blueCar.getY(), true);
		
		//Lägg till asfalt såväl som mållinjer, färgen är förbestämd av godtycklig, verklig asfalt.
		window.fillRect(100, 200, 860, 100, new Color(124, 124, 126));
		window.addIcon(finishLine1, 40, 200, true);
		window.fillRect(100, 400, 860, 100, new Color(124, 124, 126));
		window.addIcon(finishLine2, 40, 400, true);
		
		/*
		 * 	Här lägger vi till startljuset! Därefter kör loopen och lägger
		 * 	till röda cirklar som ska representera ljuset. För att bestämma x-positionen används i för att inkrementera.
		*/
		window.fillRect(400, 30, 200, 50, Color.BLACK);
		for(int i = 0; i < 5; i++){
			window.fillOval(412 + i * 37, 42, 25, 25, Color.RED);
		}
	}
	
	/*
	 * 	Visst kunde man ha kallat den för startSounds 
	 * 	eller något, men ett mycket coolare metodnamn 
	 * 	finns nedanför. Det är inte ett ljud, det är ett 
	 * 	fungerande ljudsystem. 
	*/
	private void initializeSoundSystems(){
		//Rolf använder sig utav exceptions för att hantera om filerna existerar, detta kommer inte diskuteras mer här.
		try {
			//Alla ljudfiler som används för projektet.
			music = new Sound("sounds/faith_instrumental.mp3");
			start1 = new Sound("sounds/countdown1.mp3");
			start2 = new Sound("sounds/countdown2.mp3");
		} catch (Exception e) {
			
		}
		if(music!=null) { //Kollar så att filen existerar (vilket den måste göra vid nu).
			music.play();
			music.setVolume(0.4); //Visste ärligt talat inte att man dynamiskt kunde sätta volymen, tur man kunde det.
		}
	}
	
	/*
	 * 	Denna metod är ansvarig för nedräkningen. När den är klar sätts racet igång. 
	*/
	private void countDown(){
		PaintWindow_GU2.pause(3000);
		
		//Fyll över de röda ljusen med gröna, detta är hur vi uppdaterar ljussignalen. Detta sker då varje sekund. Vi skapar de på samma sätt via en loop som förut.
		for(int i = 0; i < 5; i++){
			window.fillOval(412 + i * 37, 42, 25, 25, Color.GREEN);
			start1.play();
			//Kollen används för att veta om det är sista ljuset, då den måste gå igång innan pausningen.
			if(i >= 4){
				start2.play();
			}
			PaintWindow_GU2.pause(1000);
		}
		//Nu är alla gröna, dags att köra på.
		this.drive();
	}
	
	/*
	 * 	Här händer allt det bra. Vi använder oss 
	 * 	av en enkel renderingsmetod för att generera 
	 * 	frames på skärmen. tills någon har vunnit loopar 
	 * 	vi nya positioner hos bilarna tills en av dem är i mål. 
	 * 
	 * 	Mellan varje loop går det 50ms tills den loopar igen. 
	 * 	Detta innebär att uppdateringsfrekvensen av spelet är 
	 * 	inversen av periodtiden (50ms), detta får vi till 20Hz. 
	 * 	Detta innebär att spelet har en framerate på 20FPS, vilket 
	 * 	är lite, men gott nog för ett sådant primitivt spel.
	*/
	
	private void drive(){
		int finish = 240, //Där mållinjen ligger
			redVelocity = 0, //detta är bilarnas hastighet.
			blueVelocity = 0,
			posRed = redCar.getX(), //Bilarna position i X-led
			posBlue = blueCar.getX();
		Random rand = new Random();
		
		/*
		 * 	Villkoret för att spelet ska vara igång är att ingen av bilarna är framme vid mål. 
		 * I loopen slumpas nya hastigheter (egentligen farter) för att de hela tiden ska förändras. 
		 * Efter det uppdateras bilarnas position såväl som deras ikoner på skärmen.
		*/
		while(redCar.getX() >= finish && blueCar.getX() >= finish){
			redVelocity = rand.nextInt(5) + 1;
			blueVelocity = rand.nextInt(5) + 1;
			posRed -= redVelocity;
			posBlue -= blueVelocity; //Vi tar bort 
			
			redCar.moveTo(posRed, redCar.getY());
			blueCar.moveTo(posBlue, blueCar.getY());
			window.setIconXY(redCar.getImage(), redCar.getX(), redCar.getY());
			window.setIconXY(blueCar.getImage(), blueCar.getX(), blueCar.getY());
			PaintWindow_GU2.pause(50);
		}

		/*
		*	Här utförs ett enkelt test för att kontrollera vem som vinner. 
		*	Beroende på vem som vinner så kommmer olika textobjekt att visas sedan.
		*/

		Font stdFont = new Font("Arial", Font.PLAIN, 50);
		
		if(redCar.getX() < blueCar.getX()){
			winner = new Text("Winner: Red!", stdFont, Color.RED);
		}
		else if(redCar.getX() > blueCar.getX()){
			winner = new Text("Winner: Blue!", stdFont, Color.BLUE);
		}

		//Lägg till texten
		
		window.fillRect(0, 100, window.getBackgroundWidth(), 80, Color.WHITE);
		window.addText(winner, 330, 110);
		//Anropa sedan sista metoden
		this.finish();
	}
	
	//Och utför det allra sista
	private void finish(){
		PaintWindow_GU2.pause(6000);
		music.stop();
		System.exit(0);
	}
}
















