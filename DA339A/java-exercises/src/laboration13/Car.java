package laboration13;

public class Car extends MotorVehicle{
	private String regNumber;
	
	public Car(){
		super();
	}
	
	public Car(String owner, int hp, String regNumber){
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
