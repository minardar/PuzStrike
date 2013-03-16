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
	
	@Test
	public void testGeneratingFactors3() {
		assertEquals(list(3), PrimeFactors.generateFactors(3));
	}
	
	@Test
	public void testGeneratingFactors6() {
		assertEquals(list(2, 3), PrimeFactors.generateFactors(6));
	}
	
	@Test
	public void testGeneratingFactors8() {
		assertEquals(list(2, 2, 2), PrimeFactors.generateFactors(8));
	}
	
	@Test
	public void testGeneratingFactors9() {
		assertEquals(list(3, 3), PrimeFactors.generateFactors(8));
	}
	
	private ArrayList<Integer> list(int... ints){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i : ints){
			ret.add(i);
		}
		return ret;
	}
}
