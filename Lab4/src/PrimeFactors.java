import java.util.ArrayList;

public class PrimeFactors {

	public static ArrayList<Integer> generateFactors(int i) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		for (int candidate = 2; i > 1; candidate++) {
			for (; i % candidate == 0; i /= candidate) {
				ret.add(candidate);
			}
		}

		return ret;
	}
	
	public static ArrayList<Integer> getLesserPrimes(int i){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		if (i > 1){
			ret.add(1);
		}
		if (i > 2){
			ret.add(2);
		}
		
		return ret;
	}
}
