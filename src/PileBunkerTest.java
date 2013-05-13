import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PileBunkerTest {

	@Test
	public void testPileBunker() {
		Card card = new PileBunker();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testPileBunkerChoices() {
		Game g = new Game(3);
		Card card = new PileBunker();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new PileBunker();
		assertTrue(card.newCard() instanceof PileBunker);
	}
	
	@Test
	public void testUsePileBunker() {
		Card card = new PileBunker();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();

		ArrayList<Choice> choice = new ArrayList<Choice>();
		card.use(choice, g);
		Player opp = (Player) g.getOpponentsObj().get(0);
		assertEquals(1, current.hand.size());
		assertEquals(1, opp.gemPile[0]);
	}
}
