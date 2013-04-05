import java.util.ArrayList;

/**
 * Class for the CRASH card. This card is meant for sending a gem from your
 * gempile to the opponents gempile
 * 
 * @author harrissa
 * 
 */
public class Gem extends Card {
	/**
	 * default constructor for the CRASH class... It setst the appropriate
	 * values for CRASH
	 */
	public Gem(int i) {
		this.cardColor.add(CardColor.GREEN);
		this.cardType = cardType.CIRCLE;
		this.defense = false;
		this.name = ""+i+" Gem";
		this.value = i;
		this.cost = 2*(i-1)+1;

	}

	/**
	 * Should never be called, has no effect
	 * 
	 * @param choices
	 *            An arraylist of {Crashee, Gem1, Gem2, Gem3.... ect} only one
	 *            gem needed
	 */
	public void use(ArrayList<Choice> choices) {
		//ignore
	}

	/**
	 * Returns null because has no effect.
	 * 
	 * @param g
	 * @return
	 */
	public ArrayList<Choice> getChoice(Game g) {
		return null;
	}
}
