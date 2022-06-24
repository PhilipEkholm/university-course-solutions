package laboration14;

public class RunFullTime {
	public static void main(String[] args) {
		FullTime employee = new FullTime( 19938278, 21500 ); 
		
		System.out.println( employee.toString()); 
		System.out.println( "Anställd med id " + employee.getId() + " har månadslönen " + employee.getWage() + " kr"); 
		employee.setWage( 22250 ); 
		System.out.println( "Lön denna månad: " + employee.wage() + " kr");
	}
}
