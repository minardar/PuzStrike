import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ParamCardTest {
	Game g = new Game(3);
	
	@Test
	public void testDrawThreeCard() {
		Card testCard = new ParamCard("DrawThree");
		assertEquals(3, testCard.cost);
		assertNull(testCard.getChoice(g));
		
		ArrayList<String> opponents = testCard.getOpponents(g);
		Choice c1 = new Choice(g, "Test", opponents, testCard.objList, 1);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		
		testCard.use(choices);
		assertEquals(8, g.players.get(0).hand.size());
	}
	
	@Test
	public void testOnetwoPunchCard() {
		Card testCard = new ParamCard("OneTwoPunch");
		assertEquals(4, testCard.cost);
		
		ArrayList<String> opponents = testCard.getOpponents(g);
		Choice c1 = new Choice(g, "Test", opponents, testCard.objList, 1);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		
		testCard.use(choices);
		assertEquals(3, g.players.get(0).blackTurns);
	}
	
	@Test
	public void testRoundhouseCard() {
		Card testCard = new ParamCard("Roundhouse");
		assertEquals(4, testCard.cost);
		
		ArrayList<String> opponents = testCard.getOpponents(g);
		Choice c1 = new Choice(g, "Test", opponents, testCard.objList, 1);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		
		testCard.use(choices);
		assertEquals(2, g.players.get(0).blackTurns);
		assertEquals(7, g.players.get(0).hand.size());
	}
	
	@Test
	public void testOneOfEachCard() {
		Card testCard = new ParamCard("OneOfEach");
		assertEquals(5, testCard.cost);
		
		ArrayList<String> opponents = testCard.getOpponents(g);
		Choice c1 = new Choice(g, "Test", opponents, testCard.objList, 1);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		
		testCard.use(choices);
		assertEquals(2, g.players.get(0).blackTurns);
		assertEquals(6, g.players.get(0).hand.size());
		assertEquals(1, g.players.get(0).money);
	}
	
	@Test
	public void testMiscParamCardFunctions() {
		Card testCard = new ParamCard("DrawThree");
		assertEquals(testCard.cost, ParamCard.newCard("DrawThree").cost);
	}
}
