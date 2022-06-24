package p3;

/*
 * 	Enum skriven av Philip Ekholm (HI)
 * 	
 * 	Du har säkert, precis som 95% av klassen kört 
 * 	med 0, 1, eller 2 för att representera sten, sax 
 * 	eller påse. En enumeration i java är i princip den samma,
 * 	men istället för att behöva komma ihåg vad 0 och 1 betydde
 * 	kan man skriva en enumeration, som består av states.
 * 
 * 	Dessa gör koden mer lättläst, och svårare att göra fel på 
 * (skulle du mata in 5 vid val av attack skulle du ha stora problem!).
 * 
 * 	Tyvärr täcks dem inte i OOP kursen vilket jag tycker är synd, då de 
 * 	blir mer och mer populära i språk.
 * 
 * 	I detta program är en för datorn skriven och en för användaren för 
 * 	att kunna skilja på dem när de ska kompareras.
 * 
 * 	http://tutorials.jenkov.com/java/enums.html
*/

public enum ChoiceHuman {
	STONE,
	SCISSORS,
	BAG
}
