package laboration12;
import java.text.Collator;
import java.util.*;

public class EmployeeSort implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		Collator coll = Collator.getInstance();
		
		Employee 	emp1 = (Employee)obj1,
					emp2 = (Employee)obj2;
		if(coll.compare(emp1.getEmployer(), emp2.getEmployer()) < 0){
			return -1;
		}
		else if(coll.compare(emp1.getEmployer(), emp2.getEmployer()) > 0){
			return 1;
		}
		
		return 0;
	}

}
