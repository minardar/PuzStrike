import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class HelpScreenTest {

	@Test
	public void testHelpScreen() {
		HelpScreen goo = new HelpScreen(new Game(3));
		assertEquals("1", goo.panel.getComponents()[0].getName());
	}
	
	@Test
	public void testPage2() {
		HelpScreen goo = new HelpScreen(new Game(3));
		goo.Page2();
		assertEquals("2", goo.panel.getComponents()[0].getName());
	}
	@Test
	public void testPage3() {
		HelpScreen goo = new HelpScreen(new Game(3));
		goo.Page3();
		assertEquals("3", goo.panel.getComponents()[0].getName());
	}
	@Test
	public void testPage4() {
		HelpScreen goo = new HelpScreen(new Game(3));
		goo.Page4();
		assertEquals("4", goo.panel.getComponents()[0].getName());
	}
	@Test
	public void testPage5() {
		HelpScreen goo = new HelpScreen(new Game(3));
		goo.Page5();
		assertEquals("5", goo.panel.getComponents()[0].getName());
	}
}
