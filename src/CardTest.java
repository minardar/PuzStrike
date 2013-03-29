import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;





public class CardTest {

	@Test
	public void testInitiating() {
		ArrayList<CardColor> colors = new ArrayList<CardColor>();
		colors.add(CardColor.GREY);
		new Card("Init",colors, 0, CardType.PUZZLE, new ArrayList<Integer>(), 0);
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
		Card card1 = new Card("start",colors, 0, CardType.PUZZLE, new ArrayList<Integer>(),  0);
		
		assertEquals(0, card1.cost);
		assertEquals(CardType.PUZZLE, card1.cardType);
		assertEquals(new ArrayList<Integer>(), card1.effects);
		assertFalse(card1.defense);
		assertEquals(0, card1.value);
		assertEquals(colors, card1.cardColor);
	}
	@Test
	public void testCardInit1(){
		ArrayList<CardColor> colors = new ArrayList<CardColor>();
		colors.add(CardColor.GOLD);
		Card c = new Card("Card", colors, 20,
				CardType.CIRCLE, new ArrayList<Integer>(), true, 23);
		assertEquals("Card", c.name);
		assertEquals(20, c.cost);
		assertEquals(CardType.CIRCLE, c.cardType);
		assertEquals(new ArrayList<Integer>(), c.effects);
		assertTrue(c.defense);
		assertEquals(23, c.value);
		assertEquals(colors, c.cardColor);
	}
	@Test
	public void testCardInit2(){
		ArrayList<CardColor> colors = new ArrayList<CardColor>();
		colors.add(CardColor.BLUE);
		Card c2 = new Card("Card2", colors, 100,
					CardType.STAR, new ArrayList<Integer>(), false,
					0, 1, 1, 1);
		assertEquals("Card2", c2.name);
		assertEquals(100, c2.cost);
		assertEquals(CardType.STAR, c2.cardType);
		assertEquals(new ArrayList<Integer>(), c2.effects);
		assertFalse(c2.defense);
		assertEquals(0, c2.value);
		assertEquals(colors, c2.cardColor);		
		assertEquals(1, c2.input[0]);
		assertEquals(1, c2.input[1]);
		assertEquals(1, c2.input[2]);
	}
	@Test
	public void testUseNoEffect(){
		Player p = new Player();
		Card c = new Card();
		c.use(p);
	}
	@Test
	public void testUseCrash(){
		Player p1 = new Player();
		p1.gemPile[1]=1;
		Player p2 = new Player();
		ArrayList<CardColor> co = new ArrayList<CardColor>();
		co.add(CardColor.PURPLE);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(10);
		e.add(23);
		Card c = new Card("Crash", co, 4, CardType.CIRCLE, e, 1);
		c.use(p1,p2,1);
		assertEquals(0, p1.gemPile[1]);
		assertEquals(2, p2.gemPile[0]);
		assertEquals(1, p1.money);
	}
	@Test
	public void testUseCombine(){
		Player p1 = new Player();
		p1.gemPile[0]=2;
		ArrayList<CardColor> co = new ArrayList<CardColor>();
		co.add(CardColor.PURPLE);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(4);
		e.add(21);
		Card c = new Card("Combine", co, 4, CardType.CIRCLE, e, 1);
		c.use(p1,0,0);
		assertEquals(0, p1.gemPile[0]);
		assertEquals(1, p1.gemPile[1]);
		assertEquals(1, p1.purpleTurns);		
	}
	@Test
	public void testUseWoundOpponent(){
		Player p1 = new Player();
		Player p2 = new Player();
		p1.bag=new ArrayList<Card>();
		p2.bag=new ArrayList<Card>();
		ArrayList<CardColor> co = new ArrayList<CardColor>();
		co.add(CardColor.RED);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(18);
		Card c = new Card("WoundHim!", co, 4, CardType.PUZZLE, e, 1);
		c.use(p1,p2);
		assertEquals(p2.bag.get(0).name, "Wound");
	}
	@Test
	public void testSetAmount(){
		ArrayList<CardColor> co = new ArrayList<CardColor>();
		co.add(CardColor.RED);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(18);
		Card c = new Card("Amount", co, 4, CardType.PUZZLE, e, 1);
		c.setAmount(30);
		assertEquals(c.amount,30);
		
	}

}
