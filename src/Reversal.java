import java.util.ArrayList;


public class Reversal extends Crash {
	
	public Reversal() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.PURPLE);
		this.cardType = cardType.STAR;
		this.defense = true;
		this.opposing = false;
		this.cost = 0;
		this.name = "Reversal";
		this.imagePath = "/Grave/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		this.draw += 2;
		Player p = game.getCurrentPlayer();
		p = game.getCurrentPlayer();
		p.blackTurns += blackTurns;
		p.purpleTurns += purpleTurns;
		p.redTurns += redTurns;
		p.brownTurns += brownTurns;
		p.blueTurns += blueTurns;
		p.money += money;
		p.drawFromBag(draw);
	}
	
	public ChoiceGroup getChoice(Game g) {
		return new ChoiceGroup();
	}
	
	public Card newCard() {
		return new Reversal();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
	
	public void react(Card cardUsed, Player reacting, ArrayList<Choice> choices, Game game) {
		super.react(cardUsed, reacting, choices, game);
	}

	public boolean canReactTo(Card card) {
		if (card instanceof Crash){
			return true;
		}
		return false;
	}

	public ChoiceGroup getReactChoices(Game g, Player p) {
		return super.getReactChoices(g, p);
	}
	
	public void prepare(ArrayList<Choice> choice, Game g){
		super.prepare(choice, g);
	}
}
