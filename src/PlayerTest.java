import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testPlayerInitiate() {
		assertNotNull(new Player());
	}

	@Test
	public void testInitiatedValues() {
		Player play = new Player();
		assertEquals(1, play.blackTurns);
		assertEquals(0, play.money);
	}
	
	@Test
	public void testNewTurn() {
		Player player = new Player();
		assertEquals(1, player.blackTurns);
		assertEquals(0, player.money);
	}
	
	@Test
	public void testPlayerSetup() {
		Player player = new Player();
		player.setup();
		player.drawFromBag(5);
		assertEquals(5, player.hand.size());
		assertEquals(4, player.bag.size());
		assertEquals(0, player.discard.size());
	}
	
	@Test
	public void testEndTurn() {
		Player player = new Player();
		player.setup();
		player.endTurn();
		assertEquals(5, player.hand.size());
		assertEquals(4, player.bag.size());
		assertEquals(0, player.discard.size());
	}
	
	@Test
	public void testMultipleEndTurns() {
		Player player = new Player();
		player.setup();
		player.endTurn();
		
		player.drawFromBag(3);
		assertEquals(8, player.hand.size());
		assertEquals(1, player.bag.size());
		assertEquals(0, player.discard.size());
		
		player.endTurn();
		assertEquals(5, player.hand.size());
		assertEquals(0, player.discard.size());
		
		player.endTurn();
		assertEquals(5, player.hand.size());
		assertEquals(4, player.bag.size());
		assertEquals(0, player.discard.size());
	}
	
	@Test
	public void testTotalGemValue() {
		Player player = new Player();
		player.setup();
		player.gemPile[1] += 1;
		player.gemPile[2] += 1;
		player.gemPile[3] += 1;
		assertEquals(9, player.totalGemValue());
	}
	
	@Test
	public void testCanUseCard() {
		Player player = new Player();
		ArrayList<CardColor> w = new ArrayList<CardColor>();
		w.add(CardColor.PURPLE);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(23);
		Card card = new Crash();
		assertTrue(player.canUseCard(card));
		
		player.blackTurns = 0;
		assertFalse(player.canUseCard(card));
	}
	
	@Test
	public void testCanUsePurpleCard() {
		Player player = new Player();
		player.blackTurns = 0;
		player.purpleTurns = 1;
		Card card = new Crash();
		assertTrue(player.canUseCard(card));
	}
	
	@Test
	public void testCanMultipleColoredCards() {
		Player player = new Player();
		player.blackTurns = 0;
		player.redTurns = 1;
		player.blueTurns = 1;
		player.brownTurns = 1;
		Card card = new Crash();
		
		ArrayList<CardColor> c = new ArrayList<CardColor>();
		c.add(CardColor.RED);
		card.cardColor = c;
		assertTrue(player.canUseCard(card));
		
		c.set(0, CardColor.BLUE);
		assertTrue(player.canUseCard(card));
		
		c.set(0, CardColor.BROWN);
		assertTrue(player.canUseCard(card));
		
		c.set(0, CardColor.GOLD);
		assertFalse(player.canUseCard(card));
		
		card = new Gem(1);
		assertFalse(player.canUseCard(card));
	}
	
	@Test
	public void testUseTurn() {
		Player player = new Player();
		player.purpleTurns = 1;

		Card card = new Crash();
		player.useTurn(card);
		assertEquals(0, player.purpleTurns);
	
		player.useTurn(card);
		assertEquals(0, player.blackTurns);
	}
	
	@Test
	public void testMultipleUseTurns() {
		Player player = new Player();
		player.redTurns = 1;
		player.blueTurns = 1;
		player.brownTurns = 1;
		
		Card card = new Crash();
		ArrayList<CardColor> c = new ArrayList<CardColor>();
		c.add(CardColor.RED);
		card.cardColor = c;
		
		player.useTurn(card);
		assertEquals(0, player.redTurns);
		
		c.set(0, CardColor.BLUE);
		player.useTurn(card);
		assertEquals(0, player.blueTurns);
		
		c.set(0, CardColor.BROWN);
		player.useTurn(card);
		assertEquals(0, player.brownTurns);
	
		player.useTurn(card);
		assertEquals(0, player.blackTurns);
	}
	
	@Test
	public void testTotalMoney() {
		Player player = new Player();
		Card gem = new Gem(1);
		player.hand.add(gem);
		player.hand.add(gem);
		assertEquals(2, player.totalMoney());
		
		
		ArrayList<CardColor> w = new ArrayList<CardColor>();
		w.add(CardColor.GREEN);
		ArrayList<Integer> e = new ArrayList<Integer>();
		Card gem3 = new Gem(3);
		player.hand.add(gem3);
		assertEquals(5, player.totalMoney());
	}
	
	@Test
	public void testTotalMoneyWithDrawFromBag() {
		Player player = new Player();
		player.setup();
		
		assertTrue(player.totalMoney() == 0);
	}
	
	@Test
	public void testAddToDiscard() {
		Player player = new Player();
		Card card = new Gem(1);
		assertEquals(0, player.discard.size());
		player.addToDiscard(card);
		assertEquals(1, player.discard.size());
		player.addToDiscard(card);
		assertEquals(2, player.discard.size());
	}
	
	@Test
	public void testAddToUse() {
		Player player = new Player();
		assertEquals(0, player.toUse.size());
		player.addToUse(10);
		assertEquals(1, player.toUse.size());
		player.addToUse(2);
		assertEquals(2, player.toUse.size());
	}
}
