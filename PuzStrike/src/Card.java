import java.util.ArrayList;


public class Card {
	
	public int cost;
	public int value;
	public boolean defense;
	public ArrayList<CardColor> cardColor;
	public ArrayList<Integer> effects;
	public CardType cardType;
	
	public Card(ArrayList<CardColor> color, int cost, CardType type, ArrayList<Integer> effects, boolean defense, int value ){
		this.cardColor = color;
		this.cost = cost;
		this.cardType = type;
		this.effects = effects;
		this.defense = defense;
		this.value = value;
	}
}
