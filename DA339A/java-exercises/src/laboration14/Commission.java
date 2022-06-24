package laboration14;

public class Commission extends Wage{
	private double rate, sales;
	
	public Commission(long id, double rate){
		super(id);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}
	
	@Override
	public double wage(){
		return rate * sales;
	}
}
