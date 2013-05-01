import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Locale;

import org.junit.Test;


public class GUITest {

	@Test
	public void testGUI() {
		GUI goo = new GUI();
		assertEquals("Playing", goo.panel.getComponents()[0].getName());
	}
	
	@Test
	public void testFirstSetUp() {
		GUI goo = new GUI();
		goo.firstSetUp();
		assertEquals(false, goo.buyPhase);
		assertEquals("Shopping", goo.panel.getComponents()[0].getName());
	}
	
	@Test
	public void testNewTurn() {
		GUI goo = new GUI();
		goo.firstSetUp();
		goo.newTurn();
		assertEquals(false, goo.buyPhase);
		assertEquals("Playing", goo.panel.getComponents()[0].getName());
	}
	
	@Test
	public void testNewShop() {
		GUI goo = new GUI();
		goo.newShopPhase();
		assertEquals(true, goo.buyPhase);
		assertEquals("Shopping", goo.panel.getComponents()[0].getName());
	}
	
	@Test
	public void testEndShop() {
		GUI goo = new GUI();
		goo.newShopPhase();
		assertFalse(goo.game.boughtSomething);
		goo.endShopPhase();
		assertFalse(goo.game.boughtSomething);
		assertEquals("Shopping", goo.panel.getComponents()[0].getName());
		goo.game.boughtSomething = true;
		assertTrue(goo.game.boughtSomething);
		goo.endShopPhase();
		assertEquals("Playing", goo.panel.getComponents()[0].getName());
	}
	
	@Test
	public void testGetDefensiveCards(){
		GUI goo = new GUI();
		goo.game = new Game(4);
		Game g = goo.game;
		Card card = new Crash();
		Player curr = g.getCurrentPlayer();
		Player opp = (Player) g.getOpponentsObj().get(0);
		Player opp2 = (Player) g.getOpponentsObj().get(1);
		Player opp3 = (Player) g.getOpponentsObj().get(2);
		ArrayList<Card> hasGem = new ArrayList<Card>();
		hasGem.add(new Gem(1));
		ArrayList<Card> hasCrash = new ArrayList<Card>();
		hasCrash.add(new Crash());
		ArrayList<Card> hasBlue = new ArrayList<Card>();
		hasBlue.add(new SelfImprovement());
		
		opp.hand = hasGem;
		opp2.hand = hasCrash;
		opp3.hand = hasBlue;
		ArrayList<Player> targets = new ArrayList<Player>();
		targets.add(opp);
		assertEquals(1, goo.getDefensiveCards(targets, card).size());
		targets.add(opp2);
		assertEquals(2, goo.getDefensiveCards(targets, card).size());
		targets.add(opp3);
		assertEquals(3, goo.getDefensiveCards(targets, card).size());
		assertEquals(0, goo.getDefensiveCards(targets, card).get(0).size());
		assertEquals(1, goo.getDefensiveCards(targets, card).get(1).size());
		assertEquals(0, goo.getDefensiveCards(targets, card).get(2).size());
		card = new DashingStrike();
		assertEquals(0, goo.getDefensiveCards(targets, card).get(0).size());
		assertEquals(0, goo.getDefensiveCards(targets, card).get(1).size());
		assertEquals(1, goo.getDefensiveCards(targets, card).get(2).size());
		
	}
	
	@Test
	public void testChangeLang(){
		GUI goo = new GUI();
		goo.changeGameLanguage("english");
		assertEquals(Locale.US, goo.game.currentLocale);
		goo.changeGameLanguage("french");
		assertEquals(Locale.FRANCE, goo.game.currentLocale);
		goo.buyPhase = false;
		goo.changeGameLanguage("english");
		assertEquals("Playing", goo.panel.getComponents()[0].getName());
		goo.buyPhase = true;
		goo.changeGameLanguage("english");
		assertEquals("Shopping", goo.panel.getComponents()[0].getName());
		
	}
	
	


}
