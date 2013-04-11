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
		ArrayList<String> cards = tDay.getHand(game);
		Choice c1 = new Choice(game, "Choose card to keep, then on to trash.", cards, tDay.objList, 2);
		c1.addChoice(game.getCurrentPlayer().hand.get(0).name);
		c1.addChoice(game.getCurrentPlayer().hand.get(2).name);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		tDay.use(choices);
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
