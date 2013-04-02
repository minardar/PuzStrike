import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CardTest {

	@Test
	public void testInitiating() {
		new Crash();
	}
	@Test
	public void testUseCrash(){
		Player p1 = new Player();
		p1.gemPile[1]=1;
		Player p2 = new Player();
		Crash c = new Crash();
		c.use(p1, p2, 1);
		assertEquals(0, p1.gemPile[1]);
		assertEquals(2, p2.gemPile[0]);
		assertEquals(1, p1.money);
	}
	@Test
	public void testTestGetChoices(){
		Game g = new Game(3);
		Crash c = new Crash();
		Choice opponentChoice = c.getChoice(g).get(0);
		Choice gemChoice = c.getChoice(g).get(1);
		ArrayList<String> opponents = opponentChoice.getOptions();
		ArrayList<String> gems = gemChoice.getOptions();
		ArrayList<String> realOpponents=  new ArrayList<String>();
		realOpponents.add("Player 2");
		realOpponents.add("Player 3");
		assertEquals(opponents, realOpponents);
		ArrayList<String> realGems = new ArrayList<String>();
		realGems.add("2 gem");
		assertEquals(gems, realGems);
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
