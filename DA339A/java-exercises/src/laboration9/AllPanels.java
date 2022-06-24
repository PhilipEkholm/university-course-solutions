package laboration9;
import java.awt.*;
import javax.swing.*;

public class AllPanels extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public AllPanels(){
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(600, 500));
		
		this.add(new CalcPanel());
		this.add(new TemperatureUnitConverterPanel());
		this.add(new ColorPanel());
		this.add(new TransportPanel());
	}
}
