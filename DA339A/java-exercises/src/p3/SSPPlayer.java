package p3;
import java.util.Random;

/*
 * 	Klasen skriven av Philip Ekholm (HI)
 * 
 *	Den här klassen tycker jag är mycket spännande.
 *	Det är den här klassen som är AI:n av datorn.
 *
 * 	Om kontrollern behöver ett respons används den här 
 * 	klassen för att bestämma en "counter-attack".
 * 
 * 	Om hard-mode knappen är checkad, kommer den andra metoden anropas. 
 * 	Annars kommer första metoden anropas.
 */

public class SSPPlayer {
	/*
	 *	Inget spännande som händer här. 
	 *	Ett värde slumpas, blir antingen 1, 2 eller 3.
	 *
	 *	Sedan kommer switch-statementet översätta detta till en enum-state som sedan returneras.
	 */
	private Random rand = new Random();
	
	public ChoiceComputer counterAttack(){
		int numberOfChoices = rand.nextInt(3) + 1; //För enkelhetens skull: 1, 2, 3
		
		//Finns även ett default case för felsökning
		switch(numberOfChoices){
		case 1:
			return ChoiceComputer.STONE;
		case 2:
			return ChoiceComputer.SCISSORS;
		case 3:
			return ChoiceComputer.BAG;
		default:
			System.out.println("Något gick fel hos datoralgoritmen");
			return ChoiceComputer.STONE;
		}
	}
	
	/*
	 * 	Detta är vad jag personligen älskar kring AI: informationsprocessen.
	 * 
	 * 	Detta är vad som gör hard-mode hard, mer utförligt beskrivet det omöjliga läget. Här skickas
	 * 	spelarens val med. Beroende på val av attack kommer ett visst case att utföras. 
	 * 
	 * 	Valet som returneras kommer aldrig kunna ge spelaren poäng vilket gör datoralgoritmen överlägsen.
	 * 	En boolean med slumpad true/false kommer avgöra om draget blir lika eller poänggivande till datorn.
	 * 
	 * 	Vid valet av retur används en ternary operatör. 
	 * 	Det är i princip som en inline-if-else statement. Läs JF 123-124 'The conditional operator'.
	 */
	
	public ChoiceComputer predictingCounterAttack(ChoiceHuman cHuman){
		boolean choiceOfAttack = rand.nextBoolean(); //Slumpar true eller false
		
		//Vad användaren tryckte
		switch(cHuman){
		case STONE:
			return choiceOfAttack ? ChoiceComputer.STONE : ChoiceComputer.BAG;
		case SCISSORS:
			return choiceOfAttack ? ChoiceComputer.SCISSORS : ChoiceComputer.STONE;
		case BAG:
			return choiceOfAttack ? ChoiceComputer.BAG : ChoiceComputer.SCISSORS;
		default:
			System.out.println("Något gick fel hos den avancerade algoritmen");
			return ChoiceComputer.STONE;
		}
	}
}




































