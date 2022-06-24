package laboration15;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class RunWageEmployee {
	public static void main(String[] args) {
		WageEmployee[] employees = { 
			new FullTime(19938278, 21500),         
			new Commission(19278865, 0.10), 
			new Hours(17233534, 95.0) 
		}; 
		
		String res = "FÖRE SORTERING\n"; ((Commission) employees[1]).setSales(208000); 
		((Hours) employees[2]).setHours(128); 
		
		for (int i = 0; i < employees.length; i++) {     
			res += employees[i].toString() + "\n"; 
		} 
			
		Arrays.sort(employees); res += "------------------------------------\n"; 
		res += "EFTER SORTERING\n"; 
		for (int i = 0; i < employees.length; i++) {     
			res += employees[i].toString() + "\n"; 
		} 
		
		JOptionPane.showMessageDialog(null, res);
	}
}
