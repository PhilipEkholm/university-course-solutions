package laboration7;

/**
 * Programmet använder ett objekt av typen Circle. Men på felaktigt sätt. Rätta
 * till felen i programmet.
 * 
 * @author Rolf Axelsson
 */
public class CircleTest {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.setRadius(23.2);// setRadius eller initiera via konstruktor
		System.out.println("CIRKEL med radie = " + c.getRadius()); // getRadius
		System.out.println("CIRKEL med area = " + Math.PI * c.getRadius() * c.getRadius());

		c.setRadius(c.getRadius() + 5.7);
		System.out.println("CIRCLE, radius = " + c.getRadius());
	}
}