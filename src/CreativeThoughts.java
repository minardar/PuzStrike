import java.util.ArrayList;

public class CreativeThoughts extends TrickyCard {
	public CreativeThoughts() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "CreativeThoughts";
		this.imagePath = "/Valerie/" + name + ".png";
	}

	public void use(ArrayList<Choice> choices, Game game) {
		Object choice1 = choices.get(0).getChoice().get(0);
		Object choice2 = choices.get(0).getChoice().get(1);
		if (choice1.equals("1") || choice2.equals("1")) {
			this.blackTurns++;
		}
		if (choice1.equals("2") || choice2.equals("2")) {
			Card card = (Card) choices.get(1).getChoice().get(0);
			Player player = game.getCurrentPlayer();
			player.lockedCards.add(card);
			player.hand.remove(card);
		}
		if (choice1.equals("3") || choice2.equals("3")) {
			this.money++;
		}
		if (choice1.equals("4") || choice2.equals("4")) {
			this.draw++;
		}
		super.use(choices, game);
	}

	public ChoiceGroup getChoice(Game g) {
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}

	public Card newCard() {
		return new CreativeThoughts();
	}

	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch (i) {
		case 1:
			ArrayList<String> choose = new ArrayList<String>();
			ArrayList<Object> chooseObj = new ArrayList<Object>();
			choose.add(g.names.getString("Moves"));
			choose.add(g.names.getString("Lock"));
			choose.add(g.names.getString("Money"));
			choose.add(g.names.getString("Draw"));
			chooseObj.add("1");
			chooseObj.add("2");
			chooseObj.add("3");
			chooseObj.add("4");
			Choice c1 = new Choice(g.choices.getString("object"), choose,
					chooseObj, 2);
			return c1;
		case 2:
			if (choice.getChoice().get(0) == "2"
					|| choice.getChoice().get(1) == "2") {
				ArrayList<String> cards = g.getHand(this);
				ArrayList<Object> cardObj = g.getHandObj(this);
				if (cards.isEmpty()) {
					return null;
				}
				Choice c2 = new Choice(g.choices.getString("cardKeep"), cards,
						cardObj, 1);
				return c2;
			} else {
				return null;
			}
		default:
			return null;
		}
	}
}
