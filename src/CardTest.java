import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CardTest {

	@Test
	public void testInitiating() {
		new Crash();
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
	}
	@Test
	public void testSetAmount(){
		ArrayList<CardColor> co = new ArrayList<CardColor>();
		co.add(CardColor.RED);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(18);
		
	}
	@Test
	public void testGetBag(){
		Game g = new Game(1);
		Player p = g.getCurrentPlayer();
		Card c = new Crash();
		ArrayList<String> bag = c.getBag(g);
		assertTrue(bag.contains("1 Gem"));
	}

}
