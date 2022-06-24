package laboration12;  

public class Uppg12b {          
	public void printCountries( Population[] array ) {         
		for(Population object: array){
			System.out.println(object);
		}
	}
	
	public void moreThanHundredMillions(Population[] array) {
		for(Population object: array){
			if(object.getPopulation() >= 100000000){
				System.out.println(object);
			}
		}
	}
		
	public void startsWithM(Population[] array) {
		for(Population object: array){
			if(object.getCountry().startsWith("M")){
				System.out.println(object);
			}
		}
	}          
	
	public void eightToTenMillions( Population[] array ) {        
		for(Population object: array){
			if(object.getPopulation() >= 8000000 && object.getPopulation() <= 10000000){
				System.out.println(object);
			}
		}
	}         
	
	public void program() {        
		Population[]countries = Populations.readPopulations( "files/befolkning.txt" );
		
		printCountries(countries);
		moreThanHundredMillions(countries);
		startsWithM(countries);
		eightToTenMillions(countries);             
	} 
	
	public static void main( String[] args ) {         
		Uppg12b app = new Uppg12b();         
		app.program();     
	}
}