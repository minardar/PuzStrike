import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class StoneWallTest {

	@Test
	public void testStoneWall() {
		Card card = new StoneWall();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testStoneWallChoices() {
		Game g = new Game(3);
		Card card = new StoneWall();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new StoneWall();
		assertTrue(card.newCard() instanceof StoneWall);
	}
	
	@Test
	public void testUseStoneWall() {
		Card card = new StoneWall();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();
		card.use(new ArrayList<Choice>(), g);
		assertEquals(1, current.hand.size());
	}
}
