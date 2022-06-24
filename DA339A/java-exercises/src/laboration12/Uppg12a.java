package laboration12;  

public class Uppg12a {     
	public void program() {
		Population[] countries = Populations.readPopulations( "files/befolkning.txt" );
		
		for(Population object: countries){
			System.out.println(object.getCountry());
		}
	}
	
	public static void main(String[] args){         
		Uppg12a e12a = new Uppg12a();
		e12a.program();
	}
}