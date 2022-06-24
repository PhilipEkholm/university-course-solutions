package laboration12;
import java.util.Comparator;
import java.text.*;

public class AlphabeticalOrder implements Comparator{
	public int compare(Object obj1, Object obj2){
		Population 	country1 = (Population)obj1,
					country2 = (Population)obj2;
		Collator coll = Collator.getInstance();
		
		String 	name1 = country1.getCountry(),
				name2 = country2.getCountry();
		
		if(coll.compare(name1, name2) < 0){
			return -1;
		}
		else if(coll.compare(name1, name2) > 0){
			return 1;
		}
		
		return 0;
	}
}
