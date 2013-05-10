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
		g.newTurn();
		Player curr = g.getCurrentPlayer();
		curr.drawFromBag(5);
		ArrayList<String> hand = g.getHand(card);
		System.out.println(hand);
		Choice c1 = new Choice("Choose a card to trash!", hand, g.getHandObj(card), 1);
		c1.addChoice(curr.hand.get(0).getName(g));
		Choice c2 = new Choice("Choose a card to trash!", hand, g.getHandObj(card), 1);
		c2.addChoice(curr.hand.get(1).getName(g));
		ChoiceGroup choice = new ChoiceGroup();
		choice.addChoiceToGroup(c1);
		choice.addChoiceToGroup(c2);
		card.use(choice.getChoiceList(), g);
		System.out.println(curr.hand);
		assertEquals(4, curr.hand.size());
	}

	@Test
	public void testNewCard() {
		Card card = new NoMoreLies();
		assertTrue(card.newCard() instanceof NoMoreLies);
	}

}
