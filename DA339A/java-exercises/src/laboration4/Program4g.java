package laboration4;
import javax.swing.*;

public class Program4g {
	
    public void exercise() {
        String name;
        int nbr1, nbr2;
        System.out.println();
        name = JOptionPane.showInputDialog("Ange ditt namn");
        nbr1 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal"));
        nbr2 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal till"));

        System.out.println();
        System.out.println(name + ", så här blir det: ");
        System.out.println("Addition:                 " + nbr1 + "+" + nbr2
                + "=" + (nbr1 + nbr2));
        System.out.println("Subtraktion:              " + nbr1 + "-" + nbr2
                + "=" + (nbr1 - nbr2));
        System.out.println("Multiplikation:           " + nbr1 + "*" + nbr2
                + "=" + nbr1 * nbr2);
        
        if(nbr2 != 0){
        	System.out.println("Division:                 " + nbr1 + "/" + nbr2
                    + "=" + (double) nbr1 / nbr2);
        	System.out.println("Heltalsdivision:          " + nbr1 + "/" + nbr2
                    + "=" + nbr1 / nbr2);
            System.out.println("Rest vid heltalsdivision: " + nbr1 + "%" + nbr2
                    + "=" + nbr1 % nbr2);
        }else{
        	System.out.println("Kan inte dela med 0!");
        }
    }

    public static void main(String[] args) {
        Program4g p7g = new Program4g();
        p7g.exercise();
    }
}
