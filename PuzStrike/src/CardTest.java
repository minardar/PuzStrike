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
