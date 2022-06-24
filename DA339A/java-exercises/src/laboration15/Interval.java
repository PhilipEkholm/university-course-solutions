package laboration15;

public class Interval implements WageFilter{
	private double min, max;
	
	public Interval(double min, double max){
		if(min > max){
			double temp = max;
			max = min;
			min = temp;
		}
		
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean accept(WageEmployee employed) {
		double wage = employed.wage();
		
		return (wage >= this.min && wage <= this.max);
	}
	
}
