import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CrashTest {

	@Test
	public void TestUseCrash() {
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
		Choice c1 = new Choice(g, "blah", a,o, 1);
		c1.addChoice("Player 2");
		Choice c2 = new Choice(g, "blah", b,j,1);
		c2.addChoice("1 Gem");
		ArrayList<Choice> c3 = new ArrayList<Choice>();
		c3.add(c1);
		c3.add(c2);
		Crash cra = new Crash();
		cra.use(c3);
		assertEquals(2, crashee.gemPile[0]);
		assertEquals(0, crasher.gemPile[0]);
	}
	@Test
	public void TestNewCrashWorks(){
		Crash c = new Crash();
		Card newC = c.newCard();
		assertEquals(newC.name, "Crash");
	}

}
