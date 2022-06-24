package laboration13;

public abstract class MotorVehicle extends Vehicle{
	private int hp;

	public MotorVehicle() {
		super();
		this.hp = 0;
	}
	
	public MotorVehicle(String owner, int hp){
		super(owner);
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int compareTo(MotorVehicle m){
		if(this.hp > m.getHp()){
			return 1;
		}
		else if(this.hp < m.getHp()){
			return -1;
		}
		else{
			return 0;
		}
	}

	public String toString() {
		return "Ägare: " + this.getOwner() + " Motorns hästkrafter: " + this.hp;
	}
}
