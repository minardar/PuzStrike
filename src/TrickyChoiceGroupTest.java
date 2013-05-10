import static org.junit.Assert.*;

import org.junit.Test;


public class TrickyChoiceGroupTest {

	@Test
	public void testTrickyChoiceGroup() {
		Game g = new Game(3);
		TrickyCard card = new TrainingDay();
		TrickyChoiceGroup tcg = new TrickyChoiceGroup(card, g);
		assertEquals(card, tcg.card);
		assertEquals(g, tcg.game);
		assertTrue(tcg instanceof ChoiceGroup);
	}
	
	@Test
	public void testTrickyChoiceGroupGetsChoicesIntegrationTest() {
		Game g = new Game(3);
		g.getCurrentPlayer().drawFromBag(5);
		TrickyCard card = new TrainingDay();
		TrickyChoiceGroup tcg = new TrickyChoiceGroup(card, g);
		tcg.getNextChoice();
		tcg.getNextChoice();
		assertEquals(1, tcg.choices.size());
		tcg.getChoiceList().get(0).addChoice(g.getHand(card).get(0));
		tcg.getNextChoice();
		assertEquals(2, tcg.choices.size());
		tcg.getChoiceList().get(1).addChoice(new Gem(1).getName(g));
		assertNull(tcg.getNextChoice());
	}

}
