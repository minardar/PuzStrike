import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

/**
 * Abstract class for the card class
 * 
 * @author harrissa
 * 
 */
public abstract class Card {

	public int cost;
	public String imagePath;
	public int value;
	public boolean defense;
	public boolean opposing = false;
	public ArrayList<CardColor> cardColor = new ArrayList<CardColor>();
	public ArrayList<Integer> effects = new ArrayList<Integer>();
	public CardType cardType;
	public String name;
	public int[] input = new int[3];
	public int amount = 1;
	public ArrayList<Choice> chosenEffect;
	public ArrayList<Player> targets;

	public abstract ChoiceGroup getChoice(Game g);

	public abstract void use(ArrayList<Choice> choices, Game game);

	public abstract Card newCard();
	
	public void setAmount(int num) {
		this.amount = num;
	}

	public boolean cardsSameKind(Card card1) {
			if (this.imagePath.equals(card1.imagePath) && this.cost == card1.cost
					&& this.name.equals(card1.name) && this.value == card1.value
					&& this.cardColor.equals(card1.cardColor)) {
				return true;
			} else {
				return false;
		}
	}
	
	public void setChosenEffect(ArrayList<Choice> effect){
		this.chosenEffect = effect;
	}
	
	public ArrayList<Choice> getChosenEffect(){
		return this.chosenEffect;
	}
	public void setTargets(ArrayList<Player> target){
		this.targets = target;
	}
	
	public ArrayList<Player> getTargets(){
		return this.targets;
	}
	public String getName(Game g){
		return g.names.getString(this.name);
	}
	
	public abstract void prepare(ArrayList<Choice> choice, Game g);

}
