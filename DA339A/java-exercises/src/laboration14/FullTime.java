package laboration14;

public class FullTime extends Wage{
	private double wage;
	
	public FullTime(long id, double wage){
		super(id);
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public double wage() {
		return wage;
	}

}































