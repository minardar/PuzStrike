import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class BigRocksTest {

	@Test
	public void testBigRocks() {
		Card card = new BigRocks();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testBigRocksChoices() {
		Game g = new Game(3);
		Card card = new BigRocks();
		assertEquals(1, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new BigRocks();
		assertTrue(card.newCard() instanceof BigRocks);
	}
	
	@Test
	public void testBigRockUse() {
		Card card = new BigRocks();
		Game g = new Game(3);
		Player curr = g.getCurrentPlayer();
		ArrayList<Card> fake = new ArrayList<Card>();
		fake.add(new Gem(1));
		curr.hand = fake;
		ArrayList<String> hand = g.getHand(card);
		Choice c1 = new Choice("Choose a gem to trash!", hand, g.getHandObj(card), 1);
		c1.addChoice(curr.hand.get(0).getName(g));
		ChoiceGroup choice = new ChoiceGroup();
		choice.addChoiceToGroup(c1);
		card.use(choice.getChoiceList(), g);
		assertEquals(2, curr.hand.get(0).value);
	}
}
