package laboration12;

public class Population implements Comparable{
    private String country;
    private int population;
    
    public Population( String country, int population ) {
        this.country = country;
        this.population = population;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public long getPopulation() {
        return this.population;
    }
    
    public String toString() {
        return String.format( "%-30s%15d", this.country, this.population );
    }

	@Override
	public int compareTo(Object obj) {
		Population country = (Population)obj;
		long inhabitants = country.getPopulation();

		if(this.population < inhabitants){
			return -1;
		}
		else if(this.population > inhabitants){
			return 1;
		}
		return 0;
	}
}