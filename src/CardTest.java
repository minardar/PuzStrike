import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;





public class CardTest {

	@Test
	public void testInitiating() {
		ArrayList<CardColor> colors = new ArrayList<CardColor>();
		colors.add(CardColor.GREY);
		new Card(colors, 0, CardType.PUZZLE, new ArrayList<Integer>(), false, 0);
	}
	@Test
	public void testDefaultConstructor() {
		Card c = new Card();
		assertEquals(1, c.cost);
		assertEquals(CardType.CIRCLE, c.cardType);
		assertEquals(new ArrayList<Integer>(), c.effects);
		assertFalse(c.defense);
		assertEquals(1, c.value);
		ArrayList<CardColor> col = new ArrayList<CardColor>();
		col.add(CardColor.GREEN);
		assertEquals(col, c.cardColor);
	}
	@Test
	public void testStartValues(){
		ArrayList<CardColor> colors = new ArrayList<CardColor>();
		colors.add(CardColor.GREY);
		Card card1 = new Card(colors, 0, CardType.PUZZLE, new ArrayList<Integer>(), false, 0);
		
		assertEquals(0, card1.cost);
		assertEquals(CardType.PUZZLE, card1.cardType);
		assertEquals(new ArrayList<Integer>(), card1.effects);
		assertFalse(card1.defense);
		assertEquals(0, card1.value);
		assertEquals(colors, card1.cardColor);
	}

}
