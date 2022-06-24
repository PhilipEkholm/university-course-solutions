package ws5;

public class Uppg1Betyg {
	public static void main(String[] args) {
		String[][] grades = {
				{"Adam", "Ason", "661122", "35", "U"},
				{"Beata", "Beson", "770111", "38", "G"},
				{"Calle", "Ceson", "880222", "23", "U"},
				{"Dorotea", "Deson", "990311", "44", "VG"},
				{"Eivar", "Eson", "550423", "40", "G"}
			};
			
			for(int i = 0; i < grades.length; i++){
				for(int j = 0; j < grades[i].length; j++){
					System.out.print(grades[i][j] + " ");
				}
				System.out.println();
			}
	}
}
