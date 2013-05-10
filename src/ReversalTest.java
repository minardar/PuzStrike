import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ReversalTest {

	@Test
	public void testReversal() {
		Card card = new Reversal();
		assertEquals(CardType.STAR, card.cardType);
	}
	
	@Test
	public void testReversalChoices() {
		Game g = new Game(3);
		Card card = new PlayingWithFire();
		assertEquals(0, card.getChoice(g).choices.size());
	}

	@Test
	public void testNewCard() {
		Card card = new Reversal();
		assertTrue(card.newCard() instanceof Reversal);
	}
	
	@Test
	public void testUseReversal() {
		Card card = new Reversal();
		Game g = new Game(3);
		Player current = g.getCurrentPlayer();

		ArrayList<Choice> choice = new ArrayList<Choice>();
		card.use(choice, g);

		assertEquals(2, current.hand.size());
	}
	
	@Test
	public void TestReact(){
		Game g = new Game(2);
		Crash r = new Reversal();
		Crash c = new Crash();
		ArrayList<Choice> choose= new ArrayList<Choice>();
		ArrayList<Object> gems = new ArrayList<Object>();
		gems.add(1);
		ArrayList<String> strgems = new ArrayList<String>();
		strgems.add("1");
		Choice choice1 = new Choice("pick gem", strgems, gems, 1);
		choice1.addChoice("1");
		choose.add(choice1);		
		choose.add(choice1);
		r.setChosenEffect(choose);
		ArrayList<Object> o = g.getOpponentsObj();
		Player p = (Player) o.get(0);
		p.hand.add(new Gem(1));
		ChoiceGroup c2 = c.getChoice(g);
		c2.choices.get(0).getChoice().add(1);
		r.react(r, p, c2.choices, g);
		assertEquals(0, p.gemPile[0]);
		
	}
}
