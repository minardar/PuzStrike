import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class WoundTest {

	@Test
	public void testUse() {
		Game g = new Game(1);
		Card w = new Wound();
		ArrayList<Choice> c = new ArrayList<Choice>();
		w.use(c, g);
		assertTrue(true);
	}
	@Test
	public void testGetChoice(){
		Game g = new Game(1);
		Card w = new Wound();
		assertNotNull(w.getChoice(g));
	}
	@Test
	public void testNewCard(){
		Card w = new Wound();
		Card w2 = w.newCard();
		assertEquals(w2.name, "Wound");
	}
	@Test
	public void testPrepare(){
		Game g = new Game(1);
		Card w = new Wound();
		ArrayList<Choice> c = new ArrayList<Choice>();
		w.prepare(c, g);
		assertEquals(c, w.chosenEffect);
		assertNotNull(w.targets);
		
	}

}
