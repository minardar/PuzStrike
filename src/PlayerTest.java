import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testPlayerInitiate() {
		assertNotNull(new Player());
	}

	@Test
	public void testInitiatedValues() {
		Player play = new Player();
		assertEquals(1, play.blackTurns);
		assertEquals(0, play.money);
	}
	
	@Test
	public void testNewTurn() {
		Player player = new Player();
		assertEquals(1, player.blackTurns);
		assertEquals(0, player.money);
	}
	
	@Test
	public void testPlayerSetup() {
		Player player = new Player();
		player.setup();
		
		assertEquals(5, player.hand.size());
		assertEquals(4, player.getBag().size());
		assertEquals(0, player.discard.size());
	}
	
	@Test
	public void testEndTurn() {
		Player player = new Player();
		player.setup();
		player.endTurn();
		assertEquals(0, player.hand.size());
		assertEquals(4, player.bag.size());
		assertEquals(5, player.discard.size());
	}
	
	@Test
	public void testMultipleEndTurns() {
		Player player = new Player();
		player.setup();
		player.endTurn();
		
		player.drawFromBag(3);
		assertEquals(3, player.hand.size());
		assertEquals(1, player.getBag().size());
		assertEquals(5, player.discard.size());
		
		player.endTurn();
		assertEquals(0, player.hand.size());
		assertEquals(8, player.discard.size());
		
		player.drawFromBag(5);
		assertEquals(5, player.hand.size());
		assertEquals(4, player.bag.size());
		assertEquals(0, player.discard.size());
	}
	
}
