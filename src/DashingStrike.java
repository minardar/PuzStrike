import java.util.ArrayList;

public class DashingStrike extends ParamCard {
		public DashingStrike() {
			this.cardColor = new ArrayList<CardColor>();
			cardColor.add(CardColor.RED);
			this.cardType = cardType.PUZZLE;
			this.defense = false;
			this.opposing = true;
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
			ArrayList<String> opponents = g.getOpponents();
			Choice c1 = new Choice("Choose an opponent to ante!", opponents, g.getOpponentsObj(), 1);
			ArrayList<String> gempile = g.getGempile();
			Choice c2 = new Choice("Choose a gem to trash!", gempile, g.getGempileObj(), 1);
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
		
		public void prepare(ArrayList<Choice> choice, Game g){
			this.setChosenEffect(choice);
			ArrayList<Player> opps = new ArrayList<Player>();
			opps.add((Player) choice.get(0).getChoice().get(0));
			this.setTargets(opps);
		}
	}