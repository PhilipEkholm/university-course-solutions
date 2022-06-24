package laboration12;
import java.util.Comparator;

public class BalanceDescending implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		BankAccount acc1 = (BankAccount)obj1,
					acc2 = (BankAccount)obj2;
		
		double balance1 = acc1.getBalance();
		double balance2 = acc2.getBalance();
		
		if(balance1 < balance2){
			return 1;
		}
		else if(balance1 > balance2){
			return -1;
		}
		
		return 0;
	}

}
