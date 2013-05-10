import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class DashingStrikeTest {

	@Test
	public void testDashingStrike() {
		Game g = new Game(2);
		Card card = new DashingStrike();
		ChoiceGroup c = card.getChoice(g);

		Player attacker = g.getCurrentPlayer();
		Player defender = g.players.get(1);
		ArrayList<String> a = new ArrayList<String>();
		a.add("Player 2");
		ArrayList<Object> o = new ArrayList<Object>();
		o.add(defender);
		ArrayList<String> b = new ArrayList<String>();
		b.add("1 Gem");
		ArrayList<Object> j = new ArrayList<Object>();
		j.add(0);
		Choice c1 = new Choice("blah", a,o, 1);
		c1.addChoice("Player 2");
		Choice c2 = new Choice("blah", b,j,1);
		c2.addChoice("1 Gem");
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		choices.add(c2);
		card.use(choices, g);
		assertEquals(1, defender.gemPile[0]);
		assertEquals(0, attacker.gemPile[0]);
	}
	
	@Test
	public void TestNewDashingStrike(){
		Card testCard = new DashingStrike();
		Card newCard = testCard.newCard();
		assertEquals("DashingStrike", newCard.name);
	}
	
	@Test
	public void testPrepare(){
		ParamCard testCard = new ParamCard();
		testCard.prepare(new ArrayList<Choice>(), new Game(3));
		assertEquals(new ArrayList<Choice>(), testCard.chosenEffect);
	}
}
