import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * @author harrissa
 * Wound class for the wound card that is pretty much useless
 *
 */
public class Wound extends Card{
	public Wound(){
		this.imagePath = "Wound.png";
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
	public void use(ArrayList<Choice> choices, Game game) {
	}
	/**
	 * No real choices here
	 * @param g
	 * @return
	 */
	public ChoiceGroup getChoice(Game g){
		return new ChoiceGroup();
	}

	/**
	 * Returns new instance of Wound card
	 */
	public Card newCard(){
		return new Wound();
	}
	@Override
	public void prepare(ArrayList<Choice> choice, Game g) {
		this.setChosenEffect(choice);
		this.setTargets(new ArrayList<Player>());
	}
}
