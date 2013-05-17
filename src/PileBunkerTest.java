import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PileBunkerTest {

	@Test
	public void testPileBunker() {
		Card card = new PileBunker();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testPileBunkerChoices() {
		Game g = new Game(3);
		Card card = new PileBunker();
		assertNotNull(card.getChoice(g).getNextChoice());
	}

	@Test
	public void testNewCard() {
		Card card = new PileBunker();
		assertTrue(card.newCard() instanceof PileBunker);
	}
	
	@Test
	public void testUsePileBunker() {
		Game game = new Game(2);
		PileBunker card = new PileBunker();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> one = new ArrayList<String>();
		ArrayList<Object> two = new ArrayList<Object>();
		one.add("1");
		two.add("1");
		Choice c1 = new Choice(game.choices.getString("object"), one, two, 2);
		c1.addChoice("1");
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		Player opp = (Player) game.getOpponentsObj().get(0);
		assertEquals(6, game.getCurrentPlayer().hand.size());
		assertEquals(1, opp.gemPile[0]);
	}
}
