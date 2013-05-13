import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class CreativeThoughtsTest {

	@Test
	public void testCreativeThoughts() {
		Card testCard = new CreativeThoughts();
		assertEquals("CreativeThoughts", testCard.name);
	}
	
	@Test
	public void testCreativeThoughtsChoices() {
		Game g = new Game(3);
		Card card = new CreativeThoughts();
		assertEquals(0, card.getChoice(g).choices.size());
	}
	
	@Test
	public void testUseCreativeThoughts() {
		Card card = new CreativeThoughts();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();
		card.use(new ArrayList<Choice>(), g);
		assertEquals(2, current.blackTurns);
		assertEquals(1, current.money);
		assertEquals(1, current.hand.size());
	}

	@Test
	public void testNewCard() {
		Card card = new CreativeThoughts();
		assertTrue(card.newCard() instanceof CreativeThoughts);
	}

}
