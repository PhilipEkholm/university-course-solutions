package laboration13;

public abstract class Vehicle {
	private String owner;
	
	public Vehicle(){
		this.owner = "Okänd ägare";
	}
	
	public Vehicle(String owner){
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String toString(){
		return "Ägare: " + this.owner;
	}
}
