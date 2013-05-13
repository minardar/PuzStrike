import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class DoubleTakeTest {

	@Test
	public void testDoubleTake() {
		Card card = new DoubleTake();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testDoubleTakeChoices() {
		Game g = new Game(3);
		Card card = new DoubleTake();
		assertEquals(1, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new DoubleTake();
		assertTrue(card.newCard() instanceof DoubleTake);
	}
	
	@Test
	public void testUseDoubleTake() {
		Card card = new DoubleTake();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();
		ParamCard testCard = new ParamCard();
		testCard.OneOfEach();
		current.hand.add(testCard);
		
		ArrayList<String> a = new ArrayList<String>();
		a = g.getHand(card);
		ArrayList<Object> o = new ArrayList<Object>();
		o = g.getHandObj(card);
		Choice c1 = new Choice("blah", a, o, 1);
		c1.addChoice(testCard.getName(g));
		ArrayList<Choice> choice = new ArrayList<Choice>();
		choice.add(c1);
		
		card.use(choice, g);
		assertEquals(2, current.money);
		assertEquals(0, current.blackTurns);
	}
}
