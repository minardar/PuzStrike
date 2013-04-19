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
	
	public ParamCard DashingStrike() {
		//this.setEqual(new DashingStrike());
		return new DashingStrike();
	}
	
	public ParamCard SelfImprovement() {
		//this.setEqual(new SelfImprovement());
		return new SelfImprovement();
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
	
	public class DashingStrike extends ParamCard {
		public DashingStrike() {
			this.cardColor = new ArrayList<CardColor>();
			cardColor.add(CardColor.RED);
			this.cardType = cardType.PUZZLE;
			this.defense = false;
			this.cost = 4;
			this.name = "DashingStrike";
			this.imagePath = name + ".png";     
			this.brownTurns += 1;
		}
		
		public void use(ArrayList<Choice> choices, Game game) {
			super.use(choices, game);
			Choice oppChoice = choices.get(0);
			Choice gemChoice = choices.get(1);
			Player crashee = (Player) oppChoice.getChoice().get(0);
			Player crasher = game.getCurrentPlayer();
			int gem = (Integer) gemChoice.getChoice().get(0);
			crasher.gemPile[gem] = crasher.gemPile[gem] - 1;
			crashee.gemPile[0] = crashee.gemPile[0] + gem + 1;
			crasher.money++;
		}
		
		public ChoiceGroup getChoice(Game g) {
			ArrayList<String> opponents = this.getOpponents(g);
			Choice c1 = new Choice("Choose an opponent to ante!", opponents, this.objList, 1);
			ArrayList<String> gempile = this.getGempile(g);
			Choice c2 = new Choice("Choose a gem to trash!", gempile, this.objList, 1);
			ChoiceGroup choices = new ChoiceGroup();
			choices.addChoiceToGroup(c1);
			choices.addChoiceToGroup(c2);
			return choices;
		}
		
		public Card newCard() {
			ParamCard newCard = new ParamCard();
			newCard.setEqual(this);
			return newCard;
		}
		
		public void setEqual(ParamCard card) {
			super.setEqual(card);
		}
	}
	
	public class SelfImprovement extends ReactionCard {
		public SelfImprovement() {
			this.cardColor = new ArrayList<CardColor>();
			cardColor.add(CardColor.BLUE);
			this.cardType = cardType.PUZZLE;
			this.defense = true;
			this.cost = 4;
			this.name = "SelfImprovement";
			this.imagePath = name + ".png";     
		}
		
		public void use(ArrayList<Choice> choices, Game game) {
			super.use(choices, game);
			Choice cardChoice = choices.get(0);
			Card card = (Card) cardChoice.getChoice().get(0);
			p.hand.remove(card);
		}
		
		public ChoiceGroup getChoice(Game g) {
			ArrayList<String> hand = this.getHand(g);
			Choice c1 = new Choice("Choose a card to trash!", hand, this.objList, 1);
			ChoiceGroup choices = new ChoiceGroup();
			choices.addChoiceToGroup(c1);
			return choices;
		}
		
		public Card newCard() {
			ParamCard newCard = new ParamCard();
			newCard.setEqual(this);
			return newCard;
		}
		
		public void setEqual(ParamCard card) {
			super.setEqual(card);
		}
		
		public void react(Card card, Player reacting, ArrayList<Choice> choices, Game game) {
			reacting.drawFromBag(3);
		}

		public boolean canReactTo(Card card) {
			if (card.cardColor.contains(CardColor.RED)) return true;
			else return false;
		}
		
		public ChoiceGroup getReactChoices(Game g) {
			return new ChoiceGroup();
		}
	}

	@Override
	public void prepare(ArrayList<Choice> choice, Game g) {
		this.setChosenEffect(choice);
		this.setTargets(new ArrayList<Player>());
	}
	
}
