import java.util.ArrayList;

/**
 * 
 * @author harrissa
 * Wound class for the wound card that is pretty much useless
 *
 */
public class Wound extends Card{
	public Wound(){
		this.cardColor.add(CardColor.GREY);
		this.cardType=cardType.CIRCLE;
		this.defense=false;
		this.name="Wound";
		this.value=0;
		this.cost = 0;
		
	}
	/**
	 * Choices should be null... The wound card does nothing really
	 * @param choices
	 */
	public void use(ArrayList<Choice> choices) {
	}
	/**
	 * No real choices here
	 * @param g
	 * @return
	 */
	public ArrayList<Choice> getChoice(Game g){
		return new ArrayList<Choice>();
	}

	/**
	 * Returns new instance of Wound card
	 */
	public Card newCard(){
		return new Wound();
	}
}
