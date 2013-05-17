import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class VersatileStyleTest {

	@Test
	public void testVersatileStyle() {
		Card card = new VersatileStyle();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testCardChoices() {
		Game g = new Game(3);
		Card card = new VersatileStyle();
		assertNotNull(card.getChoice(g).getNextChoice());
	}

	@Test
	public void testNewCard() {
		Card card = new VersatileStyle();
		assertTrue(card.newCard() instanceof VersatileStyle);
	}
	
	@Test
	public void testUseCard() {
		Game game = new Game(2);
		VersatileStyle card = new VersatileStyle();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> one = new ArrayList<String>();
		ArrayList<Object> two = new ArrayList<Object>();
		one.add("2");
		two.add("2");
		Choice c1 = new Choice(game.choices.getString("object"), one, two, 2);
		c1.addChoice("2");
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		assertEquals(2, game.getCurrentPlayer().money);
	}
}
