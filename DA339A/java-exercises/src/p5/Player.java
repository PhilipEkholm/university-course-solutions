package p5;

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int throwDice();

    private void getRekt(){
    	System.out.println("GeT_RekT");
    }
}
