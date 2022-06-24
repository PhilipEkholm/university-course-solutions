package laboration8;

public class RealEstate {
	private String name; 
	private Building building;
	private Address address;
	
	public RealEstate(String name, Building building, Address address){
		this.name = name;
		this.building = building;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Building getBuilding() {
		return building;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Fastighet: " + this.name + "\n" + this.building.toString() + "\n" + this.address.toString();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static void main(String[] args) {
		Building building = new Building(5, 1350);
		Address address = new Address("Nygatan 4", 12345,
		"Ystad");
		RealEstate re = new RealEstate("Kvarnen 4", building, address);
		System.out.println(re.getName());
		System.out.println(re.getBuilding().toString()); // toString i Buildingklassen
		System.out.println(re.getAddress().toString()); // toString i Addressklassen
		System.out.println("---------------------------");
		System.out.println(re.toString());
		System.out.println("---------------------------");
		re.setName("Skorpionen 17");
		re.setBuilding( new Building(6, 1470) );
		re.setAddress( new Address("Nygatan 4", 55555, "Ystad") );
		System.out.println(re.toString());
	}
}
