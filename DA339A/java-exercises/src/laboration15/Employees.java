package laboration15;

public class Employees {
    public void program() {
        Commission cWage;
        WageEmployee[] employees = new WageEmployee[ 3 ];
        employees[ 0 ] = new FullTime( 19938278, 21500 );
        employees[ 1 ] = new Commission( 19278865, 0.10 );
        cWage = (Commission)employees[ 1 ];
        cWage.setSales( 208000 );
        employees[ 2 ] = new Hours( 17233534, 95.0 );
        (( Hours )employees[ 2 ]).setHours( 128 );
        for( int i = 0; i < employees.length; i++ ) {
            System.out.println( employees[ i ] );
        }
    }
    public static void main( String[] args ) {
        Employees prog = new Employees();
        prog.program();
    }
}
