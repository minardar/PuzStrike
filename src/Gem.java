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
		switch (i){
		case 2:
			this.imagePath = "2gem.png";
			break;
		case 3:
			this.imagePath = "3gem.png";
			break;
		case 4:
			this.imagePath = "4gem.png";
			break;
		default:
			this.imagePath = "1gem.png";
			break;
		}
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
	public void use(ArrayList<Choice> choices, Game game) {
		//ignore
	}

	/**
	 * Returns null because cannot be used.
	 * 
	 * @param g
	 * @return
	 */
	public ChoiceGroup getChoice(Game g) {
		return null;
	}
	
	/**
	 * Returns new instance of Gem card
	 */
	public Card newCard(){
		return new Gem(this.value);
	}

	@Override
	public void prepare(ArrayList<Choice> choice, Game g) {
		this.setChosenEffect(choice);
		this.setTargets(new ArrayList<Player>());
	}
}
