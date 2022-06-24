package p1;
import gu1.PaintWindow_GU1;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Klassen innehåller lösnigar för uppgifter1a-1f
 * 
 * Skriven av Philip Ekholm 2016-09-18
 * */

public class Exercise1 {
	
    /*
     * Metoden beräknar totala biljettpriset och det genomsnittliga
     * biljettpriset för ett antal vuxna, barn och pensionärer.
     **/	
	public void exercise1a() {
		/*
		 * Final innebär att dessa betraktas som konstanter. Dessa kan inte ändras i värde efterhand
		 * */
		
		final int ADULT_PRICE = 110,
				  CHILD_PRICE = 60,
				  RETIRED_PRICE = 80;
		
		// Deklarerar alla variabler som behövs för programmet
		
		int numberOfAdults,
			numberOfChildren,
			numberOfRetired,
			totalPrice,
			averagePrice;

		//Kollar om talet som skickas in inte är negativa, repetera detta för var inmatning
		do{
			numberOfAdults = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet vuxna"));
		}
		while(numberOfAdults < 0);
		
		do{
			numberOfChildren = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet barn"));
		}
		while(numberOfChildren < 0);
		
		do{
			numberOfRetired = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet pensionärer"));
		}while(numberOfRetired < 0);
		
		//Totala priset bestäms för totalPrice. Genomsnittspriset bestäms för averagePrice
		totalPrice = numberOfAdults * ADULT_PRICE + numberOfChildren * CHILD_PRICE + numberOfRetired * RETIRED_PRICE;
		averagePrice = totalPrice / (numberOfAdults + numberOfChildren + numberOfRetired);
		
		//Skriver ut alltihopa i en sammanfattning
		
		JOptionPane.showMessageDialog(null, "Totala priset är: " + totalPrice + "kr\n Genomsnittspriset är: " + averagePrice + "kr");
	}
	
	/*
	 * Metoden exercise1b skriver ut alla udda tal mellan 1 till 100 i konsolen
	 */
	
	public void exercise1b() {
		//Enkel loop som loopar igenom alla udda tal
		
		for(int i = 1; i < 100; i += 2){
			System.out.print(i + " ");
		}
	}
	
	/*
	 * Metoden exercise1c låter användaren mata in ett tal, sedan avgörs om talet är < eller > eller == 0. 
	 * Detta repeteras 4ggr med en for-loop
	 */
	
	public void exercise1c(){
		for(int i = 0; i < 4; i++){
			int number = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal")); //Vårt nummer som ska testas
			
			//Kontrollera talets karaktär och skriv ut
			
			if(number < 0){
				System.out.println("Talet " + number + " är negativt");
			}
			else if(number > 0 ){
				System.out.println("Talet " + number + " är positivt");
			} 
			else if(number == 0){
				System.out.println("Talet " + number + " är lika med 0");
			}
		}
	}
	
	/*
	 * Metoden exercise1d skriver ut alla tal mellan intervallet n-m som uppfyller n+7k, varav k är en inkrementör
	 * */
	
	public void exercise1d(){
		//Deklarera variablerna
		
		int minimumInterval = Integer.parseInt(JOptionPane.showInputDialog("Ange det minsta värdet")),
			maximumInterval; //Maximalt intervall måste deklareras här för att tillhöra detta scope
		String res = "";
		
		do{
			maximumInterval = Integer.parseInt(JOptionPane.showInputDialog("Ange det största värdet")); 
			//Kolla så värdet inte blir mindre än det minimala värdet, annars blir det konstigt
		}
		while(maximumInterval < minimumInterval);
		
		//Lägg på allt på strängen som vi sen skriver ut
		res += "Min: " + minimumInterval + ", Max: " + maximumInterval + "| ";
		
		//Iterera alla tal och sedan skriv ut i konsolen
		while(minimumInterval <= maximumInterval){
			res += minimumInterval;
			if((maximumInterval -7) >= minimumInterval){
				res += ", ";
			}
			minimumInterval += 7;
		}
		
		//Slutligen skriv ut resultatet
		System.out.println(res);
	}

	/*
	*	Den här metoden initialiserar ett fönster. Detta fönster visar en gubbe. 
	*	Gubben kan styras med hjälp av loopar såväl som variabler. I denna metod
	*	rör sig gubben endimensionellt längs en bestämd x-axel
	*/
	
	public void exercise1e() {
		Random rand = new Random(); //Sätter upp Random objektet
		ImageIcon image = new ImageIcon("images/gubbe.jpg");
		PaintWindow_GU1.showWindow(600, 400, "P1", Color.WHITE); //Starta upp fönstret
		PaintWindow_GU1.addSound("musik", "music/praise_you.mp3"); //Min egen musik jag har lagt till för redovisningen
		PaintWindow_GU1.playSound("musik");
		int width = PaintWindow_GU1.getBackgroundWidth(); //Variabler som håller k
		int height = PaintWindow_GU1.getBackgroundHeight();
		int dx = -3; //dx och dy är förändring av sträcka (d.v.s. likformig hastighet)
		int dy = 0;
		int x = 250;
		int y = rand.nextInt(height-100);  // Bildens höjd är 100
		PaintWindow_GU1.addIcon("Gubbe", image, 250, y, true); //Lägg till gubben
		
		// oändlig loop, raderna 36-42 upprepas tills PaintWindow-fönstret stängs
		while(true) {
			PaintWindow_GU1.setIconXY("Gubbe",x,y);
			PaintWindow_GU1.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
			x += dx;
			y += dy;
			//Kolla om man nått ena änden av fönstret. Byt då riktning på hastigheten
			if(x<0) {
				dx = -dx;
			}
			else if((x + PaintWindow_GU1.getIconWidth("Gubbe")) >= width){
				dx = -dx;
			}
		}
	}

	/*
	*	Gör samma som exercise1e förutom att gubben r�r sig i tv� dimensioner. Se f�rra uppg för mer dokumentation
	*/
	
	public void exercise1f(){
		Random rand = new Random();
		ImageIcon image = new ImageIcon("images/gubbe.jpg");
		PaintWindow_GU1.showWindow(600, 400, "P1", Color.WHITE);
		PaintWindow_GU1.addSound("music", "sounds/praise_you.mp3");
		PaintWindow_GU1.playSound("music");
		
		int width = PaintWindow_GU1.getBackgroundWidth();
		int height = PaintWindow_GU1.getBackgroundHeight();
		// I denna uppgift slumpas även startposition av gubben. 
		// Vi slumpar också skalären av den likformiga hastigheten
		int dx = rand.nextInt(7) -3; //Slumpar mellan -3 och 3
		int dy = rand.nextInt(7) -3; //Slumpar mellan -3 och 3
		int x = rand.nextInt(501);
		int y = rand.nextInt(height-100);  // Bildens höjd är 100
		PaintWindow_GU1.addIcon("Gubbe", image, 250, y, true);
		
		// oändlig loop, raderna 36-42 upprepas tills PaintWindow-fönstret stängs
		while(true) {
			PaintWindow_GU1.setIconXY("Gubbe",x,y);
			PaintWindow_GU1.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
			x += dx;
			y += dy;
			//Samma som uppgift 1e, men här kontrollerar vi även kollisioner i y-led och förändrar riktningen av hastigheten.
			if(x<0) {
				dx = -dx;
			}
			else if((x + PaintWindow_GU1.getIconWidth("Gubbe")) > width){
				dx = -dx;
			}
			
			if(y < 0){
				dy = -dy;
			}
			else if((y + PaintWindow_GU1.getIconHeight("Gubbe")) > height){
				dy = -dy;
			}
		}
	}
	
}
