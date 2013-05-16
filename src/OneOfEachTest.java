import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class OneOfEachTest {

	@Test
	public void testOneOfEachCard() {
		Game g = new Game(2);
		ParamCard testCard = new OneOfEach();
		assertEquals(5, testCard.cost);
		
		ArrayList<Choice> choices = new ArrayList<Choice>();
		
		testCard.getChoice(g);
		testCard.use(choices, g);
		assertEquals(2, g.players.get(0).blackTurns);
		assertEquals(1, g.players.get(0).hand.size());
		assertEquals(1, g.players.get(0).money);
	}

}
