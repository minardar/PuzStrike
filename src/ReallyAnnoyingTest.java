import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ReallyAnnoyingTest {

	@Test
	public void testReallyAnnoying() {
		Card card = new ReallyAnnoying();
		assertEquals(CardType.PUZZLE, card.cardType);
	}
	
	@Test
	public void testReallyAnnoyingChoices() {
		Game g = new Game(3);
		Card card = new ReallyAnnoying();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new ReallyAnnoying();
		assertTrue(card.newCard() instanceof ReallyAnnoying);
	}
	
	@Test
	public void testUseReallyAnnoying() {
		Card card = new ReallyAnnoying();
		Game g = new Game(3);
		Player opp = (Player) g.getOpponentsObj().get(0);

		ArrayList<Choice> choice = new ArrayList<Choice>();
		card.use(choice, g);

		assertTrue(opp.discard.get(0) instanceof Wound);
	}
	
	@Test
	public void TestReact(){
//		Game g = new Game(2);
//		ReactionCard card = new ReallyAnnoying();
//		Card c = new SneakAttack();
//		g.newTurn();
//		Player p = (Player) g.getOpponentsObj().get(0);
//		p.discard = new ArrayList<Card>();
//		ArrayList<Choice> choices = new ArrayList<Choice>();
//		card.react(c, p, choices, g);
//		assertTrue(p.discard.get(0) instanceof Wound);
	}
}
