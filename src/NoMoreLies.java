import java.util.ArrayList;


public class NoMoreLies extends ParamCard{
	public NoMoreLies() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "NoMoreLies";
		this.imagePath = name + ".png";
		this.redTurns += 1;
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		super.use(choices, game);
		Choice cardChoice = choices.get(0);
		Card card = (Card) cardChoice.getChoice().get(0);
		game.getCurrentPlayer().hand.remove(card);
		Choice cardChoice2 = choices.get(1);
		Card card2 = (Card) cardChoice2.getChoice().get(0);
		game.getCurrentPlayer().hand.remove(card2);
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> hand = g.getHand();
		Choice c1 = new Choice("Choose a card to trash!", hand, g.getHandObj(), 2);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	public Card newCard() {
		ParamCard newCard = new ParamCard();
		newCard.setEqual(this);
		return newCard;
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
