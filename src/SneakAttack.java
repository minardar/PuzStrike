import java.util.ArrayList;


public class SneakAttack extends ParamCard {
	public SneakAttack() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.RED);
		this.cardType = cardType.PUZZLE;
		this.defense = false;
		this.opposing = true;
		this.cost = 3;
		this.name = "SneakAttack";
		this.imagePath = name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		this.redTurns += 1;
		super.use(choices, game);
		for (int i = 0; i < game.getOpponents().size(); i++) {
			Player opp = (Player) game.getOpponentsObj().get(i);
			opp.gemPile[0]++;
		}
	}
	
	public ChoiceGroup getChoice(Game g) {
		return new ChoiceGroup();
	}
	
	public Card newCard() {
		return new SneakAttack();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
