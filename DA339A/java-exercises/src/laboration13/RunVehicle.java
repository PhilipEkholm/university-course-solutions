package laboration13;

public class RunVehicle {
	public static void main(String[] args) {
		Car car1 = new Car("Doris Bengtsson",80,"FGT 450");     
		Motorcycle mc = new Motorcycle("Klas Bengtsson",70,"KKI 333");     
		Car car2 = new Car();     
		car2.setOwner("Fredrik Hansson");     
		car2.setHp(100);     
		car2.setRegNumber("HHH 778");     
		System.out.println(car1.toString());     
		System.out.println(mc);
		System.out.println(car2);
	}
}
