package laboration7;
import javax.swing.JOptionPane;

public class AddressTest {
    public void test() {
        Address addr = new Address("Nygatan 3", 26344, "Eslöv");
        String newStreet, newTown;
        int newPostalCode;
        
        JOptionPane.showMessageDialog(null,addr.toString());
        
        newStreet = JOptionPane.showInputDialog("Ange ny gata");
        newPostalCode = Integer.parseInt(JOptionPane.showInputDialog("Ange nytt postnummer"));
        newTown = JOptionPane.showInputDialog("Ange ny postadress");
        
        addr = new Address(newStreet, newPostalCode, newTown);
        JOptionPane.showMessageDialog(null,addr.toString());
    }
    
    public static void main(String[] args) {
        AddressTest prog = new AddressTest();
        prog.test();
    }
}
