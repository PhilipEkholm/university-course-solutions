package laboration15;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel;

public class Uppg8 extends JPanel{

    private void doDrawing(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Random rand = new Random();
        
        //Första två
        Paint paint = new GradientPaint(20, 20, Color.CYAN, 200, 200, Color.MAGENTA);
        g2.setPaint(paint);
        g2.fill(new Rectangle2D.Double(20, 20, 200, 200));
        g2.fill(new Rectangle2D.Double(240, 20, 200, 200));
        
        //Nere till vänster
        paint = new GradientPaint(20, 240, Color.CYAN, 200, 240, Color.MAGENTA);
        g2.setPaint(paint);
        g2.fill(new Rectangle2D.Double(20, 240, 200, 200));
        
        //Uppe till höger
        paint = new GradientPaint(460, 20, Color.CYAN, 250, 240, Color.MAGENTA);
        g2.setPaint(paint);
        g2.fill(new Rectangle2D.Double(460, 20, 200, 200));
        
        //Mitten
        paint = new GradientPaint(240, 240, Color.CYAN, 300, 300, Color.MAGENTA, true);
        g2.setPaint(paint);
        g2.fill(new Rectangle2D.Double(240, 240, 200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
