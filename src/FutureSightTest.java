import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class FutureSightTest {

	@Test
	public void testFutureSight() {
		Card card = new FutureSight();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testCardChoices() {
		Game g = new Game(3);
		Card card = new FutureSight();
		assertNotNull(card.getChoice(g).getNextChoice());
	}

	@Test
	public void testNewCard() {
		Card card = new FutureSight();
		assertTrue(card.newCard() instanceof FutureSight);
	}
	
	@Test
	public void testUseCard() {
		Game game = new Game(2);
		FutureSight card = new FutureSight();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> cards = game.getHand(card);
		ArrayList<Object> cardObj = game.getHandObj(card);
		Choice c1 = new Choice("Choose card to keep.", cards, cardObj, 2);
		c1.addChoice(game.getCurrentPlayer().hand.get(0).getName(game));
		c1.addChoice(game.getCurrentPlayer().hand.get(1).getName(game));
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		assertEquals(2, game.getCurrentPlayer().lockedCards.size());
		assertEquals(5, game.getCurrentPlayer().hand.size());
	}

}
