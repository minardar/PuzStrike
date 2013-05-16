import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ItsTimeForThePastTest {

	@Test
	public void testItsTimeForThePast() {
		Card card = new ItsTimeForThePast();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testItsTimeForThePastChoices() {
		Game g = new Game(3);
		Card card = new ItsTimeForThePast();
		assertEquals(1, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new ItsTimeForThePast();
		assertTrue(card.newCard() instanceof ItsTimeForThePast);
	}
	
	@Test
	public void testUseItsTimeForThePast() {
		Card card = new ItsTimeForThePast();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();
		ParamCard testCard = new ParamCard();
		testCard.OneTwoPunch();
		current.discard.add(testCard);
		
		ArrayList<String> a = new ArrayList<String>();
		a = g.getDiscard(card);
		ArrayList<Object> o = new ArrayList<Object>();
		o = g.getDiscardObj(card);
		Choice c1 = new Choice("blah", a, o, 1);
		c1.addChoice(testCard.getName(g));
		ArrayList<Choice> choice = new ArrayList<Choice>();
		choice.add(c1);
		
		card.use(choice, g);
		assertEquals(0, current.discard.size());
		assertEquals(1, current.hand.size());
	}
}
