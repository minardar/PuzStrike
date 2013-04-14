import java.util.ArrayList;

public class ParamCard extends Card {

	private Player currentPlayer;
	int blackTurns, purpleTurns, redTurns, brownTurns, blueTurns, draw, money;

	public ParamCard(String name) {
		this.cardColor.add(CardColor.BROWN);
		this.cardType = cardType.PUZZLE;
		this.defense = false;
		this.value = 0;
		this.name = "";
		this.imagePath = name + ".png";
		this.cost = 0;
		
		int blackTurns = 0, purpleTurns = 0, redTurns = 0, brownTurns = 0, blueTurns = 0, draw = 0, money = 0;
	}
	
	public void DrawThree() {
		makeDrawThree();
	}
	
	public void OneTwoPunch() {
		makeOneTwoPunch();
	}

	@Override
	public void use(ArrayList<Choice> choices) {
		Player p = this.currentPlayer;
		p.blackTurns += blackTurns;
		p.purpleTurns += purpleTurns;
		p.redTurns += redTurns;
		p.brownTurns += brownTurns;
		p.blueTurns += blueTurns;
		p.money += money;
		p.drawFromBag(draw);
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
	
	public void makeDrawThree() {
		this.name = "DrawThree";
		this.imagePath = name + ".png";
		this.cost = 3;
		draw += 3;
	}

	private void makeOneTwoPunch() {
		this.name = "DrawThree";
		this.imagePath = name + ".png";
		this.cost = 4;
		blackTurns += 2;
	}
	
	public void makeRoundHouse() {
		this.name = "DrawThree";
		this.imagePath = name + ".png";
		this.cost = 6;
		blackTurns += 1;
		draw += 2;
	}
	
	public void makeOneOfEach() {
		this.name = "DrawThree";
		this.imagePath = name + ".png";
		this.cost = 5;
		blackTurns += 1;
		draw += 1;
		money += 1;
	}
}
