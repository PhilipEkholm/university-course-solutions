package laboration3;
import javax.swing.*;

public class Guess {
    public int seeExpressionAndGuess(int rnd) {
        int res = (rnd-3)*197, guess;
        String message = "GISSA VÄRDET PÅ slump!!!\n" +
                "\n(slump-3)*197=" + res + "\n" +
                "(197+slump-69)/5="+((197+rnd-69)/5.0)+ "\n\n" +
                "Ange gissning i intervallet [11-49]";
        guess = Integer.parseInt( JOptionPane.showInputDialog( message ) );
        return guess;
    }
    
    public void result(int guess, int rnd) {
        String res = "BEDÖMNING: ";
        if(guess==rnd) {
            res += "Suverän gissning! Du är bäst";
        } else if(Math.abs(guess-rnd)<=4) {
            res += "Din gissning var bra. Rätt är "+rnd;
        } else {
            res += "Ingen vidare gissning. Rätt är "+rnd;
        }
        res += "\n\nKör gärna programmet en gång till";
        JOptionPane.showMessageDialog( null, res );
    }
    
    public void makeAGuess() {
        int guess;
        int rnd = (int)(Math.random()*39)+11;  // Slumptal 11-49
        guess = seeExpressionAndGuess(rnd);
        result(guess, rnd);
    }
    
    public static void main(String[] args) {
        Guess prog = new Guess();
        prog.makeAGuess();
    }
}

