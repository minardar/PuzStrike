import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class OneOfEachTest {
	
	@Test
	public void testOneOfEach() {
		Card testCard = new OneOfEach();
		assertEquals("OneOfEach", testCard.name);
	}
	
	@Test
	public void testCardChoices() {
		Game g = new Game(3);
		Card card = new OneOfEach();
		assertNotNull(card.getChoice(g).getNextChoice());
	}
	
	@Test
	public void testUseCard() {
		Game game = new Game(2);
		OneOfEach card = new OneOfEach();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> cards = game.getHand(card);
		ArrayList<Object> cardObj = game.getHandObj(card);
		Choice c1 = new Choice("Choose card to keep.", cards, cardObj, 1);
		c1.addChoice(game.getCurrentPlayer().hand.get(0).getName(game));
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		assertEquals(2, game.getCurrentPlayer().blackTurns);
		assertEquals(1, game.getCurrentPlayer().money);
		assertEquals(1, game.getCurrentPlayer().lockedCards.size());
	}
	
	@Test
	public void testNewCard() {
		Card card = new OneOfEach();
		assertTrue(card.newCard() instanceof OneOfEach);
	}

}
