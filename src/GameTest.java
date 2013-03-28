import static org.junit.Assert.*;
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
		assertTrue(0 == game.playerMoney);
		game.totalMoney();
		assertTrue(0 < game.playerMoney);
	}
	
	@Test
	public void testCanBuy() {
		Game game = new Game(1);
		assertFalse(game.canBuy(new Card()));
		game.totalMoney();
		assertTrue(game.canBuy(new Card()));
	}
	
	@Test
	public void testMakeBack() {
		Game game = new Game(1);
		assertEquals(game.AlwaysCards.size(), game.bank.size());
	}
	
	@Test
	public void testPlayerBuyCard() {
		Game game = new Game(1);
		Player play = game.players.get(0);
		Card card = new Card();
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
	
	
	
	
}
