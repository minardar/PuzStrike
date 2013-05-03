import java.util.ArrayList;


public class BigRocks extends ParamCard{
	public BigRocks() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "BigRocks";
		this.imagePath = "/Rook/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		super.use(choices, game);
		Choice gemChoice = choices.get(0);
		Card gem = (Card) gemChoice.getChoice().get(0);
		game.getCurrentPlayer().hand.remove(gem);
		int value = gem.value;
		
		if (value == 4) value = 0;
		else value++;
		
		Card gem2 = new Gem(value);
		game.getCurrentPlayer().hand.add(gem2);
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> hand = g.getHand(this);
		Choice c1 = new Choice(g.choices.getString("gemTrash"), hand, g.getHandObj(this), 1);
		ChoiceGroup choice = new ChoiceGroup();
		choice.addChoiceToGroup(c1);
		return choice;
	}
	
	public Card newCard() {
		return new BigRocks();
	}
}
