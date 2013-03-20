import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testPlayerInitiate() {
		new Player();
	}

	@Test
	public void testInitiatedValues() {
		Player play = new Player();
		assertEquals(1, play.blackTurns);
		assertEquals(0, play.money);
	}
}
