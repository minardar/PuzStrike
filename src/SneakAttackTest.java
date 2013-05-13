import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class SneakAttackTest {

	@Test
	public void testSneakAttack() {
		Card card = new SneakAttack();
		assertEquals(CardType.PUZZLE, card.cardType);
	}
	
	@Test
	public void testSneakAttackChoices() {
		Game g = new Game(3);
		Card card = new SneakAttack();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new SneakAttack();
		assertTrue(card.newCard() instanceof SneakAttack);
	}
	
	@Test
	public void testUseSneakAttack() {
		Card card = new SneakAttack();
		Game g = new Game(3);

		ArrayList<Choice> choice = new ArrayList<Choice>();
		card.use(choice, g);
		Player opp = (Player) g.getOpponentsObj().get(0);

		assertEquals(1, opp.gemPile[0]);
	}
}
