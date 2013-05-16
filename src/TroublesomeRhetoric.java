import java.util.ArrayList;


public class TroublesomeRhetoric extends TrickyCard{
	public TroublesomeRhetoric() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "TroublesomeRhetoric";
		this.imagePath ="/DeGray/"+ name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		Object choice1 = choices.get(0).getChoice().get(0);
		if (choice1.equals("1")) {
			this.blackTurns++;
			this.draw++;
			super.use(choices, game);
		} else if (choice1.equals("2")) {
			this.money+= 2;
			super.use(choices, game);
			Card card = (Card) choices.get(1).getChoice().get(0);
			Player player = game.getCurrentPlayer();
			player.lockedCards.add(card);
			player.hand.remove(card);
		} else {
			super.use(choices, game);
		}
	}
	
	public ChoiceGroup getChoice(Game g) {
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}
	
	public Card newCard() {
		return new TroublesomeRhetoric();
	}
	
	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch(i){
			case 1:
				ArrayList<String> choose = new ArrayList<String>();
				ArrayList<Object> chooseObj = new ArrayList<Object>();
				choose.add(g.names.getString("Moves") + " + " + g.names.getString("Draw"));
				choose.add(g.names.getString("Money") + " + " + g.names.getString("Lock"));
				chooseObj.add("1");
				chooseObj.add("2");
				Choice c1 = new Choice(g.choices.getString("object"), choose, chooseObj, 1);
				return c1;
			case 2:
				if (choice.getChoice().get(0) == "1") {
					return null;
				}
				ArrayList<String> cards = g.getHand(this);
				ArrayList<Object> cardObj = g.getHandObj(this);
				if(cards.isEmpty()){
					return null;
				}
				Choice c2 = new Choice(g.choices.getString("cardKeep"), cards, cardObj, 1);
				return c2;
			default:
				return null;
		}
	}
}
