import java.util.ArrayList;


public class PlayingWithFire extends ParamCard {
	public PlayingWithFire() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "PlayingWithFire";
		this.imagePath = "/Jaina/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		game.ante();
		this.redTurns += 1;
		this.brownTurns += 1;
		this.draw += 1;
		super.use(choices, game);
	}
	
	public ChoiceGroup getChoice(Game g) {
		return new ChoiceGroup();
	}
	
	public Card newCard() {
		return new PlayingWithFire();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
