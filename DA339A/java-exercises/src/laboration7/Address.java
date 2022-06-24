package laboration7;

public class Address {
	private String 	street,
					town;
	private int postalCode;
	
	public Address(String street, int postalCode, String town){
		this.street = street;
		this.postalCode = postalCode;
		this.town = town;
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
		return "Address [street=" + street + ", town=" + town + ", postalCode=" + postalCode + "]";
	}
}








