package laboration6;

public class EmployeeTest {
    public static void main( String[] args ) {
        Employee empl = new Employee();
        
        empl.setName( "Ergil Tuveberg" );
        empl.setEmployer( "Renlighet AB" );
        empl.setWage( 27000 );
        
        empl.info();
    }
}
