package laboration13;

public class Motorcycle extends MotorVehicle{

	private String regNumber;
	
	public Motorcycle() {
		super();
	}
	
	public Motorcycle(String owner, int hp, String regNumber){
		super(owner, hp);
		this.regNumber = regNumber;
	}
	
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	public String toString(){
		return "Ägare: " + this.getOwner() + ", Motorns hästkrafter: " + this.getHp() + ", Registreringsnummer: " + this.regNumber;
	}
}
