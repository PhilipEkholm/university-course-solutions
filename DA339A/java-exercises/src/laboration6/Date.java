package laboration6;

import javax.swing.JOptionPane;

public class Date {
	private int year, month, day;

	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void showDate() {
		JOptionPane.showMessageDialog(null, day + "/" + month + "-" + year);
	}
}
