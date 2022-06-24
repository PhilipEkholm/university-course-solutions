package p2;

import java.awt.Color;
import gu2.PaintWindow_GU2;
import javax.swing.ImageIcon;

public class StartRace {
    public static void main(String[] args) { 
        PaintWindow_GU2 window = new PaintWindow_GU2(1000, 600,"P2",Color.GREEN);
        window.clearAll();
        
        Car c1 = new Car(new ImageIcon("images/CarRed.GIF"));
        Car c2 = new Car(new ImageIcon("images/CarBlue.GIF"));
        Race race = new Race(window,c1,c2);
        race.action();
        
        
        if(args.length>0) {
            PaintWindow_GU2.pause(2000);
            window.dispose();
        }
    }
}
