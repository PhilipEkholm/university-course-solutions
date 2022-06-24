package laboration5;

/**
 * Träna for-loop 
 * @author Rolf Axelsson
 */
public class Exercise5a {
    public void exercise5a0() {
        for( int i = 0 ; i < 10 ; i++ ) {
            System.out.print( 'A' + " ");
        }
    }
    
    public void exercise5a1(){
    	String rowOfH = "";
    	
    	for(int i = 0; i < 10; i++){
    		rowOfH += "h ";
    	}
    	
    	System.out.println(rowOfH);
    }
    
    public void exercise5a2(){
    	for(int i = 0; i < 10; i++){
    		System.out.print(i + " ");
    	}
    }
    
    public void exercise5a3(){
    	for(int i = 1; i <= 10; i++){
    		System.out.print(i + " ");
    	}
    }
    
    public void exercise5a4(){
    	for(int i = 9; i >= 0; i--){
    		System.out.print(i + " ");
    	}
    }
    
    public void exercise5a5(){
    	for(int i = 0; i <= 8; i+=2){
    		System.out.print(i + " ");
    	}
    }
    
    public void exercise5a6(){
    	for(int i = 30; i >= 10; i-=5){
    		System.out.print(i + " ");
    	}
    }

    public static void main(String[] args) {
          Exercise5a e5a = new Exercise5a();
          e5a.exercise5a0();
       System.out.println();
        e5a.exercise5a1();
        System.out.println();
        e5a.exercise5a2();
        System.out.println();
        e5a.exercise5a3();
        System.out.println();
        e5a.exercise5a4();
        System.out.println();
        e5a.exercise5a5();
        System.out.println();
        e5a.exercise5a6();
    }
}
