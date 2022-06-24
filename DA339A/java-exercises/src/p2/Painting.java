package p2;

/*
 *	Klassen skriven av Philip Ekholm
 *
 * 	Klassen beskriver en tavla, som kan innehålla 
 * titel, målare såväl som året verket står färdigt
 * (ironiskt nog finns ingen ImageIcon för att faktiskt
 * visa själva målningen).
 */

public class Painting {
	/*
	 * 	Privat deklarerade attribut (instansvariabler), 
	 * notera att om du separerar dem med ett kommatecken 
	 * så betyder det att den ska ha samma prefixer som 
	 * förgående variabel, vilket används här såväl som på andra ställen.
	 * 
	 * Vi inkluderar titel, målare och året verket är färdigt.
	 */
	private String title, painter;
	private int year;
	
	//Konstruktor som bygger objektet åt oss och sätter attributen.
	public Painting(String title, String painter, int year){
		this.title = title;
		this.painter = painter;
		this.year = year;
	}
	
	//Getters för alla attribut för att hämta informationen om dem.
	public String getTitle() {
		return title; //Återvänder med svar via return, samma gäller för alla getters i klassen.
	}

	public String getPainter() {
		return painter;
	}

	public int getYear() {
		return year;
	}
	
	//String som ger en sammanfattning av alla attribut tillbaka till anroparen.
	@Override
	public String toString() {
		return title + " av " + painter + ", " + year;
	}
}
