import java.util.ArrayList;


public class MartialMastery extends TrickyCard {
	public MartialMastery() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "MartialMastery";
		this.imagePath = "/Grave/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		Card trash = (Card) choices.get(0).getChoice().get(0);
		Player player = game.getCurrentPlayer();
		game.playerTrashCard(player, trash);
		int val = trash.cost + 2;
		int num = 1;
		game.setMiniBuy(val, num);
		game.getCurrentPlayer().blackTurns += 1;
	}
	
	public ChoiceGroup getChoice(Game g) {
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}
	
	public Card newCard() {
		return new MartialMastery();
	}
	
	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch(i){
		case 1:
				ArrayList<Card> excl = new ArrayList<Card>();
				excl.add(new Crash());
				ArrayList<String> cards2 = g.getHand(excl, this, false);
				ArrayList<Object> cardObj2 = g.getHandObj(excl, this, false);
				Choice c2 = new Choice(g.choices.getString("cardTrash"), cards2, cardObj2, 1);
				return c2;
		default:
				return null;
		}
	}
}
