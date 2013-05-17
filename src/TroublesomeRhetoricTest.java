import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TroublesomeRhetoricTest {
	@Test
	public void testCreativeThoughts() {
		Card testCard = new TroublesomeRhetoric();
		assertEquals("TroublesomeRhetoric", testCard.name);
	}
	
	@Test
	public void testCreativeThoughtsChoices() {
		Game g = new Game(3);
		Card card = new TroublesomeRhetoric();
		assertNotNull(card.getChoice(g).getNextChoice());
	}
	
	@Test
	public void testUseTroublesomeRhetoric() {
		Game game = new Game(2);
		TroublesomeRhetoric card = new TroublesomeRhetoric();
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
		assertEquals(2, game.getCurrentPlayer().blackTurns);
		assertEquals(6, game.getCurrentPlayer().hand.size());
	}
	
	@Test
	public void testNewCard() {
		Card card = new TroublesomeRhetoric();
		assertTrue(card.newCard() instanceof TroublesomeRhetoric);
	}
}
