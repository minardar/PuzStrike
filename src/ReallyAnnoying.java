import java.util.ArrayList;


public class ReallyAnnoying extends ReactionCard {
	
	public ReallyAnnoying() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.RED);
		cardColor.add(CardColor.BLUE);
		this.cardType = cardType.PUZZLE;
		this.defense = true;
		this.opposing = true;
		this.cost = 1;
		this.name = "ReallyAnnoying";
		this.imagePath = name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		for (int i = 0; i < game.getOpponents().size(); i++) {
			Player opp = (Player) game.getOpponentsObj().get(i);
			opp.discard.add(new Wound());
		}
	}
	
	public ChoiceGroup getChoice(Game g) {
		return new ChoiceGroup();
	}
	
	public Card newCard() {
		return new ReallyAnnoying();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
	
	public void react(Card cardUsed, Player reacting, ArrayList<Choice> choices, Game game) {
		game.getCurrentPlayer().discard.add(new Wound());
	}
	
	public boolean canReactTo(Card card) {
		if (card.cardColor.contains(CardColor.RED)){
			return true;
		}
		return false;
	}

	public ChoiceGroup getReactChoices(Game g) {
		return new ChoiceGroup();
	}
}
