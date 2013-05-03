import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ChromaticOrbTest {

	@Test
	public void TestChromaticOrb() {
		Card testCard = new ChromaticOrb();
		assertEquals(4, testCard.cardColor.size());
	}
	
	@Test
	public void TestUseChromaticOrb() {
		Game g = new Game(2);
		Player crasher = g.getCurrentPlayer();
		Player crashee = g.players.get(1);
		ArrayList<String> a = new ArrayList<String>();
		a.add("Player 2");
		ArrayList<Object> o = new ArrayList<Object>();
		o.add(crashee);
		ArrayList<String> b = new ArrayList<String>();
		b.add("1 Gem");
		ArrayList<Object> j = new ArrayList<Object>();
		j.add(0);
		Choice c1 = new Choice("blah", a,o, 1);
		c1.addChoice("Player 2");
		Choice c2 = new Choice("blah", b,j,1);
		c2.addChoice("1 Gem");
		ArrayList<Choice> c3 = new ArrayList<Choice>();
		c3.add(c1);
		c3.add(c2);
		Card testCard = new ChromaticOrb();
		testCard.use(c3, g);
		assertEquals(2, crashee.gemPile[0]);
		assertEquals(0, crasher.gemPile[0]);
	}
	@Test
	public void TestNewChromaticOrb(){
		Card c = new ChromaticOrb();
		Card newC = c.newCard();
		assertEquals(newC.name, "ChromaticOrb");
	}
	@Test
	public void TestChoiceChromaticOrb(){
		Game g = new Game(2);
		Card c = new ChromaticOrb();
		ChoiceGroup cg = c.getChoice(g);
		assertEquals(cg.choices.size(), 2);
	}

}
