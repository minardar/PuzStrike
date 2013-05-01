import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class NoMoreLiesTest {

	@Test
	public void testNoMoreLies() {
		Card testCard = new NoMoreLies();
		assertEquals("NoMoreLies", testCard.name);
	}
	
	@Test
	public void testNoMoreLiesChoices() {
		Game g = new Game(3);
		Card card = new NoMoreLies();
		assertEquals(1, card.getChoice(g).choices.size());
	}
	
	@Test
	public void testUseNoMoreLies() {
		Card card = new NoMoreLies();
		Game g = new Game(3);
		Player curr = g.getCurrentPlayer();
		ArrayList<String> hand = g.getHand(card);
		Choice c1 = new Choice("Choose a card to trash!", hand, g.getHandObj(card), 2);
		c1.addChoice(curr.hand.get(0).getName(g));
		c1.addChoice(curr.hand.get(1).getName(g));
		ChoiceGroup choice = new ChoiceGroup();
		choice.addChoiceToGroup(c1);
		card.use(choice.getChoiceList(), g);
		assertEquals(5, curr.hand.size());
	}

	@Test
	public void testNewCard() {
		Card card = new NoMoreLies();
		assertTrue(card.newCard() instanceof NoMoreLies);
	}

}
