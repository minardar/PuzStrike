import java.util.ArrayList;


public class FutureSight extends ParamCard {
	public FutureSight() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "FutureSight";
		this.imagePath = "/Max/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		this.draw+= 2;
		super.use(choices, game);
		Card keep = (Card) choices.get(0).getChoice().get(0);
		Card keep2 = (Card) choices.get(0).getChoice().get(1);
		Player player = game.getCurrentPlayer();
		player.lockedCards.add(keep);
		player.lockedCards.add(keep2);
		player.hand.remove(keep);
		player.hand.remove(keep2);
		
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> hand = g.getHand(this);
		Choice c1 = new Choice(g.choices.getString("cardKeep"), hand, g.getHandObj(this), 2);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	public Card newCard() {
		return new FutureSight();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
