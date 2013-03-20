import java.util.ArrayList;


public class Player {

	public ArrayList<Card> gemPile;
	public ArrayList<Card> hand;
	public ArrayList<Card> bag;
	public ArrayList<Card> discard;
	public int money;
	public int blackTurns;
	public int redTurns;
	public int blueTurns;
	public int purpleTurns;
	public int brownTurns;
	
	public Player(){
		this.gemPile = new ArrayList<Card>();
		this.hand = new ArrayList<Card>();
		this.bag = new ArrayList<Card>();
		this.discard = new ArrayList<Card>();
		newTurn();
	}

	public void newTurn() {
		this.money = 0;
		this.blackTurns = 1;
		this.blueTurns = 0;
		this.purpleTurns = 0;
		this.brownTurns = 0;
		this.redTurns = 0;
	}
	
	public void drawFromBag(int n) {
		for (int i = 0; i < n; i++) {
			if (bag.size() == 0) {
				bag = discard;
				discard = new ArrayList<Card>();
			}
			int nextCard = (int) Math.random() * bag.size();
			System.out.println(nextCard);
			hand.add(bag.remove(nextCard));
		}
	}
	
	public void setHand(ArrayList<Card> cards) {
		this.hand = cards;
	}
	
	public void setBag(ArrayList<Card> cards) {
		this.bag = cards;
	}
	
	public void setDiscard(ArrayList<Card> cards) {
		this.discard = cards;
	}
	
	public void setGemPile(ArrayList<Card> cards) {
		this.gemPile = cards;
	}
}
