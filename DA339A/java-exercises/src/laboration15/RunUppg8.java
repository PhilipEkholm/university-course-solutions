package laboration15;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class RunUppg8 extends JFrame{
	private static final long serialVersionUID = 1L;

	public RunUppg8() {
        add(new Uppg8());

        setTitle("Uppg8");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                RunUppg8 ex = new RunUppg8();
                ex.setVisible(true);
            }
        });
    }
}
