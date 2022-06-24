package laboration3;
import javax.swing.*;
import java.util.Calendar;

public class Program3b {
	
	public String date(){
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH),
			month = cal.get(Calendar.MONTH) + 1,
			year = cal.get(Calendar.YEAR);
		
		return "Dagens datum: " + dayOfMonth + "/" + month + "-" + year;
	}
	
	public String time(){
		Calendar cal = Calendar.getInstance();
		int hours = cal.get(Calendar.HOUR),
			minutes = cal.get(Calendar.MINUTE),
			seconds = cal.get(Calendar.SECOND);
		return "Klockan är: " + hours + ":" + minutes + ":" + seconds;
	}
	
	public void dateAndTime(){
		Program3b prg = new Program3b();
		String result = prg.date() + "\n" + prg.time();
		JOptionPane.showMessageDialog(null, result);
	}
	
	public static void main(String[] args) {
		Program3b prg = new Program3b();
		prg.dateAndTime();
	}
}
