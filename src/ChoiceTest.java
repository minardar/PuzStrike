import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class ChoiceTest {
	@Test
	public void testInitalize(){
		Game g = new Game(3);
		new Choice(g, "Instructions", new ArrayList<String>(), new ArrayList<Object>(), 1);
	}
	@Test
	public void testInstancesInitialize(){
		Game g = new Game(3);
		Choice c = new Choice(g, "Instructions", new ArrayList<String>(),new ArrayList<Object>(), 1);
		assertEquals(c.getInstructions(), "Instructions");
		assertEquals(c.getOptions(), new ArrayList<String>());
		assertTrue(c.nextChoice());
	}
	@Test
	public void testSetGetChoice(){
		Game g = new Game(3);
		ArrayList<String> s = new ArrayList<String>();
		s.add("Blam");
		ArrayList<Object> o = new ArrayList<Object>();
		o.add(1);
		Choice c = new Choice(g, "Instructions", s, o, 1);
		c.addChoice("Blam");
		assertEquals(1,
				c.getChoice().get(0));
	}
}
