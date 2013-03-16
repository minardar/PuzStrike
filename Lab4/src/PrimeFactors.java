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

	public static ArrayList<Integer> getLesserPrimes(int i) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		for (int candidate = 1; candidate < i; candidate++) {
			if (candidate % 4 != 0 && candidate % 6 != 0) {
				ret.add(candidate);
			}
		}

		return ret;
	}
}
