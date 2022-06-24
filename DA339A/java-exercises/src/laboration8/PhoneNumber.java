package laboration8;

public class PhoneNumber {
	private String home, work, mobile;
	
	public PhoneNumber(String home, String work, String mobile){
		this.home = home;
		this.work = work;
		this.mobile = mobile;
	}
	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Home: " + home + "\nWork: " + work + "\nMobile: " + mobile;
	}
}
