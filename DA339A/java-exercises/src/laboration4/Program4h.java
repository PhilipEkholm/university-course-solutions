package laboration4;

public class Program4h {
	public static void main(String[] args) {
		int a = 52,
			b = 41,
			c = 10,
			biggestNumber;
		String res = "Något gick fel";
		
		biggestNumber = Math.max(a, b);
		biggestNumber = Math.max(biggestNumber, c);
		
		System.out.println("Största numret: " + biggestNumber);
	}
}
