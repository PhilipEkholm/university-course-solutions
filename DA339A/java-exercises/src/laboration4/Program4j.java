package laboration4;
import java.awt.*; // Color, Font
import java.util.Calendar;
import javax.swing.ImageIcon;

import paintwindow.PaintWindow;

public class Program4j {

    public void showImage() {
        ImageIcon spring = new ImageIcon("images/Spring.jpg");
        ImageIcon summer = new ImageIcon("images/Summer.jpg");
        ImageIcon autumn = new ImageIcon("images/Autumn.jpg");
        ImageIcon winter = new ImageIcon("images/Winter.jpg");
        Calendar cal = Calendar.getInstance();
        ImageIcon image=null;
        String season = "";
        Font customFont = new Font("Verdana", Font.BOLD, 18);

        int month = cal.get(Calendar.MONTH) + 1;
        System.out.println(month);
        switch (month) {
            case 1: case 2: case 12:
                image = winter;
                season = "winter";
                break;
            case 3: case 4: case 5:
            	image = spring;
            	season = "string";
            	break;
            case 6: case 7: case 8:
            	season = "summer";
            	image = summer;
            case 9: case 10: case 11:
            	image = autumn;
            	season = "autumn";
            	break;
        }
    }

    public static void main(String[] args) {
        Program4j prog = new Program4j();
        prog.showImage();
    }
}
