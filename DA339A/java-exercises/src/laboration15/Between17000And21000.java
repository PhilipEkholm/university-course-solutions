package laboration15;

public class Between17000And21000 implements WageFilter{

	@Override
	public boolean accept(WageEmployee employed) {
		double wage = employed.wage();
		return (wage >= 17000 && wage <= 21000);
	}

}
