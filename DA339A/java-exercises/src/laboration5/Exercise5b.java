package laboration5;

/**
 * Träna while-loop
 * @author Rolf Axelsson
 */
public class Exercise5b {
    public void exercise5b0() {
        int i = 0;
        while( i < 10 ) {
            System.out.print( 'A' + " ");
            i++;
        }
    }
    
    public void exercise5b1(){
    	int i = 0;
    	while(i < 10){
    		System.out.print("h ");
    		i++;
    	}
    }
    
    public void exercise5b2(){
    	int i = 0;
    	while(i < 10){
    		System.out.print(i + " ");
    		i++;
    	}
    }
    
    public void exercise5b3(){
    	int i = 1;
    	while(i <= 10){
    		System.out.print(i + " ");
    		i++;
    	}
    }
    
    public void exercise5b4(){
    	int i = 9;
    	while(i >= 0){
    		System.out.print(i + " ");
    		i--;
    	}
    }
    
    public void exercise5b5(){
    	int i = 0;
    	while(i <= 8){
    		System.out.print(i + " ");
    		i+=2;
    	}
    }
    
    public void exercise5b6(){
    	int i = 30;
    	while(i >= 10){
    		System.out.print(i + " ");
    		i-=5;
    	}
    }
    
    public static void main(String[] args) {
        Exercise5b e5b = new Exercise5b();
        e5b.exercise5b0();
        System.out.println();
        e5b.exercise5b1();
        System.out.println();
        e5b.exercise5b2();
        System.out.println();
        e5b.exercise5b3();
        System.out.println();
        e5b.exercise5b4();
        System.out.println();
        e5b.exercise5b5();
        System.out.println();
        e5b.exercise5b6();
    }
}
