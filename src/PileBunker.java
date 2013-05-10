import java.util.ArrayList;


public class PileBunker extends ParamCard {
	public PileBunker() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = true;
		this.cost = 0;
		this.name = "PileBunker";
		this.imagePath = "/DeGray/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		this.draw++;
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
		return new PileBunker();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
