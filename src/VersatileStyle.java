import java.util.ArrayList;


public class VersatileStyle extends TrickyCard{
	public VersatileStyle() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "VersatileStyle";
		this.imagePath ="/Grave/"+ name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		Object choice1 = choices.get(0).getChoice().get(0);
		if (choice1.equals("1")) {
			this.blackTurns++;
			super.use(choices, game);
			Card card = (Card) choices.get(1).getChoice().get(0);
			Player player = game.getCurrentPlayer();
			player.lockedCards.add(card);
			player.hand.remove(card);
		} else if (choice1.equals("2")) {
			this.money+= 2;
			super.use(choices, game);
		} else if (choice1.equals("3")) {
			this.draw+= 2;
			super.use(choices, game);
		} else {
			super.use(choices, game);
		}
	}
	
	public ChoiceGroup getChoice(Game g) {
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}
	
	public Card newCard() {
		return new VersatileStyle();
	}
	
	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch(i){
			case 1:
				ArrayList<String> choose = new ArrayList<String>();
				ArrayList<Object> chooseObj = new ArrayList<Object>();
				choose.add(g.names.getString("Moves") + " + " + g.names.getString("Lock"));
				choose.add(g.names.getString("Money"));
				choose.add(g.names.getString("Draw"));
				chooseObj.add("1");
				chooseObj.add("2");
				chooseObj.add("3");
				Choice c1 = new Choice(g.choices.getString("object"), choose, chooseObj, 1);
				return c1;
			case 2:
				if (choice.getChoice().get(0) == "2" || choice.getChoice().get(0) == "3") {
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
