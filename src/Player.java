import java.util.ArrayList;


public class Player {

	public ArrayList<Card> hand, bag, lockedCards, discard, toUse;
	public int[] gemPile;
	public int money, total, blackTurns, redTurns, blueTurns, purpleTurns, brownTurns;
	
	public Player(){
		this.gemPile = new int[4];
		this.hand = new ArrayList<Card>();
		this.bag = new ArrayList<Card>();
		this.discard = new ArrayList<Card>();
		this.lockedCards = new ArrayList<Card>();
		this.toUse = new ArrayList<Card>();
		newTurn();
	}
	
	public void setup() {
		Card initGem = new Card();
		for (int i = 0; i < 5; i++) {
			this.bag.add(initGem);
		}
		
		ArrayList<CardColor> w = new ArrayList<CardColor>();
		w.add(CardColor.GREY);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(17);
		Card wound = new Card("Wound", w, 5, CardType.CIRCLE, e, false, 0);
		for (int i = 0; i < 3; i++) {
			this.bag.add(wound);
		}
		
		w = new ArrayList<CardColor>();
		w.add(CardColor.PURPLE);
		e = new ArrayList<Integer>();
		e.add(23);
		Card crash = new Card("CrashGem", w, 1, CardType.CIRCLE, e, false, 1, 1, 1, 0);
		this.bag.add(crash);
		
		this.gemPile[0] += 1;
		this.drawFromBag(5);
	}

	public void newTurn() {
		this.money = 0;
		this.blackTurns = 1;
		this.blueTurns = 0;
		this.purpleTurns = 0;
		this.brownTurns = 0;
		this.redTurns = 0;
	}
	
	public void endTurn() {
		int num = this.hand.size();
		for (int i = 0; i < num; i++) {
			this.discard.add(this.hand.remove(0));
		}
		
		this.drawFromBag(5);
	}
	
	public void drawFromBag(int n) {
		for (int i = 0; i < n; i++) {
			if (this.bag.size() == 0) {
				this.bag = discard;
				this.discard = new ArrayList<Card>();
			}
			
			if (lockedCards.size() > 0) {
				this.hand.add(this.lockedCards.remove(0));
			} else {
				int nextCard = (int) (Math.random() * this.bag.size());
				this.hand.add(this.bag.remove(nextCard));
			}
		}
	}
	
	public int totalGemValue() {
		total = 0;
		total += gemPile[0];
		total += gemPile[1] * 2;
		total += gemPile[2] * 3;
		total += gemPile[3] * 4;
		return total;
	}
	
	public int totalMoney() {
		money = 0;
		for (int i = 0; i < this.hand.size(); i++) {
			if (this.hand.get(i).cardColor.contains(CardColor.GREEN)){
				money += this.hand.get(i).value;
			}
		}
		
		return money;
	}
	
	public void addToDiscard(Card card) {
		this.discard.add(card);
	}
	
	public void addToUse(Card card) {
		this.toUse.add(card);
	}
	
	public boolean canUseCard(Card card) {
		if (this.blackTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.PURPLE) && this.purpleTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.RED) && this.redTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.BLUE) && this.blueTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.BROWN) && this.brownTurns > 0) {
			return true;
		} else return false;
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
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public ArrayList<Card> getBag() {
		return this.bag;
	}
	
	public ArrayList<Card> getDiscard() {
		return this.discard;
	}
}
