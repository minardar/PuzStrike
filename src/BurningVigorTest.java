import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class BurningVigorTest {

	@Test
	public void testBurningVigor() {
		Card card = new BurningVigor();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testBurningVigorChoices() {
		Game g = new Game(3);
		Card card = new BurningVigor();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new BurningVigor();
		assertTrue(card.newCard() instanceof BurningVigor);
	}
	
	@Test
	public void testUseBurningVigor() {
		Card card = new BurningVigor();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();
		current.hand.add(new Wound());
		current.discard.add(new Wound());

		ArrayList<Choice> choice = new ArrayList<Choice>();
		card.use(choice, g);
		Player opp = (Player) g.getOpponentsObj().get(0);

		assertEquals(1, current.hand.size());
		assertEquals(1, current.discard.size());
		assertEquals(1, opp.gemPile[0]);
	}
}
