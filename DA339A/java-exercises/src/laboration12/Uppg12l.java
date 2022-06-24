package laboration12;
import java.awt.Color;
import java.util.*;

public class Uppg12l {
	public static void main(String[] args) {
		Color[] socks = {Color.RED, Color.BLACK, Color.GREEN, Color.BLACK, Color.CYAN, 
		Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.RED};
		
		Arrays.sort(socks, new SortSocks());
		for(int i = 0; i < socks.length; i++){
			System.out.println(socks[i]);
		}
	}
}
