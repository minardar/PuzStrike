import java.util.ArrayList;


public class BagOfTricks extends ParamCard {
	public BagOfTricks() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "BagOfTricks";
		this.imagePath = "/Setsuki/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		brownTurns += 1;
		draw += 1;
		super.use(choices, game);
		Card keep = (Card) choices.get(0).getChoice().get(0);
		Player player = game.getCurrentPlayer();
		player.lockedCards.add(keep);
		player.hand.remove(keep);
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> hand = g.getHand(this);
		Choice c1 = new Choice(g.choices.getString("cardKeep"), hand, g.getHandObj(this), 1);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	public Card newCard() {
		return new BagOfTricks();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
