import java.util.ArrayList;

public class ParamCard extends Card {

	public ParamCard(String name) {
		this.cardColor.add(CardColor.BROWN);
		this.cardType = cardType.PUZZLE;
		this.defense = false;
		this.value = 0;
		this.name = name;
		this.imagePath = name + ".png";

		if (name == "DrawThree") {
			this.cost = 3;
		} else if (name == "OneTwoPunch") {
			this.cost = 4;
		} else if (name == "Roundhouse") {
			this.cost = 4;
		} else {
			this.cost = 5;
		}
	}

	@Override
	public void use(ArrayList<Choice> choices) {
		Player p = choices.get(0).getCurrentPlayer();
		
		if (name == "DrawThree") {
			p.drawFromBag(3);
		} else if (name == "OneTwoPunch") {
			p.blackTurns += 2;
		} else if (name == "Roundhouse") {
			p.blackTurns += 1;
			p.drawFromBag(2);
		} else {
			p.drawFromBag(1);
			p.blackTurns += 1;
			p.money += 1;
		}
	}

	@Override
	public ArrayList<Choice> getChoice(Game g) {
		return null;
	}

	@Override
	public Card newCard() {
		return new ParamCard(this.name);
	}

	public static Card newCard(String name) {
		return new ParamCard(name);
	}
}
