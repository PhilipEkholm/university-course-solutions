package laboration15;
import java.awt.Color;
import javax.swing.*;

public class IconWindow {
    public static void showIcon(final Icon icon) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("IconWindow");
                frame.getContentPane().setBackground(Color.WHITE);
                frame.setResizable(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JLabel(icon));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

