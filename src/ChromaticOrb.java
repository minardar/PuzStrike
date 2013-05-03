import java.util.ArrayList;


public class ChromaticOrb extends ParamCard {
	public ChromaticOrb() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.PURPLE);
		cardColor.add(CardColor.BROWN);
		cardColor.add(CardColor.RED);
		cardColor.add(CardColor.BLUE);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = true;
		this.cost = 0;
		this.name = "ChromaticOrb";
		this.imagePath = "/Valerie/"+name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		Choice oppChoice = choices.get(0);
		Choice gemChoice = choices.get(1);
		Player crashee = (Player) oppChoice.getChoice().get(0);
		Player crasher = game.getCurrentPlayer();
		int gem = (Integer) gemChoice.getChoice().get(0);
		crasher.gemPile[gem] = crasher.gemPile[gem] - 1;
		crashee.gemPile[0] = crashee.gemPile[0] + gem + 1;
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> opponents = g.getOpponents();
		ArrayList<Object> oppObj = g.getOpponentsObj();
		Choice c1 = new Choice(g.choices.getString("opponents"), opponents, oppObj, 1);
		ArrayList<String> gempile = g.getGempile();
		ArrayList<Object> gemObj = g.getGempileObj();
		Choice c2 = new Choice(g.choices.getString("useGem"), gempile, gemObj, 1);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		choices.addChoiceToGroup(c2);
		return choices;
	}
	
	public Card newCard() {
		return new ChromaticOrb();
	}
}
