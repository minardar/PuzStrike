import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class GameTest {

	@Test
	public void testNewGame() {
		Game game = new Game(0);
		assertNotNull(game);
		assertNotNull(game.bank);
		assertNotNull(game.players);
		assertEquals(0, game.turn);
		assertNull(game.currentTarget);
		assertNull(game.lastUsedCard);
	}
	@Test
	public void testGetBag(){
		Game g = new Game(1);
		ArrayList<String> bag = g.getBag();
		assertTrue(bag.contains("1 Gem"));
	}
	@Test
	public void testGetBagObj(){
		Game g = new Game(1);
		Player current = g.getCurrentPlayer();
		Object c = current.bag.get(0);
		ArrayList<Object> bag = g.getBagObj();
		System.out.println(bag.toString());
		assertTrue(bag.contains(c));
	}
	@Test
	public void testMakePlayers1() {
		Game game = new Game(0);
		game.makePlayers(1);
		assertEquals(1, game.players.size());
	}
	
	@Test
	public void testMakePlayers2() {
		Game game = new Game(0);
		game.makePlayers(2);
		assertEquals(2, game.players.size());
	}
	
	@Test
	public void testMakePlayers4() {
		Game game = new Game(0);
		game.makePlayers(4);
		assertEquals(4, game.players.size());
	}
	
	@Test
	public void testNewTurn() {
		Game game = new Game(0);
		game.makePlayers(2);
		game.boughtSomething = true;
		game.newTurn();
		assertEquals(1,game.turn);
		assertFalse(game.boughtSomething);
	}
	
	@Test
	public void testNewTurnCycle() {
		Game game = new Game(0);
		game.makePlayers(4);
		game.newTurn();
		assertEquals(1,game.turn);
		game.newTurn();
		assertEquals(2,game.turn);
		game.newTurn();
		assertEquals(3,game.turn);
		game.newTurn();
		assertEquals(0,game.turn);
	}
	
	@Test
	public void testgetCurrPlayer() {
		Game game = new Game(2);
		assertEquals(game.players.get(0), game.getCurrentPlayer());
		game.newTurn();
		assertEquals(game.players.get(1), game.getCurrentPlayer());
		game.newTurn();
		assertEquals(game.players.get(0), game.getCurrentPlayer());
	}
	
	@Test
	public void testTotalMoney() {
		Game game = new Game(1);
		assertEquals(0, game.playerMoney);
		game.totalMoney();
		assertTrue(game.playerMoney > 0);
	}
	
	@Test
	public void testCanBuy() {
		Game game = new Game(1);
		assertFalse(game.canBuy(new Gem(1)));
		game.totalMoney();
		assertTrue(game.canBuy(new Gem(1)));
	}
	
	@Test
	public void testMakeBank() {
		Game game = new Game(1);
		assertEquals(game.AlwaysCards.size()+game.AllCards.size(), game.bank.size());
	}
	
	@Test
	public void testPlayerBuyCard() {
		Game game = new Game(1);
		Player play = game.players.get(0);
		Card card = new Gem(1);
		game.playerBuyCard(play, card);
		assertEquals(1, card.amount);
		assertEquals(0, play.discard.size());
		game.totalMoney();
		game.playerBuyCard(play, card);
		assertEquals(0, card.amount);
		assertEquals(1, play.discard.size());
		game.playerBuyCard(play, card);
		assertEquals(0, card.amount);
		assertEquals(1, play.discard.size());
	}
	
	@Test
	public void testSetTarget(){
		Game game = new Game(2);
		Player play = game.players.get(0);
		Card card = new Crash();
		game.setTarget(play, card);
		assertEquals(card, game.lastUsedCard);
		assertEquals(play, game.currentTarget);
	}
	
	@Test
	public void testUseCard(){
		Game game = new Game(2);
		Card card = new Crash();
		game.useCard(card);
		assertEquals(card, game.lastUsedCard);
	}
	
	@Test
	public void testMiniBuy(){
		Game game = new Game(2);
		assertEquals(0, game.getNumber);
		assertEquals(0, game.underVal);
		game.setMiniBuy(2, 3);
		assertEquals(3, game.getNumber);
		assertEquals(2, game.underVal);
		game.clearMiniBuy();
		assertEquals(0, game.getNumber);
		assertEquals(0, game.underVal);
	}
	
	@Test
	public void testPlayeGetCard() {
		Game game = new Game(1);
		Player play = game.players.get(0);
		Card card = new Gem(1);
		game.playerGetCard(play, card);
		assertEquals(0, card.amount);
		assertEquals(1, play.discard.size());
	}
	
	@Test
	public void testTrashCard() {
		Game game = new Game(1);
		Player play = game.players.get(0);
		Card card = new Gem(1);
		game.playerTrashCard(play, card);
	}
	
}
