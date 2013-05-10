import java.util.ArrayList;

public class ParamCard extends Card {

	private Player p;
	int blackTurns, purpleTurns, redTurns, brownTurns, blueTurns, draw, money;

	public ParamCard() {
		this.cardColor.add(CardColor.BROWN);
		this.cardType = cardType.PUZZLE;
		this.defense = false;
		this.value = 0;
		this.name = "";
		this.imagePath = name + ".png";
		this.cost = 0;
		
		int blackTurns = 0, purpleTurns = 0, redTurns = 0, brownTurns = 0, blueTurns = 0, draw = 0, money = 0;
	}

	@Override
	public void use(ArrayList<Choice> choices, Game game) {
		p = game.getCurrentPlayer();
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
		return new ChoiceGroup();
	}

	@Override
	public Card newCard() {
		ParamCard newCard = new ParamCard();
		newCard.setEqual(this);
		return newCard;
	}
	
	public void setEqual(ParamCard card) {
		this.cardColor = card.cardColor;
		this.cardType = card.cardType;
		this.defense = card.defense;
		this.value = card.value;
		this.name = card.name;
		this.imagePath = card.imagePath;
		this.cost = card.cost;
		this.blackTurns = card.blackTurns;
		purpleTurns = card.purpleTurns;
		redTurns = card.redTurns;
		brownTurns = card.brownTurns;
		blueTurns = card.blueTurns;
		draw = card.draw;
		money = card.money;
	}
	
	public void DrawThree() {
		this.name = "DrawThree";
		this.imagePath = name + ".png";
		this.cost = 3;
		draw += 3;
	}
	public void ThreeColors() {
		this.name = "ThreeColors";
		this.imagePath= "/Valerie/"+name+".png";
		this.redTurns+=1;
		this.blueTurns+=1;
		this.brownTurns+=1;
	}
	
	public void OneTwoPunch() {
		this.name = "OneTwoPunch";
		this.imagePath = name + ".png";
		this.cost = 4;
		blackTurns += 2;
	}
	
	public void Roundhouse() {
		this.name = "Roundhouse";
		this.imagePath = name + ".png";
		this.cost = 6;
		blackTurns += 1;
		draw += 2;
	}
	
	public void OneOfEach() {
		this.name = "OneOfEach";
		this.imagePath = name + ".png";
		this.cost = 5;
		blackTurns += 1;
		draw += 1;
		money += 1;
	}
	
	public void BagOfTricks() {
		this.name = "BagOfTricks";
		this.imagePath = "/Setsuki/" + name + ".png";
		brownTurns += 1;
		draw += 1;
	}
	
	public void SpeedOfTheFox() {
		this.name = "SpeedOfTheFox";
		this.imagePath = "/Setsuki/" + name + ".png";
		brownTurns += 2;
		draw += 1;
	}
	
	public void FutureSight() {
		this.name = "FutureSight";
		this.imagePath = "/Max/" + name + ".png";
		draw += 2;
	}
	
	public void TroublesomeRhetoric() {
		this.name = "TroublesomeRhetoric";
		this.imagePath = "/DeGray/" + name + ".png";
		blackTurns += 1;
		draw += 1;
		money += 2;
	}
	
	public void VersatileStyle () {
		this.name = "VersatileStyle";
		this.imagePath = "/Grave/" + name + ".png";
		blackTurns += 1;
		draw += 2;
		money += 2;
	}
	
	public class Recklessness extends ParamCard{
		public Recklessness() {
			this.name = "Recklessness";
			this.imagePath = name + ".png";
			this.cost = 2;
			draw += 3;
		}

		public ChoiceGroup getChoice(Game g) {
			return super.getChoice(g);
		}

		public void use(ArrayList<Choice> choices, Game game) {
			super.use(choices, game);
			p.discard.add(new Wound());
		}

		public Card newCard() {
			return super.newCard();
		}
	}
	
	public class ItsComboTime extends ParamCard{
		public ItsComboTime() {
			this.name = "ItsComboTime";
			this.imagePath = name + ".png";
			this.cost = 8;
			draw += 4;
			blackTurns += 1;
		}

		public ChoiceGroup getChoice(Game g) {
			return super.getChoice(g);
		}

		public void use(ArrayList<Choice> choices, Game game) {
			super.use(choices, game);
		}

		public Card newCard() {
			return super.newCard();
		}
	}

	@Override
	public void prepare(ArrayList<Choice> choice, Game g) {
		this.setChosenEffect(choice);
		this.setTargets(new ArrayList<Player>());
	}
	
}
