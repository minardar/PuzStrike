import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {

	@Test
	public void testNewGame() {
		Game game = new Game();
		assertNotNull(game);
		assertNotNull(game.bank);
		assertNotNull(game.players);
		assertEquals(0, game.turn);
	}
	
	@Test
	public void testMakePlayers1() {
		Game game = new Game();
		game.makePlayers(1);
		assertEquals(1, game.players.size());
	}
	
	@Test
	public void testMakePlayers2() {
		Game game = new Game();
		game.makePlayers(2);
		assertEquals(2, game.players.size());
	}
	
	@Test
	public void testMakePlayers4() {
		Game game = new Game();
		game.makePlayers(4);
		assertEquals(4, game.players.size());
	}
	
	@Test
	public void testNewTurn() {
		Game game = new Game();
		game.makePlayers(2);
		game.boughtSomething = true;
		game.newTurn();
		assertEquals(1,game.turn);
		assertFalse(game.boughtSomething);
	}
	
	@Test
	public void testNewTurnCycle() {
		Game game = new Game();
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
	
}
