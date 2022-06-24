package laboration4;

import javax.swing.JOptionPane;

public class Program4k {
	public void customer(){
		double price, fromCustomer, back;
	      boolean member;
	        
	      price = Double.parseDouble( JOptionPane.showInputDialog("Ange varans pris") );
	      fromCustomer = Double.parseDouble( JOptionPane.showInputDialog("Hur mycket betalar kunden?") );
	      
	      // medlem får värdet true vid klick på 'Ja', och false vid klick på 'Nej' / stängning av dialog
	      member = JOptionPane.showConfirmDialog( null, "Är kunden medlem?", "MEDLEM", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION;
	      
	      if(price > 5000.00 && price < 9999.99){
	    	  price *= 0.95;
	      }
	      else if(price >= 10000.00){
	    	  price *= 0.9;
	      }
	      if(member){
	    	  price *= 0.9;
	      }
	      
	      back = fromCustomer-price;
	      
	      JOptionPane.showMessageDialog( null, "Pengar tillbaka: " + Math.round(back) + " kr" );
	}
	
	public static void main(String[] args) {
		Program4k  prg = new Program4k();
	      prg.customer();
	}
}
