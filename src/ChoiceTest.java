import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class ChoiceTest {
	@Test
	public void testInitalize(){
		Game g = new Game(3);
		new Choice(g, "Instructions", new ArrayList<String>(), "Button");
	}
	@Test
	public void testInstancesInitialize(){
		Game g = new Game(3);
		Choice c = new Choice(g, "Instructions", new ArrayList<String>(), "Button");
		assertEquals(c.getInstructions(), "Instructions");
		assertEquals(c.getOptions(), new ArrayList<String>());
		assertEquals(c.getButton(), "Button");
	}
	@Test
	public void testSetGetChoice(){
		Game g = new Game(3);
		Choice c = new Choice(g, "Instructions", new ArrayList<String>(), "Button");
		c.setChoice("Blam");
		assertEquals(c.getChoice(), "Blam");
	}
}
