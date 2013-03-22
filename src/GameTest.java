import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {

	@Test
	public void testNewGame() {
		Game game = new Game();
		assertNotNull(game);
		assertNotNull(game.bank);
		assertNotNull(game.players);
	}
	
	@Test
	public void testMake1Player() {
		Game game = new Game();
		game.makePlayers(1);
		assertEquals(1, game.players.size());
	}
	
	@Test
	public void testMake2Players() {
		Game game = new Game();
		game.makePlayers(2);
		assertEquals(2, game.players.size());
	}

	@Test
	public void testMake4Players() {
		Game game = new Game();
		game.makePlayers(4);
		assertEquals(4, game.players.size());
	}
	
	@Test
	public void testMakeBank() {
		Game game = new Game();
		game.makeBank();
		assertEquals(18, game.bank.size());
	}
}
