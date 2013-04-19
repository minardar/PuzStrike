import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class TrainingDayTest {

	@Test
	public void testTrainingDay() {
		TrainingDay tDay = new TrainingDay();
		assertNotNull(tDay.imagePath);
		assertEquals(0, tDay.value);
		assertEquals(2, tDay.cost);
	}
	
	@Test
	public void testUse(){
		Game game = new Game(3);
		TrainingDay tDay = new TrainingDay();
		ArrayList<String> cards = game.getHand();
		ArrayList<Object> cardObj = game.getHandObj();
		Choice c1 = new Choice("Choose card to keep.", cards, cardObj, 1);
		Choice c2 = new Choice("Choose card to trash.", cards, cardObj, 1);
		c1.addChoice(game.getCurrentPlayer().hand.get(0).name);
		c2.addChoice(game.getCurrentPlayer().hand.get(1).name);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		choices.add(c2);
		tDay.use(choices, game);
		assertFalse(game.getCurrentPlayer().lockedCards.isEmpty());
	}
	
	@Test
	public void testGetChoice(){
		Game game = new Game(3);
		TrainingDay tDay = new TrainingDay();
		assertNotNull(tDay.getChoice(game));
		
	}
	
	@Test
	public void testNewCard(){
		TrainingDay tDay = new TrainingDay();
		Card new1 = tDay.newCard();
		assertNotNull(new1.imagePath);
		assertEquals(0, new1.value);
		assertEquals(2, new1.cost);
		Assert.assertNotSame(tDay, new1);
	}

}
