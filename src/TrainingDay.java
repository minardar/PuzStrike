import java.util.ArrayList;


public class TrainingDay extends TrickyCard {

	
	public TrainingDay() {
		this.imagePath = "TrainingDay.png";
		this.cardColor.add(CardColor.BROWN);
		this.cardType = cardType.PUZZLE;
		this.defense = false;
		this.name = "TrainingDay";
		this.value = 0;
		this.cost = 2;
	}

	
	public void use(ArrayList<Choice> choices, Game game) {
		Card keep = (Card) choices.get(0).getChoice().get(0);
		Card trash = (Card) choices.get(1).getChoice().get(0);
		Player player = game.getCurrentPlayer();
		player.lockedCards.add(keep);
		player.hand.remove(keep);
		game.playerTrashCard(player, trash);
		int val = trash.cost + 2;
		int num = 1;
		game.setMiniBuy(val, num);
	}
	
	
	public ChoiceGroup getChoice(Game g) {
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}
	
	
	public Card newCard(){
		return new TrainingDay();
	}


	@Override
	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch(i){
			case 1:
				ArrayList<String> cards = g.getHand(this);
				ArrayList<Object> cardObj = g.getHandObj(this);
				if(cards.isEmpty()){
					return null;
				}
				Choice c1 = new Choice(g.choices.getString("cardKeep"), cards, cardObj, 1);
				return c1;
			case 2:
				ArrayList<Card> excl = new ArrayList<Card>();
				excl.add(new Crash());
				excl.add(new DoubleCrash());
				ArrayList<String> cards2 = g.getHand(excl, this, false);
				ArrayList<Object> cardObj2 = g.getHandObj(excl, this, false);
				Card magic = (Card) choice.getChoice().get(0);
				cards2.remove(magic.getName(g));
				cardObj2.remove(magic);
				if(cards2.isEmpty()){
					return null;
				}
				Choice c2 = new Choice(g.choices.getString("cardTrash"), cards2, cardObj2, 1);
				return c2;
			default:
				return null;
		}
	}
}

