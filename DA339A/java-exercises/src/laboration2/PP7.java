package laboration2;

import javax.swing.JOptionPane;

public class PP7 {
	public static void main(String[] args){
		int timeInput = Integer.parseInt(JOptionPane.showInputDialog("Ange antal timmar")),
			hours,
			minutes,
			seconds;
		final int hoursToSeconds = 3600;
		
		hours = Math.round(timeInput/hoursToSeconds);
		timeInput %= hoursToSeconds;
		minutes = Math.round(timeInput/60);
		timeInput %= 60;
		seconds = timeInput;
		
		System.out.println(hours + "hours, " + minutes + "minutes, " + seconds + "seconds");
	}
}
