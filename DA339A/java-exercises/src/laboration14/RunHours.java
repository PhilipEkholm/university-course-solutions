package laboration14;

public class RunHours {
	public static void main(String[] args) {
		Hours employee = new Hours( 17233534, 95.0 ); 
		employee.setHours( 128 ); 
		System.out.println( employee.toString() ); 
		System.out.println( "Anställd med id " + employee.getId() + " har arbetat " + employee.getHours() + " timmar till lönen " + employee.getHourlyWage() + " kr" ); 
		employee.setHourlyWage( 98.50 ); System.out.println( "Lön denna månad: " + employee.wage() + " kr");
	}
}
