package laboration5;

/**
 * Träna do-while-loop
 * @author Rolf Axelsson
 */
public class Exercise5c {
    public void exercise5c0() {
        int i = 0;
        do {
            System.out.print( 'A' + " ");
            i++;
        } while( i < 10 );
    }
    
    public void exercise5c1(){
    	int i = 0;
    	
    	do{
    		System.out.print("h ");
    		i++;
    	}while(i < 10);
    }
   
    public void exercise5c2(){
    	int i = 0;
    	
    	do{
    		System.out.print(i + " ");
    		i++;
    	}while(i < 10);
    }
    
    public void exercise5c3(){
    	int i = 1;
    	
    	do{
    		System.out.print(i + " ");
    		i++;
    	}while(i <= 10);
    }
    
    public void exercise5c4(){
    	int i = 9;
    	
    	do{
    		System.out.print(i + " ");
    		i--;
    	}while(i >= 0);
    }
    
    public void exercise5c5(){
    	int i = 0;
    	
    	do{
    		System.out.print(i + " ");
    		i+=2;
    	}while(i <= 8);
    }
    
    public void exercise5c6(){
    	int i = 30;
    	
    	do{
    		System.out.print(i + " ");
    		i-=5;
    	}while(i >= 10);
    }
    
    public static void main(String[] args) {
        Exercise5c e5c = new Exercise5c();
        e5c.exercise5c0();
        System.out.println();
        e5c.exercise5c1();
        System.out.println();
        e5c.exercise5c2();
        System.out.println();
        e5c.exercise5c3();
        System.out.println();
        e5c.exercise5c4();
        System.out.println();
        e5c.exercise5c5();
        System.out.println();
        e5c.exercise5c6();
    }
}
