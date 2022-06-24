package laboration8;

public class Address {
	private String 	street,
					town;
	private int postalCode;
	
	public Address(String street, int postalCode, String town){
		this.street = street;
		this.town = town;
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public String getTown() {
		return town;
	}

	public int getPostalCode() {
		return postalCode;
	}

	@Override
	public String toString() {
		return "Adress: " + this.getStreet() + ", " + this.getPostalCode() + " " + this.getTown();
	}
	
}
