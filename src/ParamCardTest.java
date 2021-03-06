import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ParamCardTest {
	Game g = new Game(3);
	
	@Test
	public void testDrawThreeCard() {
		ParamCard testCard = new ParamCard();
		testCard.DrawThree();
		assertEquals(3, testCard.cost);
		assertEquals(new ChoiceGroup().choices, testCard.getChoice(g).choices);

		ArrayList<Choice> choices = new ArrayList<Choice>();
		
		testCard.use(choices, g);
		assertEquals(3, g.players.get(0).hand.size());
	}
	
	@Test
	public void testOnetwoPunchCard() {
		ParamCard testCard = new ParamCard();
		testCard.OneTwoPunch();
		assertEquals(4, testCard.cost);
		
		ArrayList<Choice> choices = new ArrayList<Choice>();
		
		testCard.getChoice(g);
		testCard.use(choices, g);
		assertEquals(3, g.players.get(0).blackTurns);
	}
	
	@Test
	public void testRoundhouseCard() {
		ParamCard testCard = new ParamCard();
		testCard.Roundhouse();
		assertEquals(6, testCard.cost);
		
		ArrayList<Choice> choices = new ArrayList<Choice>();
		
		testCard.getChoice(g);
		testCard.use(choices, g);
		assertEquals(2, g.players.get(0).blackTurns);
		assertEquals(2, g.players.get(0).hand.size());
	}
	
	@Test
	public void testThreeColors() {
		ParamCard testCard = new ParamCard();
		testCard.ThreeColors();
		
		ArrayList<Choice> choices = new ArrayList<Choice>();
		
		testCard.getChoice(g);
		testCard.use(choices, g);
		assertEquals(1, g.players.get(0).brownTurns);
		assertEquals(1, g.players.get(0).redTurns);
		assertEquals(1, g.players.get(0).blueTurns);
	}

	@Test
	public void testMiscParamCardFunctions() {
		ParamCard testCard = new ParamCard();
		testCard.DrawThree();
		Card testEqual = testCard.newCard();
		assertEquals(testCard.cost, testEqual.cost);
	}
	
	@Test
	public void testPrepare(){
		ParamCard testCard = new ParamCard();
		testCard.prepare(new ArrayList<Choice>(), new Game(3));
		assertEquals(new ArrayList<Choice>(), testCard.chosenEffect);
	}
}
