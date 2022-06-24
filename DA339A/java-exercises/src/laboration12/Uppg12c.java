package laboration12;

public class Uppg12c{
	
	private int lessThanOneMillion(Population[] array){
		int n = 0;
		
		for(Population object: array){
			if(object.getPopulation() < 1000000){
				n++;
			}
		}
		
		return n;
	}
	
	private int startsWithK(Population[] array){
		int n = 0;
		
		for(Population object: array){
			if(object.getCountry().startsWith("K")){
				n++;
			}
		}
		
		return n;
	}
	
	private Population[] getTenToTwelveMillions(Population[] array){
		int counter = 0, index = 0;
		
		for(Population object: array){
			if(object.getPopulation() >= 10000000 && object.getPopulation() <= 12000000){
				counter++;
			}
		}
		
		Population[] newArray = new Population[counter];
		
		for(Population object: array){
			if(object.getPopulation() >= 10000000 && object.getPopulation() <= 12000000){
				newArray[index] = object;
				index++;
			}
		}
		
		return newArray;
	}
	
	private Population[] getStartsWithK(Population[] array){
		int counter = 0, index = 0;
		
		for(Population object: array){
			if(object.getCountry().startsWith("K")){
				counter++;
			}
		}
		
		Population[] newArray = new Population[counter];
		
		for(Population object: array){
			if(object.getCountry().startsWith("K")){
				newArray[index] = object;
				index++;
			}
		}
		
		return newArray;
	}
	
	private void program() {         
		Population[] countries = Populations.readPopulations("files/befolkning.txt");
		Population[] res;
		
		int n = lessThanOneMillion( countries );
		System.out.println( n + " länder har mindre än 1 miljon invånare");
		
		n = startsWithK( countries );
		System.out.println( n + " länder börjar på bokstaven 'K'");
		
		res = getTenToTwelveMillions(countries);
		
		for( int i = 0; i < res.length; i++ ) {
			System.out.println(res[ i ].toString()); 
			res = getStartsWithK(countries);
		}
		
		for( int i = 0; i < res.length; i++ ) { //            
			System.out.println( res[ i ].toString() ); 
		}
	}
	public static void main(String[] args) {
		Uppg12c app = new Uppg12c();
		app.program();
	}
}












































