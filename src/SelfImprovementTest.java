import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class SelfImprovementTest {

	@Test
	public void testSelfImprovement() {
		Game g = new Game(2);
		Card card = new SelfImprovement();
		ChoiceGroup c = card.getChoice(g);

		Player p = g.getCurrentPlayer();
		
		ArrayList<String> a = new ArrayList<String>();
		a = g.getHand();
		ArrayList<Object> o = new ArrayList<Object>();
		o.equals(p.hand);
		Choice c1 = new Choice("blah", a, o, 1);
		c1.addChoice("Wound");
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		card.use(choices, g);
		assertEquals(4, p.hand.size());
		assertEquals(0, p.discard.size());
	}
	
	@Test
	public void TestNewDashingStrike(){
		Card testCard = new SelfImprovement();
		Card newCard = testCard.newCard();
		assertEquals("SelfImprovement", newCard.name);
	}
	
	@Test
	public void testPrepare(){
		ParamCard testCard = new ParamCard();
		testCard.prepare(new ArrayList<Choice>(), new Game(3));
		assertEquals(new ArrayList<Choice>(), testCard.chosenEffect);
	}
}
