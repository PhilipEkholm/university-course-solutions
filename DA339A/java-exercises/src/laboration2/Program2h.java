package laboration2;

public class Program2h {

    public void country() {
        System.out.println("Land: Sverige");
    }

    public void residents() {
        System.out.println("Ca 9 miljoner invånare");
    }

    public void bigCities() {
        System.out.println("Tre stora städer:");
        System.out.println("Stockholm");
        System.out.println("Göteborg");
        System.out.println("Malmö");
    }
    
    public void message(){
    	Program2h prg = new Program2h();
    	
    	prg.country();
    	prg.residents();
    	prg.bigCities();
    }

    public static void main( String[] args ) {
    	Program2h prg = new Program2h();
    	prg.message();
    }
}
