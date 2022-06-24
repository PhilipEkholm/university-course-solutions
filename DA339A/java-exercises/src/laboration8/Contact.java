package laboration8;

public class Contact {
	private String name;
	private PhoneNumber phone;
	
	public Contact(String name, String home, String work, String mobile){
		this.name = name;
		phone = new PhoneNumber(home, work, mobile);
	}

	public String getName() {
		return name;
	}
	
	public String getHome(){
		return this.phone.getHome();
	}
	
	public String getMobile(){
		return this.phone.getMobile();
	}
	
	public String getWork(){
		return this.phone.getWork();
	}
	
	public String toString(){
		return "Contact: " + this.name + "\n" + this.phone.toString();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setHome(String home){
		this.phone.setHome(home);
	}
	
	public void setWork(String work){
		this.phone.setWork(work);
	}
	
	public void setMobile(String mobile){
		this.phone.setMobile(mobile);
	}
}

















