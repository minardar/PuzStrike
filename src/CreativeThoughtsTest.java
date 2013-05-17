import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class CreativeThoughtsTest {

	@Test
	public void testCreativeThoughts() {
		Card testCard = new CreativeThoughts();
		assertEquals("CreativeThoughts", testCard.name);
	}
	
	@Test
	public void testCreativeThoughtsChoices() {
		Game g = new Game(3);
		Card card = new CreativeThoughts();
		assertNotNull(card.getChoice(g).getNextChoice());
	}
	
	@Test
	public void testUseCreativeThoughts() {
		Game game = new Game(2);
		CreativeThoughts card = new CreativeThoughts();
		game.getCurrentPlayer().drawFromBag(5);
		ArrayList<String> one = new ArrayList<String>();
		ArrayList<Object> two = new ArrayList<Object>();
		one.add("1");
		two.add("1");
		one.add("3");
		two.add("3");
		Choice c1 = new Choice(game.choices.getString("object"), one, two, 2);
		c1.addChoice("1");
		c1.addChoice("3");
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, game);
		assertEquals(2, game.getCurrentPlayer().blackTurns);
		assertEquals(1, game.getCurrentPlayer().money);
	}
	
	@Test
	public void testNewCard() {
		Card card = new CreativeThoughts();
		assertTrue(card.newCard() instanceof CreativeThoughts);
	}

}
