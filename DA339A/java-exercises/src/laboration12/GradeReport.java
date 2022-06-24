package laboration12;

import javax.swing.JOptionPane;

public class GradeReport {
	private String[] subjects = {
		"Matematik",
		"Svenska",
		"Engelska",
		"Idrott",
		"Bild",
		"Fysik",
		"Biologi",
		"Kemi",
		"Historia",
		"Geografi",
		"Samhällskunskap",
		"Religionskunskap",
	},
		grades = new String[subjects.length];;
		
	public void setGrades(){
		for(int i = 0; i < subjects.length; i++){
			String mark = "";
			
			do{
				mark = JOptionPane.showInputDialog("Ange betyg i " + subjects[i]);
			}
			while(!(mark.equals("IG") || mark.equals("G") || mark.equals("VG") || mark.equals("MVG")));
			
			this.grades[i] = mark;
		}
	}
	
	public void statistics(){
		String res = "Betygsstatistik \n";
		
		int countIG = 0,
			countG = 0,
			countVG = 0,
			countMVG = 0;
		
		for(int i = 0; i < grades.length; i++){
			if(grades[i] == "IG"){
				countIG++;
			}
			else if(grades[i].equals("G")){
				countG++;
			}
			else if(grades[i].equals("VG")){
				countVG++;
			}
			else if(grades[i].equals("MVG")){
				countMVG++;
			}
		}
		
		res += "IG: " + countIG + "\n";
		res += "G: " + countG + "\n";
		res += "VG: " + countVG + "\n";
		res += "MVG: " + countMVG + "\n";
		res += "Meritvärde: " + this.calculateMerit(countG, countVG, countMVG) + "poäng";
		
		JOptionPane.showMessageDialog(null, res);
	}
	
	private int calculateMerit(int g, int vg, int mvg){
		g = 10 * g;
		vg = 10 * vg;
		mvg = 20 * mvg;
		
		int value = g + vg + mvg;
		return value;
	}
	
	public static void main(String[] args){
		GradeReport prog = new GradeReport();
		prog.setGrades();
		prog.statistics();
	}
}
