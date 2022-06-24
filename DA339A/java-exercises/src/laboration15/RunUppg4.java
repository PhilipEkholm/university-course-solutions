package laboration15;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class RunUppg4 extends JFrame {
	private static final long serialVersionUID = 1L;

	public RunUppg4() {
        add(new Uppg4(20));

        setTitle("Lines");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                RunUppg4 ex = new RunUppg4();
                ex.setVisible(true);
            }
        });
    }
}