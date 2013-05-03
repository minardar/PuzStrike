import java.util.ArrayList;


public class CreativeThoughts extends ParamCard {
	public CreativeThoughts() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "CreativeThoughts";
		this.imagePath ="/Valerie/"+ name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		blackTurns += 1;
		money += 1;
		game.getCurrentPlayer().drawFromBag(1);
		super.use(choices, game);
	}
	
	public ChoiceGroup getChoice(Game g) {
//		ArrayList<String> choose = new ArrayList<String>();
//		choose.add("+1 Turns");
//		choose.add("+1 Money");
//		choose.add("+1 Draw");
//		Choice c1 = new Choice("Choose 2 options!", choose, new ArrayList<Object>(), 2);
		ChoiceGroup choices = new ChoiceGroup();
//		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	public Card newCard() {
		return new CreativeThoughts();
	}
}
