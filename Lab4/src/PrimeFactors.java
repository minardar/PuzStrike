import java.util.ArrayList;


public class PrimeFactors {

	public static ArrayList<Integer> generateFactors(int i){
		ArrayList<Integer> ret = new ArrayList<Integer>();
	
		while (i%2 == 0){
			ret.add(2);
			i/=2;
		}
		
		if (i > 1){
			ret.add(i);
		}
		
		return ret;
	}
}
