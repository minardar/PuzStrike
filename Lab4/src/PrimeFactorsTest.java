import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PrimeFactorsTest {

	@Test
	public void testGeneratingFactors1() {
		assertEquals(new ArrayList<Integer>(), PrimeFactors.generateFactors(1));
	}

}
