package laboration2;
import javax.swing.*;

public class Program2d {
    public void nameAndJava() {
        String str1 = "födelsedag", str2 = "gratulationer",
               str3 = "på", str4 = "Hjärtliga", str5 = "!";
        int age = Integer.parseInt(JOptionPane.showInputDialog( "Ange din ålder" ));
        String res = str4 + " " + str2 + " " + str3 + " " + str1 + " nummer " + age + str5;

        JOptionPane.showMessageDialog(null, res);
    }
}
