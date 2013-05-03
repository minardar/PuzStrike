import java.util.ArrayList;


public class ItsTimeForThePast extends ParamCard{
	public ItsTimeForThePast() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "ItsTimeForThePast";
		this.imagePath = name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		this.blackTurns += 1;
		super.use(choices, game);
		Player p = game.getCurrentPlayer();
		Choice cardChoice = choices.get(0);
		Card card = (Card) cardChoice.getChoice().get(0);
		p.discard.remove(card);
		p.hand.add(card);
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> discard = g.getDiscard(this);
		Choice c1 = new Choice("Choose a card from discard!", discard, g.getDiscardObj(this), 1);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	public Card newCard() {
		return new ItsTimeForThePast();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
