package laboration8;

public class Building {
	private int floors,
				area;
	
	public Building(int floors, int area){
		this.floors = floors;
		this.area = area;
	}

	public int getFloors() {
		return floors;
	}

	public int getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "Byggnad: " + this.getFloors() + " våningar, yta " +  this.getArea() + " kvm";
	}
}
