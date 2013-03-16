import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PrimeFactorsTest {

	@Test
	public void testGeneratingFactors1() {
		assertEquals(new ArrayList<Integer>(), PrimeFactors.generateFactors(1));
	}

	@Test
	public void testGeneratingFactors2() {
		assertEquals(list(2), PrimeFactors.generateFactors(2));
	}
	
	private ArrayList<Integer> list(int... ints){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i : ints){
			ret.add(i);
		}
		return ret;
	}
}
