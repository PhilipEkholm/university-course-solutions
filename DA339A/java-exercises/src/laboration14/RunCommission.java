package laboration14;

public class RunCommission {
	public static void main(String[] args) {
		Commission employee = new Commission( 19278865, 0.10 ); 
		
		employee.setSales( 208000 ); 
		System.out.println( employee.toString() ); 
		System.out.println( "Anställd med id " + employee.getId() + " har sålt för " + employee.getSales()
		+ " kr till provisionen " + employee.getRate()*100 + " %" ); 
		
		employee.setRate( 0.12 ); 
		System.out.println( "Lön denna månad: " + employee.wage() + " kr");
	}
}
