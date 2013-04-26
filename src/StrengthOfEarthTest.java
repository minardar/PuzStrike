import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class StrengthOfEarthTest {

	@Test
	public void testStrengthOfEarth() {
		Card card = new BigRocks();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testStrengthOfEarthChoices() {
		Game g = new Game(3);
		Card card = new StrengthOfEarth();
		assertEquals(1, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new StrengthOfEarth();
		assertTrue(card.newCard() instanceof StrengthOfEarth);
	}
	
	@Test
	public void testStrengthOfEarthUse() {
		Card card = new StrengthOfEarth();
		Game g = new Game(3);
		ArrayList<String> gempile = g.getGempile();
		Choice c1 = new Choice("Choose the gem to add to!", gempile, g.getGempileObj(), 1);
		c1.addChoice("1 Gem");
		ChoiceGroup choice = new ChoiceGroup();
		choice.addChoiceToGroup(c1);
		card.use(choice.getChoiceList(), g);
		Player curr = g.getCurrentPlayer();
		assertEquals(0, curr.gemPile[0]);
		assertEquals(1, curr.gemPile[1]);
	}
}
