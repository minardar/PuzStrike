import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class CombineTest {

	@Test
	public void testUseCombine() {
		Game g = new Game(1);
		Player combiner = g.getCurrentPlayer();
		combiner.gemPile[0]=2;
		ArrayList<String> b = new ArrayList<String>();
		b.add("1 Gem");
		b.add("1 Gem");
		ArrayList<Object> j = new ArrayList<Object>();
		j.add(0);
		j.add(0);
		Choice c = new Choice("blah", b,j,1);
		c.addChoice("1 Gem");
		c.addChoice("1 Gem");
		ArrayList<Choice> c3 = new ArrayList<Choice>();
		c3.add(c);
		Combine com = new Combine();
		com.use(c3, g);
		assertEquals(0, combiner.gemPile[0]);
		assertEquals(1, combiner.gemPile[1]);
	}
	@Test
	public void testCombineGetChoices(){
		Game g = new Game(1);
		Player combiner = g.getCurrentPlayer();
		combiner.gemPile[0]=2;
		Combine com = new Combine();
		ArrayList<Choice> c = com.getChoice(g).getChoiceList();
		assertEquals("Choose the first gem to Combine!",c.get(0).getInstructions());
	}
	@Test
	public void testNewCombine(){
		Combine com = new Combine();
		Card com2 = com.newCard();
		assertEquals("Combine", com2.name);
	}

}
