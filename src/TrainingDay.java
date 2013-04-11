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

	
	public void use(ArrayList<Choice> choices) {
		Choice cardChoice = choices.get(0);
		Card keep = (Card) cardChoice.getChoice().get(0);
		Card trash = (Card) cardChoice.getChoice().get(1);
		Player player = cardChoice.getCurrentPlayer();
		player.lockedCards.add(keep);
		player.hand.remove(keep);
		cardChoice.getGame().playerTrashCard(player, trash);
		int val = trash.cost + 2;
		int num = 1;
		cardChoice.getGame().setMiniBuy(val, num);
	}
	
	
	public ArrayList<Choice> getChoice(Game g) {
		ArrayList<String> cards = this.getHand(g);
		Choice c1 = new Choice(g, "Choose card to keep, then on to trash.", cards, this.objList, 2);
		ArrayList<Choice> choices = new ArrayList<Choice>();
		choices.add(c1);
		return choices;
	}
	
	
	public Card newCard(){
		return new TrainingDay();
	}
}

