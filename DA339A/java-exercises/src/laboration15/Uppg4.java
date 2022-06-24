package laboration15; 
import java.awt.*;
import javax.swing.*;
import java.util.Random;

class Uppg4 extends JPanel {
	private int lines;
	
	public Uppg4(int lines){
		this.lines = lines;
	}

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Random rand = new Random();
        
        for(int i = 0; i < this.lines; i++){
        	g2d.setStroke(new BasicStroke(rand.nextInt(17) + 4));
        	g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        	g2d.drawLine(rand.nextInt(790), rand.nextInt(590), rand.nextInt(790), rand.nextInt(590));
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}


























