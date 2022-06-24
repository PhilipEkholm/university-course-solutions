package laboration4;
import javax.swing.*;

public class Program4e {
   public void customer() {
      double price, fromCustomer, back;
      boolean member;
        
      price = Double.parseDouble( JOptionPane.showInputDialog("Ange varans pris") );
      fromCustomer = Double.parseDouble( JOptionPane.showInputDialog("Hur mycket betalar kunden?") );
      
      // medlem får värdet true vid klick på 'Ja', och false vid klick på 'Nej' / stängning av dialog
      member = JOptionPane.showConfirmDialog( null, "Är kunden medlem?", "MEDLEM", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION;

      // om medlem så ska nytt pris beräknas här: price = 0.9 * price; // 10% rabatt
      back = fromCustomer-price;
      
      if(member){
    	  JOptionPane.showMessageDialog( null, "Pengar tillbaka: " + back * 1.10 + " kr" );
      }
      else{
    	  JOptionPane.showMessageDialog( null, "Pengar tillbaka: " + back + " kr" );
      }
   }

   public static void main(String[] args) {
      Program4e p7e = new Program4e();
      p7e.customer();
   }
}
