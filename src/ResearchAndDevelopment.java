import java.util.ArrayList;


public class ResearchAndDevelopment extends ParamCard{
	public ResearchAndDevelopment() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "ResearchAndDevelopment";
		this.imagePath = "/Max/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		this.blackTurns += 1;
		super.use(choices, game);
		Player p = game.getCurrentPlayer();
		Choice cardChoice = choices.get(0);
		Card card = (Card) cardChoice.getChoice().get(0);
		p.hand.remove(card);
		p.bag.add(card);
		
		Choice cardChoice2 = choices.get(1);
		Card card2 = (Card) cardChoice2.getChoice().get(0);
		p.bag.remove(card2);
		p.hand.add(card2);
	}
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> hand = g.getHand(this);
		Choice c1 = new Choice("Choose a card from your hand to discard!", hand, g.getHandObj(this), 1);
		ArrayList<String> deck = g.getBag();
		Choice c2 = new Choice("Choose a card from your deck!", deck, g.getBagObj(), 1);
		
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		choices.addChoiceToGroup(c2);
		return choices;
	}
	
	public Card newCard() {
		return new ResearchAndDevelopment();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
