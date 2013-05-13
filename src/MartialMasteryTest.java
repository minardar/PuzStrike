import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class MartialMasteryTest {

	@Test
	public void testMartialMastery() {
		TrickyCard card = new MartialMastery();
		assertNotNull(card.imagePath);
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testUse(){
		Game game = new Game(3);
		TrickyCard card = new MartialMastery();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> cards = game.getHand(card);
		ArrayList<Object> cardObj = game.getHandObj(card);
		Choice c1 = new Choice("Choose card to trash.", cards, cardObj, 1);
		c1.addChoice(game.getCurrentPlayer().hand.get(1).getName(game));
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		assertEquals(4, game.getCurrentPlayer().hand.size());
	}
	
	@Test
	public void testGetChoice(){
		Game game = new Game(3);
		TrickyCard card = new MartialMastery();
		assertNotNull(card.getChoice(game));
		
	}
	
	@Test
	public void testNewCard(){
		TrickyCard card = new MartialMastery();
		Card new1 = card.newCard();
		assertNotNull(new1.imagePath);
		assertEquals(CardType.STAR, card.cardType);
		Assert.assertNotSame(card, new1);
	}
}
