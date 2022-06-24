package laboration14;

public class Hours extends Wage{
	private double 	hourlyWage,
					hours;
	
	public Hours(long id, double hourlyWage){
		super(id);
		this.hourlyWage = hourlyWage;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
	@Override
	public double wage(){
		return this.hourlyWage * this.hours;
	}
}
