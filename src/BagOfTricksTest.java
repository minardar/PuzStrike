import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class BagOfTricksTest {
	
	@Test
	public void testBagOfTricks() {
		BagOfTricks card = new BagOfTricks();
		assertNotNull(card.imagePath);
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testUse(){
		Game game = new Game(2);
		BagOfTricks card = new BagOfTricks();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> cards = game.getHand(card);
		ArrayList<Object> cardObj = game.getHandObj(card);
		Choice c1 = new Choice("Choose card to keep.", cards, cardObj, 1);
		c1.addChoice(game.getCurrentPlayer().hand.get(0).getName(game));
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		assertFalse(game.getCurrentPlayer().lockedCards.isEmpty());
		assertEquals(1, game.getCurrentPlayer().brownTurns);
	}
	
	@Test
	public void testGetChoice(){
		Game game = new Game(3);
		BagOfTricks card = new BagOfTricks();
		assertNotNull(card.getChoice(game));
		
	}
	
	@Test
	public void testNewCard(){
		BagOfTricks card = new BagOfTricks();
		assertTrue(card.newCard() instanceof BagOfTricks);
	}
}
