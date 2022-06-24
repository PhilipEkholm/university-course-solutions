package p2;
import java.time.*;
import java.util.*;

/*
 *	Klassen skriven av Philip Ekholm
 *
 * 	Klassen håller koll på tiden. 
 * 	Den håller reda på timmar, minuter, 
 * 	sekunder, och kan även uppdatera vid behov.
 */

public class Time {
	/*
	 * 	Privata attribut, precis som innan. 
	 * Instansvariabler för att hålla koll på 
	 * calendar och tiden.
	*/
	
	private int hours, minutes, seconds;
	private Calendar cal;
	/*
	 * 	För att lösa problem med uppdatering 
	 * 	med klockan används Instant och Duration 
	 * 	objekt för att hålla koll på antalet 
	 * 	millisekunder mellan event.
	*/
	private Instant initialTime = Instant.now(), //Lagrar antalet millisekunder sedan 1 januari 1970 och nu
					updatedTime; //Används senare
	private Duration timeSpan; //Används senare
	
	/*
	 * 	Konstruktor för att skapa och sätta alla attribut. Klassvariabler används här.
	*/
	public Time(){
		cal = Calendar.getInstance();
		this.hours = cal.get(Calendar.HOUR_OF_DAY);
		this.minutes = cal.get(Calendar.MINUTE);
		this.seconds = cal.get(Calendar.SECOND);
	}
	
	//Getters för timmar, minuter, sekunder.
	
	public int getHour(){
		return this.hours;
	}

	public int getMinute() {
		return minutes;
	}

	public int getSecond() {
		return seconds;
	}
	
	//ToString för att få en sammanfattning.
	public String toString(){
		return this.hours + ":" + this.minutes + ":" + this.seconds;
	}
	
	/*
	 * 	För att lösa problemet med att 
	 * 	uppdatera tiden så används instant 
	 * 	och duration objekten här. När metoden 
	 * 	kallas så kollar vi nu hur många 
	 * 	millisekunder som gått sedan innan, 
	 * 	sedan så jämför vi.
	*/
	
	public void update(){
		updatedTime = Instant.now();// Ta nuvarande tiden
		timeSpan = Duration.between(initialTime, updatedTime); //Tar skillnaden (differensen) mellan starten och nu
		initialTime = Instant.now(); //Måste göras ifall man ska göra en till uppdatering senare eventuellt. 
		
		//Lägg på detta på attributen och konvertera till olika baser (sekunder, minuter, timmar).
		this.seconds += timeSpan.getSeconds();
		if(this.seconds >= 60){
			this.minutes += 1;
			this.seconds -= 60;
		}
		if(this.minutes >= 60){
			this.hours += 1;
			this.minutes -= 60;
		}
		this.minutes += timeSpan.toMinutes();
		this.hours += timeSpan.toHours();
	}
}

























