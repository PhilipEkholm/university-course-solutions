package arrays;

public class CountryArrays {
	public static Country max(Country[] countries) {
		Country max = countries[0];
		
		for (Country country: countries) {
			if (max.compareTo(country) > 0)
				max = country;
		}
		
		return max;
	}
	
	public static Country min(Country[] countries) {
		Country min = countries[0];
		
		for (Country country: countries) {
			if (min.compareTo(country) < 0)
				min = country;
		}
		
		return min;
	}
	
	public static int indexOf(Country[] countries, Country country) {
		
		for (int i = 0; i < countries.length; ++i) {
			if (countries[i].equals(country))
				return i;
		}
		
		return -1;
	}
	
	public static boolean member(Country[] countries, Country country) {
		return (CountryArrays.indexOf(countries, country) != -1 ? true : false);
	}
	
	public static String toString(Country[] countries) {
		String res = "";
		
		for (Country country: countries) {
			res += country + ",";
		}
		
		res = res.substring(0, res.length() - 1);
		
		return ("{" + res + "}");
	}
}








