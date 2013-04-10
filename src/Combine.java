import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Class for combine card. This card takes two gems from the players gempile and
 * combines them into a single gem of their combined value if they add to less
 * than four
 * 
 * @author harrissa
 * 
 */
public class Combine extends Card {
	/**
	 * the default constructor for the combine card
	 */
	public Combine() {
		this.imagePath = "Combine.png";
		this.cardColor.add(CardColor.PURPLE);
		this.cardType = cardType.CIRCLE;
		this.defense = false;
		this.name = "Combine";
		this.value = 1;
		this.cost = 4;
	}

	/**
	 * Takes the arraylist of different gem that you chose to combine and
	 * combines them.
	 * 
	 * @param choices
	 *            ArrayList of Choices arranged like this: {firstgem to combine,
	 *            secondgem to combine}
	 */
	public void use(ArrayList<Choice> choices) {
		Choice c = choices.get(0);
		int gem1 = (Integer) c.getChoice().get(0);
		int gem2 = (Integer) c.getChoice().get(1);

		Player p = c.getCurrentPlayer();
		int v = gem1 + gem2 + 1;
		if (v < 3) {
			p.gemPile[gem1] = p.gemPile[gem1] - 1;
			p.gemPile[gem2] = p.gemPile[gem2] - 1;
			p.gemPile[v] = p.gemPile[v] + 1;
		}
	}
	
	/**
	 * Give the appropriate choices for the use Combine method. The first choice
	 * is the first gem to combine and the second choice is the second gem to
	 * combine
	 * 
	 * @param g
	 * @return
	 */
	public ArrayList<Choice> getChoice(Game g) {
		ArrayList<String> gempile = this.getGempile(g);
		Choice c1 = new Choice(g, "Choose the first gem to Combine!", gempile, this.objList, 2);
		ArrayList<Choice> choice = new ArrayList<Choice>();
		choice.add(c1);
		return choice;
	}
	
	/**
	 * Returns new instance of Combine card
	 */
	public Card newCard(){
		return new Combine();
	}
}
