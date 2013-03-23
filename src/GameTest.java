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
}
