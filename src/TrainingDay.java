import java.util.ArrayList;


public class TrainingDay extends Card {

	
	public TrainingDay() {
		this.imagePath = "TrainingDay.png";
		this.cardColor.add(CardColor.BROWN);
		this.cardType = cardType.PUZZLE;
		this.defense = false;
		this.name = "Training Day";
		this.value = 0;
		this.cost = 2;
	}

	
	public void use(ArrayList<Choice> choices, Game game) {
		Choice cardChoice = choices.get(0);
		Card keep = (Card) cardChoice.getChoice().get(0);
		Card trash = (Card) cardChoice.getChoice().get(1);
		Player player = game.getCurrentPlayer();
		player.lockedCards.add(keep);
		player.hand.remove(keep);
		game.playerTrashCard(player, trash);
		int val = trash.cost + 2;
		int num = 1;
		game.setMiniBuy(val, num);
	}
	
	
	public ChoiceGroup getChoice(Game g) {
		ArrayList<String> cards = this.getHand(g);
		Choice c1 = new Choice("Choose card to keep, then on to trash.", cards, this.objList, 2);
		ChoiceGroup choices = new ChoiceGroup();
		choices.addChoiceToGroup(c1);
		return choices;
	}
	
	
	public Card newCard(){
		return new TrainingDay();
	}
}

