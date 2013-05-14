import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DoubleCrashTest {

	@Test
	public void TestUseDoubleCrash() {
		Game g = new Game(2);
		Player crasher = g.getCurrentPlayer();
		Player crashee = g.players.get(1);
		crasher.gemPile[0]=2;
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
		c3.add(c2);
		DoubleCrash cra = new DoubleCrash();
		cra.use(c3, g);
		assertEquals(2, crashee.gemPile[0]);
		assertEquals(0, crasher.gemPile[0]);
	}
	@Test
	public void TestReact(){
		Game g = new Game(2);
		DoubleCrash c = new DoubleCrash();
		ArrayList<Choice> choose= new ArrayList<Choice>();
		ArrayList<Object> gems = new ArrayList<Object>();
		gems.add(1);
		ArrayList<String> strgems = new ArrayList<String>();
		strgems.add("1");
		Choice choice1 = new Choice("pick gem", strgems, gems, 1);
		choice1.addChoice("1");
		choose.add(choice1);		
		choose.add(choice1);
		c.setChosenEffect(choose);
		ArrayList<Object> o = g.getOpponentsObj();
		Player p = (Player) o.get(0);
		p.hand.add(new Gem(1));
		ChoiceGroup c2 = c.getChoice(g);
		c2.choices.add(choice1);
		c.react(c, p, c2.choices, g);
		assertEquals(0, p.gemPile[0]);
		
	}
	@Test
	public void TestCanReactTo(){
		DoubleCrash c1 = new DoubleCrash();
		DoubleCrash c2 = new DoubleCrash();
		
		Combine c3 = new Combine();
		assertTrue(c1.canReactTo(c2));
		assertFalse(c1.canReactTo(c3));
		
	}
	@Test
	public void testPrepare(){
		DoubleCrash c1 = new DoubleCrash();
		ArrayList<String> strgems = new ArrayList<String>();
		strgems.add("1");
		strgems.add("1");
		ArrayList<Object> gems = new ArrayList<Object>();
		gems.add(1);
		gems.add(1);
		gems.add(1);
		gems.add(1);
		ArrayList<Choice> clist = new ArrayList<Choice>();
		Choice choice = new Choice("pick gem", strgems, gems, 1);
		ArrayList<Object> p = new ArrayList<Object>();
		p.add(new Player());
		p.add(new Player());
		p.add(new Player());
		
		Choice choice2 = new Choice("Pic opponenet", strgems,p, 1);
		choice2.addChoice("1");
		choice.addChoice("1");
		clist.add(choice2);
		clist.add(choice);
		c1.prepare(clist, new Game(3));
		assertEquals(clist, c1.chosenEffect);
	}
	@Test
	public void TestNewDoubleCrashWorks(){
		DoubleCrash c = new DoubleCrash();
		Card newC = c.newCard();
		assertEquals(newC.name, "DoubleCrashGem");
	}

}
