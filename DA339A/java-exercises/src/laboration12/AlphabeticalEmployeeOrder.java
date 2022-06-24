package laboration12;
import java.text.Collator;
import java.util.Comparator;

public class AlphabeticalEmployeeOrder implements Comparator{
	@Override
	public int compare(Object obj1, Object obj2) {
		Employee emp1 = (Employee)obj1,
				emp2 = (Employee)obj2;
		
		Collator coll = Collator.getInstance();
		if(coll.compare(emp1.getName(), emp2.getName()) < 0){
			return -1;
		}
		else if(coll.compare(emp1.getName(), emp2.getName()) > 0){
			return 1;
		}
		
		return 0;
	}
}
