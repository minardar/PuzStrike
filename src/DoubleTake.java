import java.util.ArrayList;


public class DoubleTake extends ParamCard{
	public DoubleTake() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "DoubleTake";
		this.imagePath = "/Setsuki/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		super.use(choices, game);
		Player p = game.getCurrentPlayer();
		Choice cardChoice = choices.get(0);
		ParamCard card = (ParamCard) cardChoice.getChoice().get(0);
		card.use(choices, game);
		card.use(choices, game);
		p.hand.remove(card);
		
		p.blackTurns = 0; p.purpleTurns = 0; p.redTurns = 0; p.brownTurns = 0; p.blueTurns = 0;
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> hand = g.getHand(this);
		Choice c1 = new Choice("Choose a card to use!", hand, g.getHandObj(this), 1);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	public Card newCard() {
		return new DoubleTake();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
