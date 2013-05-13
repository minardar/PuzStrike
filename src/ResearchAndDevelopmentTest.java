import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ResearchAndDevelopmentTest {

	@Test
	public void ResearchAndDevelopment() {
		Card card = new DoubleTake();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testResearchAndDevelopmentChoices() {
		Game g = new Game(3);
		Card card = new ResearchAndDevelopment();
		assertEquals(2, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new ResearchAndDevelopment();
		assertTrue(card.newCard() instanceof ResearchAndDevelopment);
	}
	
	@Test
	public void testUseResearchAndDevelopment() {
		Card card = new ResearchAndDevelopment();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();
		current.drawFromBag(5);
		Card testCard = new Wound();
		current.hand.add(testCard);
		Card testCard2 = new Crash();
		current.bag.add(testCard2);
		
		ArrayList<String> a = new ArrayList<String>();
		a = g.getHand(card);
		ArrayList<Object> o = new ArrayList<Object>();
		o = g.getHandObj(card);
		Choice c1 = new Choice("blah", a, o, 1);
		c1.addChoice(testCard.getName(g));
		
		a = new ArrayList<String>();
		a = g.getBag();
		o = new ArrayList<Object>();
		o = g.getHandObj(card);
		Choice c2 = new Choice("blah", a, o, 1);
		c2.addChoice(testCard2.getName(g));
		
		ArrayList<Choice> choice = new ArrayList<Choice>();
		choice.add(c1);
		choice.add(c2);
		
		card.use(choice, g);
		assertEquals(6, current.hand.size());
	}

}
