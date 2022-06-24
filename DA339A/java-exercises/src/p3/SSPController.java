package p3;

/*
 * 	Skriven av Philip Ekholm (HI)
 * 
 * 
 * 	Som du vet redan är kontrollern den som sköter all spellogik,
 * 	så här finns den. Vi har variabler för att hålla koll på poäng, även 
 * 	maxpoäng, om spelet ens är påbörjat, om spelaren kör hard-mode
*/

public class SSPController {
	//Vi sätter dem alla till 0 default
	private int playerPoints = 0,
				computerPoints = 0,
				maxPoints = 0;
	private SSPPlayer computerPlayer;
	private SSPViewer view;
	//Används för att kontrollera om spelet är igång eller inte
	private boolean gameStarted = false,
					hardMode = false;
	private SSPUserInput userInput; //Används för extrauppgiften med att dimma knapparna.
	
	public SSPController(SSPPlayer player, SSPViewer viewer){
		//Vi sätter datorspelaren och vyn
		this.computerPlayer = player;
		this.view = viewer;
	}
	
	/*
	 *	När användaren trycker på någon av rondknapparna så körs newGame-metoden.
	 *	Då kommer maxpoäng att bli satt. 
	 *
	 * 	Vi passar även på att nollställa om ett tidigare spel har gjorts
	 * 	utan att stänga programmet. Vi startar även upp spelet.
	*/
	
	public void newGame(int maxPoints){
		this.maxPoints = maxPoints;
		this.playerPoints = 0;
		this.computerPoints = 0;
		userInput.enableChoiceButtons(true);
		userInput.enableRoundButtons(false);
		
		view.updateTitle("Först till " + this.maxPoints + " vinner!");
		view.updatePoints(0, 0);
		view.resetChoices();
		this.gameStarted = true;
	}
	
	//Här ställer vi in utifrån checkboxen om hardmode är på eller ej, hur detta påverkar finns längre ner.
	
	public void setMode(boolean box){
		this.hardMode = box;
	}
	
	/*
	 *	Den här metoden är lite klurig. Denna finns här för 
	 *	extrauppgiften med dimbara knappar. 
	 *
	 * 	userInput skickar en referens av sig själv till kontroller
	 * 	via den här metoden, och sedan sätts den.
	 * 	
	 * 	Den skickas från konstruktorn i SSPUserInput
	*/
	
	public void setUserInput(SSPUserInput input){
		this.userInput = input;
	}
	
	/*
	 * 	Här är spelkärnan i det stora hela. När användaren 
	 * 	klickar på ett val kommer det skickas med här som 
	 * 	argument (parameter).
	 * 
	 * 	Den kollar om spelet är startat, då kommer "attacken" 
	 * 	att utföras (handlingen). Beroende om man kör hardmode
	 * 	eller inte kommer olika handligar från dator "AI:n" att utföras.
	*/
	
	public void newAttack(ChoiceHuman cHuman){
		if(this.gameStarted){
			ChoiceHuman humanChoice = cHuman; //Spara ner användarens val som en enum
			ChoiceComputer computerChoice; //Sätt den lika med AI:ns motattack
			
			if(!hardMode){	//Om användaren kör normal
				computerChoice = computerPlayer.counterAttack();
			}
			else if(hardMode){	//Om användaren kör hard
				computerChoice = computerPlayer.predictingCounterAttack(humanChoice);
			}
			else{
				//Skriv ut om något har gått fel.
				computerChoice = ChoiceComputer.STONE;
				System.out.println("Något gick fruktansvärt fel");
			}
			
			/*
			 *	this.givePoints är en annan funktion som innehåller 
			 *	en algoritm för att ge poäng beroende på spelregler och val, 
			 *	med andra ord: den avgör vem som ska få poäng och lägger 
			 *	till det till kontrollerns variabler 
			*/
			
			this.givePoints(humanChoice, computerChoice);
			//Uppdatera det grafiska med metoderna
			view.updatePoints(this.playerPoints, this.computerPoints);
			view.updateChoices(humanChoice, computerChoice);
			
			//Kolla om någon har nått maxpoäng, för isf är spelet slut!
			if((this.playerPoints >= this.maxPoints) || (this.computerPoints >= this.maxPoints)){
				this.finalizeRound();
			}
		}
	}
	
	/*
	 *	Algoritmen jämför olika val i form av enums, som löses med en kombination av
	 *	switch och if-satser, också här finns en default case om något skulle gå snett. 
	*/
	
	private void givePoints(ChoiceHuman cHuman, ChoiceComputer cComputer){
		switch(cHuman){
		case STONE:
			if(cComputer == ChoiceComputer.BAG){
				this.computerPoints += 1;
			}
			else if(cComputer == ChoiceComputer.SCISSORS){
				this.playerPoints += 1;
			}
			break;
		case SCISSORS:
			if(cComputer == ChoiceComputer.STONE){
				this.computerPoints += 1;
			}
			else if(cComputer == ChoiceComputer.BAG){
				this.playerPoints += 1;
			}
			break;
		case BAG:
			if(cComputer == ChoiceComputer.SCISSORS){
				this.computerPoints += 1;
			}
			else if(cComputer == ChoiceComputer.STONE){
				this.playerPoints += 1;
			}
			break;
		default:
			System.out.println("Något gick fel när poäng skulle bestämmas");
		}
	}
	
	//Denna är kopplad till avsluta knappen och stänger programmet.
	
	public void exit(){
		System.exit(0);
	}
	
	//Denna avslutar spelet, dimmar knappar, bestämmer vinnaren och sätter gamestarted till false.
	
	private void finalizeRound(){
		this.gameStarted = false;
		userInput.enableChoiceButtons(false);
		userInput.enableRoundButtons(true);
		
		if(this.playerPoints > this.computerPoints){
			view.updateTitle("Segern går till människan.");
		}
		else if(this.playerPoints < this.computerPoints){
			view.updateTitle("Datorn vann!");
		}
	}
}






























