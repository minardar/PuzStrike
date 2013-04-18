import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Class for the CRASH card. This card is meant for sending a gem from your
 * gempile to the opponents gempile
 * 
 * @author harrissa
 * 
 */
public class Crash extends Card {
	/**
	 * default constructor for the CRASH class... It setst the appropriate
	 * values for CRASH
	 */
	public Crash() {
		this.imagePath = "CrashGem.png";
		this.cardColor.add(CardColor.PURPLE);
		this.cardType = cardType.CIRCLE;
		this.defense = true;
		this.opposing = true;
		this.name = "Crash";
		this.value = 0;
		this.cost = 5;

	}

	/**
	 * Use for Crash gem. This gem should take a gem/gems out of the crasher and
	 * put them in the crashee's gempile. it also give the crasher a single gem
	 * of cash.
	 * 
	 * @param choices
	 *            An arraylist of {Crashee, GemChoices}
	 */
	public void use(ArrayList<Choice> choices, Game game) {
		Choice oppChoice = choices.get(0);
		Choice gemChoice = choices.get(1);
		Player crashee = (Player) oppChoice.getChoice().get(0);
		Player crasher = game.getCurrentPlayer();
		int gem = (Integer) gemChoice.getChoice().get(0);
		crasher.gemPile[gem] = crasher.gemPile[gem] - 1;
		crashee.gemPile[0] = crashee.gemPile[0] + gem + 1;
		crasher.money++;
	}
	
	/**
	 * Gets the appropriate choices necessary to run the use crash method. It
	 * will first load the options for opponents, then the gempile options. Both
	 * of these choices will be added to the choice arraylist
	 * 
	 * @param g
	 * @return
	 */
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> opponents = this.getOpponents(g);
		Choice c1 = new Choice("Choose Opponent to crash!", opponents, this.objList, 1);
		ArrayList<String> gempile = this.getGempile(g);
		Choice c2 = new Choice("Choose gems to crash!", gempile, this.objList, 1);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		choices.addChoiceToGroup(c2);
		return choices;
	}
	
	/**
	 * Returns new instance of Crash Gem card
	 */
	public Card newCard(){
		return new Crash();
	}
}
