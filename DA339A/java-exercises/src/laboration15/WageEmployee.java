package laboration15;

public abstract class WageEmployee implements Comparable {
    private long id;
    
    public WageEmployee( long id ) {
        this.id = id;
    }
    
    public long getId() {
        return this.id;
    }
    
    public String toString() {
        return "Id: " + this.id + ", lön denna månad: " + wage() + " kr";
    }
    
    public abstract double wage(); 

    public int compareTo( Object obj ) {
    	WageEmployee employed = (WageEmployee)obj;
    	return (int)(this.wage() - employed.wage());
    }
}
