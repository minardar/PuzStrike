import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PlayingWithFireTest {

	@Test
	public void testPlayingWithFire() {
		Card card = new PlayingWithFire();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testPlayingWithFireChoices() {
		Game g = new Game(3);
		Card card = new PlayingWithFire();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new PlayingWithFire();
		assertTrue(card.newCard() instanceof PlayingWithFire);
	}
	
	@Test
	public void testUsePlayingWithFire() {
		Card card = new PlayingWithFire();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();

		ArrayList<Choice> choice = new ArrayList<Choice>();
		card.use(choice, g);

		assertEquals(1, current.hand.size());
		assertEquals(1, current.redTurns);
		assertEquals(2, current.gemPile[0]);
	}
}
