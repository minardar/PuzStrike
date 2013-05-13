import java.util.ArrayList;

public class Player {

	public ArrayList<Card> hand, bag, lockedCards, discard;
	public ArrayList<Integer> toUse;
	public int[] gemPile;
	public int money, total, blackTurns, redTurns, blueTurns, purpleTurns,
			brownTurns;
	public String name;

	/**
	 * Constructor for the player class
	 */
	public Player() {
		this.gemPile = new int[4];
		this.hand = new ArrayList<Card>();
		this.bag = new ArrayList<Card>();
		this.discard = new ArrayList<Card>();
		this.lockedCards = new ArrayList<Card>();
		this.toUse = new ArrayList<Integer>();
		newTurn();
	}

	/**
	 * Sets up a player with the correct amount of cards in bag and hand
	 */
	public void setup() {

		for (int i = 0; i < 5; i++) {
			this.bag.add(new Gem(1));
		}
		for (int i = 0; i < 3; i++) {
			this.bag.add(new TrainingDay());
		}
		this.bag.add(new Crash());

	}

	/**
	 * Sets the players values to the correct values at start of turn
	 */
	public void newTurn() {
		this.money = 0;
		this.blackTurns = 1;
		this.blueTurns = 0;
		this.purpleTurns = 0;
		this.brownTurns = 0;
		this.redTurns = 0;
	}

	/**
	 * Discards hand and draws new hand at end of turn
	 */
	public void endTurn() {
		int num = this.hand.size();
		for (int i = 0; i < num; i++) {
			this.discard.add(this.hand.remove(0));
		}
		int gemHeight = (int) this.totalGemValue() / 3;
		this.drawFromBag(5 + gemHeight);
	}

	/**
	 * Player draws given n number of cards from bag
	 * 
	 * @param n
	 */
	public void drawFromBag(int n) {
		for (int i = 0; i < n; i++) {
			if (this.bag.size() == 0) {
				if (this.discard.size() == 0) {
					break;
				} else {
					this.bag = discard;
					this.discard = new ArrayList<Card>();
				}
			}

			if (lockedCards.size() > 0) {
				this.hand.add(this.lockedCards.remove(0));
			} else {
				int nextCard = (int) (Math.random() * this.bag.size());
				this.hand.add(this.bag.remove(nextCard));
			}
		}
	}

	/**
	 * Sets the player's name
	 * 
	 * @param n
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * gets the player's name
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns an integer of the total value of all the gems in the gempile
	 * combined
	 * 
	 * @return
	 */
	public int totalGemValue() {
		total = 0;
		total += gemPile[0];
		total += gemPile[1] * 2;
		total += gemPile[2] * 3;
		total += gemPile[3] * 4;
		return total;
	}
	/**
	 * Returns the amount of money the player has
	 * @return
	 */
	public int totalMoney() {
		int money = 0;
		for (int i = 0; i < this.hand.size(); i++) {
			if (this.hand.get(i).cardColor.contains(CardColor.GREEN)) {
				money += this.hand.get(i).value;
			}
		}

		return this.money + money;
	}
	/**
	 * Adds the given card to the player's discard
	 * @param card
	 */
	public void addToDiscard(Card card) {
		this.discard.add(card);
	}
	/**
	 * Adds the givenn card to the player's touse
	 * @param card
	 */
	public void addToUse(int card) {
		this.toUse.add(card);
	}

	/**
	 * Checks to see if the plaeyr can use the card
	 * @param card
	 * @return
	 */
	public boolean canUseCard(Card card) {
		if (card.cardColor.contains(CardColor.GREEN)
				|| card.cardColor.contains(CardColor.GREY)) {
			return false;
		} else if (this.blackTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.PURPLE)
				&& this.purpleTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.RED) && this.redTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.BLUE)
				&& this.blueTurns > 0) {
			return true;
		} else if (card.cardColor.contains(CardColor.BROWN)
				&& this.brownTurns > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Uses the arrow turn up on the card
	 * @param card
	 */
	public void useTurn(Card card) {
		if (card.cardColor.contains(CardColor.PURPLE) && this.purpleTurns != 0) {
			this.purpleTurns--;
		} else if (card.cardColor.contains(CardColor.RED) && this.redTurns != 0) {
			this.redTurns--;
		} else if (card.cardColor.contains(CardColor.BLUE)
				&& this.blueTurns != 0) {
			this.blueTurns--;
		} else if (card.cardColor.contains(CardColor.BROWN)
				&& this.brownTurns != 0) {
			this.brownTurns--;
		} else
			this.blackTurns--;
	}
	/**
	 * puts the card from the hand to the discard pile
	 * @param card
	 */
	public void cardWasUsed(Card card) {
		this.hand.remove(card);
		this.discard.add(card);
	}
}
