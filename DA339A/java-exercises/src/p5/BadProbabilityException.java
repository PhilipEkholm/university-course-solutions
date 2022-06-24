package p5;

/*
 * 	Ett exception som kastas om sannolikheten inte överrensstämmer. Denna är en form av unchecked exception
 */

public class BadProbabilityException extends RuntimeException{
	private static final long serialVersionUID = 1L; //Lägger till denna för att undvika varning

	public BadProbabilityException(){
		super();
	}
	
	public BadProbabilityException(String message){
		super(message);
	}
}
