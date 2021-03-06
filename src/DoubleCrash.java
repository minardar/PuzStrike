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
public class DoubleCrash extends ReactionCard {
	/**
	 * default constructor for the CRASH class... It setst the appropriate
	 * values for CRASH
	 */
	public DoubleCrash() {
		this.imagePath = "DoubleCrashGem.png";
		this.cardColor.add(CardColor.PURPLE);
		this.cardType = cardType.CIRCLE;
		this.defense = true;
		this.opposing = true;
		this.name = "DoubleCrashGem";
		this.value = 0;
		this.cost = 9;

	}

	/**
	 * Use for DoubleCrash gem. This gem should take a gem/gems out of the
	 * crasher and put them in the crashee's gempile. it also give the crasher a
	 * single gem of cash.
	 * 
	 * @param choices
	 *            An arraylist of {Crashee, GemChoices, GemChoices2}
	 */
	public void use(ArrayList<Choice> choices, Game game) {
		Choice oppChoice = choices.get(0);
		Choice gemChoice = choices.get(1);
		int gem2 = -1;
		if (choices.size() > 2) {
			Choice gem2Choice = choices.get(2);
			gem2 = (Integer) gem2Choice.getChoice().get(0);
		}
		Player crashee = (Player) oppChoice.getChoice().get(0);
		Player crasher = game.getCurrentPlayer();
		int gem = (Integer) gemChoice.getChoice().get(0);
		crasher.gemPile[gem] = crasher.gemPile[gem] - 1;
		if (gem2 > -1) {
			crasher.gemPile[gem2] = crasher.gemPile[gem2] - 1;
		}
		crashee.gemPile[0] = crashee.gemPile[0] + gem2 + gem + 2;
		crasher.money += 2;
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
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}

	/**
	 * Returns new instance of Crash Gem card
	 */
	public Card newCard() {
		return new DoubleCrash();
	}

	@Override
	public void react(Card cardUsed, Player reacting,
			ArrayList<Choice> choices, Game game) {
		ArrayList<Choice> cardChoices = cardUsed.getChosenEffect();
		int gemSelected = (Integer) cardChoices.get(1).getChoice().get(0);
		int reactGemSelected = (Integer) choices.get(0).getChoice().get(0);
		Player opp = game.getCurrentPlayer();
		opp.gemPile[gemSelected] = opp.gemPile[gemSelected] - 1;
		reacting.gemPile[reactGemSelected] = reacting.gemPile[reactGemSelected] - 1;
		if (gemSelected > reactGemSelected) {
			reacting.gemPile[0] = reacting.gemPile[0]
					+ (gemSelected - reactGemSelected);
		} else {
			opp.gemPile[0] = opp.gemPile[0] + (reactGemSelected - gemSelected);
		}
		opp.useTurn(cardUsed);
		opp.cardWasUsed(cardUsed);
		reacting.cardWasUsed(this);
	}

	@Override
	public boolean canReactTo(Card card) {
		if (card instanceof DoubleCrash) {
			return true;
		}
		return false;
	}

	@Override
	public ChoiceGroup getReactChoices(Game g, Player p) {
		ArrayList<String> gempile = g.getGempile(p);
		ArrayList<Object> gemObj = g.getGempileObj(p);
		if (gempile.isEmpty()) {
			return null;
		}
		Choice c2 = new Choice(g.choices.getString("useGem"), gempile, gemObj,
				1);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c2);
		return choices;
	}

	@Override
	public void prepare(ArrayList<Choice> choice, Game g) {
		this.setChosenEffect(choice);
		ArrayList<Player> opps = new ArrayList<Player>();
		opps.add((Player) choice.get(0).getChoice().get(0));
		this.setTargets(opps);
	}

	@Override
	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch (i) {
		case 1:
			ArrayList<String> opponents = g.getOpponents();
			ArrayList<Object> oppObj = g.getOpponentsObj();
			Choice c1 = new Choice(g.choices.getString("opponents"), opponents,
					oppObj, 1);
			return c1;
		case 2:
			ArrayList<String> gempile = g.getGempile(g.getCurrentPlayer());
			ArrayList<Object> gemObj = g.getGempileObj(g.getCurrentPlayer());
			if (gempile.isEmpty()) {
				return null;
			}
			Choice c2 = new Choice(g.choices.getString("useGem"), gempile,
					gemObj, 1);
			return c2;
		case 3:
			ArrayList<String> gempile2 = g.getGempile(g.getCurrentPlayer());
			ArrayList<Object> gemObj2 = g.getGempileObj(g.getCurrentPlayer());
			Object chosenGem = choice.getChoice().get(0);
			int indexChosen = gemObj2.indexOf(chosenGem);
			gempile2.remove(indexChosen);
			gemObj2.remove(indexChosen);
			if (gempile2.isEmpty()) {
				return null;
			}
			
			Choice c3 = new Choice(g.choices.getString("useGem"), gempile2,
					gemObj2, 1);

			return c3;
		default:
			return null;
		}
	}
}
