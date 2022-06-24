package laboration15;

public class Uppg7 implements WageFilter{

	@Override
	public boolean accept(WageEmployee employed) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public WageEmployee[] collect(WageEmployee[] employees, WageFilter filter){
		int count = 0;
		
		for(int i = 0; i < employees.length; i++){
			if(employees[i].compareTo(filter) > 0){
				count++;
			}
		}
		
		WageEmployee[] newEmps = new WageEmployee[count];
		
		int k = 0;
		for(int i = 0; i < employees.length; i++){
			if(employees[i].compareTo(filter) > 0){
				newEmps[k] = employees[i];
				k++;
			}
		}
		
		return newEmps;
	}
	
}
