import java.util.ArrayList;

public class ParamCard extends Card {

	private Player currentPlayer;

	public ParamCard(String name) {
		
		int blackTurns = 0, purpleTurns = 0, redTurns = 0, brownTurns = 0, blueTurns = 0, draw = 0, money = 0;
		
		if (name == "DrawThree") {
			cost = 3;
			draw += 3;
		} else if (name == "OneTwoPunch") {
			cost = 4;
			blackTurns += 2;
		} else if (name == "Roundhouse") {
			cost = 6;
			blackTurns += 1;
			draw += 2;
		} else if (name == "OneOfEach"){
			cost = 5;
			draw += 1;
			blackTurns += 1;
			money += 1;
		}
		
		public Card DrawThree() {
			return new DrawThreeCard();
		}
	}

	@Override
	public void use(ArrayList<Choice> choices) {
		Player p = this.currentPlayer;

	}

	@Override
	public ChoiceGroup getChoice(Game g) {
		return new ChoiceGroup;
	}

	@Override
	public Card newCard() {
		return new ParamCard(this.name);
	}

	public static Card newCard(String name) {
		return new ParamCard(name);
	}
	
	public class DrawThreeCard extends Card {
		
		public DrawThreeCard() {
			this.cardColor.add(CardColor.BROWN);
			this.cardType = cardType.PUZZLE;
			this.defense = false;
			this.value = 0;
			this.name = "DrawThree";
			this.imagePath = name + ".png";
			this.cost = 4;
		}

		@Override
		public ArrayList<Choice> getChoice(Game g) {
			
		}

		@Override
		public void use(ArrayList<Choice> choices) {
			
			
		}

		@Override
		public Card newCard() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
