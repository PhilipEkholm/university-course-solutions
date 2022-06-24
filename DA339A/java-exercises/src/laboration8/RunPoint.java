package laboration8;

public class RunPoint {
	public static void main(String[] args) {
		Point p1;
		p1 = new Point( 10, 12 );
		Circle c1 = new Circle( 3.5, p1 );
		System.out.println( "p1 = " + p1.toString() );
		System.out.println( "c1 = " + c1.toString() );
		System.out.println("------------------------");
		p1.setX( 444 );
		System.out.println( "p1 = " + p1.toString() );
		System.out.println( "c1 = " + c1.toString() );
	}
}
