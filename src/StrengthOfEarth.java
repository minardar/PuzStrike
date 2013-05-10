

import java.util.ArrayList;


public class StrengthOfEarth extends ParamCard{
	public StrengthOfEarth() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.PURPLE);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "StrengthOfEarth";
		this.imagePath = "/Rook/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		super.use(choices, game);
		Choice gemChoice = choices.get(0);
		int gem = (Integer) gemChoice.getChoice().get(0);
		game.getCurrentPlayer().gemPile[gem] = game.getCurrentPlayer().gemPile[gem] - 1;
		game.getCurrentPlayer().gemPile[gem + 1] = game.getCurrentPlayer().gemPile[gem + 1] + 1;
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> gempile = g.getGempile();
		Choice c1 = new Choice(g.choices.getString("useGem"), gempile, g.getGempileObj(), 1);
		ChoiceGroup choice = new ChoiceGroup();
		choice.addChoiceToGroup(c1);
		return choice;
	}
	
	public Card newCard() {
		return new StrengthOfEarth();
	}
}
