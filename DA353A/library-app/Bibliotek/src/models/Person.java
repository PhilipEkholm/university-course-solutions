package models;

/**
* 	Person
*
* 	Person is a class for storing common information about
* 	people (a.k.a. Lantagare).
*/

public class Person {
	private String name,
	personnr,
	phoneNumber;

	public Person(String personnr, String name, String phoneNumber){
		this.name = name;
		this.personnr = personnr;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getPersonnr() {
		return personnr;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString(){
		return this.getName() + ", " + this.getPersonnr() + ", " + this.getPhoneNumber();
	}
	
	//Persons equal if personnr matches
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Person){
			Person p = (Person)obj;
			
			return p.personnr.equals(this.personnr);
		}
		
		return false;
	}
}








