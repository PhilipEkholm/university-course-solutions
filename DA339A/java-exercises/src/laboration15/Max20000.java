package laboration15;

public class Max20000 implements WageFilter{

	@Override
	public boolean accept(WageEmployee employed) {
		double wage = employed.wage();
		return (wage <= 20000);
	}
}
