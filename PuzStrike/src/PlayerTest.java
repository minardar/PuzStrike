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
	public void testDrawFromBag() {
		Player player = new Player();
		ArrayList<Integer> effects = new ArrayList<Integer>();
		ArrayList<Color> colors = new ArrayList<Color>();
		Card card = new Card(colors, 0, CardType.CIRCLE, effects, false, 1);
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			cards.add(card);
		}
		player.setHand(cards);
		player.setBag(cards);
		player.setDiscard(cards);
		
		assertNotNull(player.hand);
		assertEquals(5, player.bag.size());
		
		player.drawFromBag(1);
		assertEquals(6, player.hand.size());
		assertEquals(4, player.bag.size());
		assertEquals(5, player.discard.size());
		player.drawFromBag(1);
		assertEquals(3, player.bag.size());
		assertEquals(5, player.discard.size());
	}
	
}
