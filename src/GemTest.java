import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class GemTest {

	@Test
	public void test1Gem() {
		Gem gem1 = new Gem(1);
		assertNotNull(gem1.imagePath);
		assertEquals(1, gem1.value);
		assertEquals(1, gem1.cost);
	}
	
	@Test
	public void test2Gem() {
		Gem gem1 = new Gem(2);
		assertNotNull(gem1.imagePath);
		assertEquals(2, gem1.value);
		assertEquals(3, gem1.cost);
	}
	
	@Test
	public void test3Gem() {
		Gem gem1 = new Gem(3);
		assertNotNull(gem1.imagePath);
		assertEquals(3, gem1.value);
		assertEquals(5, gem1.cost);
	}
	
	@Test
	public void test4Gem() {
		Gem gem1 = new Gem(4);
		assertNotNull(gem1.imagePath);
		assertEquals(4, gem1.value);
		assertEquals(7, gem1.cost);
	}
	
	@Test
	public void testUse(){
		Gem gem1 = new Gem(4);
		gem1.use(null, new Game(1));
	}
	
	@Test
	public void testGetChoice(){
		Gem gem1 = new Gem(4);
		assertNull(gem1.getChoice(new Game(1)));
	}
	
	@Test
	public void testNewCard(){
		Gem gem1 = new Gem(1);
		Gem gem2 = new Gem(2);
		Card new1 = gem1.newCard();
		assertNotNull(new1.imagePath);
		assertEquals(1, new1.value);
		assertEquals(1, new1.cost);
		Card new2 = gem2.newCard();
		assertNotNull(new2.imagePath);
		assertEquals(2, new2.value);
		assertEquals(3, new2.cost);
		Assert.assertNotSame(gem1, new1);
		Assert.assertNotSame(gem2, new2);
	}

	@Test
	public void testPrepare(){
		Combine com = new Combine();
		com.prepare(new ArrayList<Choice>(), new Game(3));
		assertEquals(new ArrayList<Choice>(), com.chosenEffect);
	}
}
