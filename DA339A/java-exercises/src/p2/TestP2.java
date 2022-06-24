package p2;
import java.lang.reflect.*;
import javax.swing.*;

public class TestP2 {
    public void runMain(String classname) throws Exception {
        Class cls = Class.forName(classname);
        Method method = cls.getDeclaredMethod("main",new Class[]{String[].class});
        method.invoke(null,new Object[]{new String[]{"dummy"}}); 
    }
    
    public void programLoop() {
        int choice = -1;
        String menu = "Välj den metod som ska anropas / det program som ska exekveras:\n\n" +
                "1. Painting / Exercise2a\n" +
                "2. Time / Exersice2b\n" +
                "3. Race\n" +
                "0. Avsluta programmet\n\n" +
                "Ange ditt val";
        do {
            try {
                choice = Integer.parseInt( JOptionPane.showInputDialog(menu) );
                switch(choice) {
                    case 1 : runMain("p2.Exercise2a"); break;
                    case 2 : runMain("p2.Exercise2b"); break;
                    case 3 : runMain("p2.StartRace"); break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }while(choice!=0);
        System.exit(0);
    }
    
    public static void main(String[] args) {
        TestP2 prog = new TestP2();
        prog.programLoop();
    }
}
