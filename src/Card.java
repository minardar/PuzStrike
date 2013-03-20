import java.util.ArrayList;

public class Card {

	public int cost;
	public int value;
	public boolean defense;
	public ArrayList<CardColor> cardColor;
	public ArrayList<Integer> effects;
	public CardType cardType;

	public Card() {
		ArrayList<CardColor> col = new ArrayList<CardColor>();
		col.add(CardColor.GREEN);
		this.cardColor = new ArrayList<CardColor>(col);
		this.cost = 1;
		this.value = 1;
		this.defense = false;
		this.effects = new ArrayList<Integer>();
		this.cardType = CardType.CIRCLE;
	}

	public Card(ArrayList<CardColor> color, int cost, CardType type,
			ArrayList<Integer> effects, boolean defense, int value) {
		this.cardColor = color;
		this.cost = cost;
		this.cardType = type;
		this.effects = effects;
		this.defense = defense;
		this.value = value;
	}

	public void use(Player p) {
		for (int e : this.effects) {
			switch (e) {
			case 1:
				p.blackTurns++;
				break;
			case 2:
				p.blueTurns++;
				break;
			case 3:
				p.brownTurns++;
				break;
			case 4:
				p.purpleTurns++;
				break;
			case 5:
				p.redTurns++;
				break;
			case 6:
				p.blackTurns += 2;
				break;
			case 7:
				p.brownTurns += 2;
				break;
			case 8:
				p.blueTurns += 2;
				break;
			case 9:
				p.blackTurns += 3;
				break;
			case 10:
				p.money++;
				break;
			case 11:
				p.money += 2;
				break;
			case 12:
				p.money += 3;
				break;
			case 13:
				draw(p, 1);
				break;
			case 14:
				draw(p, 2);
				break;
			case 15:
				draw(p, 3);
				break;
			case 16:
				draw(p, 4);
				break;
			case 17:
				wound(p);
				break;
			case 18:
				woundOpponent(p);
				break;
			case 19:
				lock(p, 1);
				break;
			case 20:
				lock(p, 2);
				break;
			case 21:
				combine(p);
				break;
			case 22:
				p.money--;
				break;
			case 23:
				crash(p, 1);
				break;
			case 24:
				crash(p, 2);
				break;
			case 25:
				trash(p);
				break;
			}

		}
	}
	/**
	 * 
	 * @param p
	 */
	public void trash(Player p){
		
	}
	/**
	 * Effect that allows player p to crash n gems in their gem pile
	 * 
	 * @param p
	 * @param n
	 */
	public void crash(Player p, int n) {

	}

	/**
	 * Effect that allows player p to combine two gems into one gem in their gem
	 * pile.
	 * 
	 * @param p
	 */
	public void combine(Player p) {

	}

	/**
	 * Effect that allows a player p to choose an opponent to wound
	 * 
	 * @param p
	 */
	private void woundOpponent(Player p) {

	}

	/**
	 * Effect that allows player p to draw n cards from his bag
	 * 
	 * @param p
	 * @param n
	 */
	public void draw(Player p, int n) {
		//p.drawFromBag(n);
	}

	/**
	 * Effect that allows player p to put a trap token on a stack in the bank,
	 * then trash this chip. Each token give a wound to each player who buys
	 * from that stack.
	 * 
	 * @param p
	 */
	public void trap(Player p) {

	}

	/**
	 * Effect that allows player p to lock a card in his hand
	 * 
	 * @param p
	 */
	public void lock(Player p, int n) {
		//p.lockedCards.add(p.hand.get(0))
	}

	/**
	 * Ongoing: Lock a card each turn, discard when you buy a purplecard
	 * 
	 * @param p
	 */
	public void ongoingLock(Player p) {

	}

	/**
	 * Wound: this player gains a wound chip
	 * 
	 * @param p
	 */
	public void wound(Player p) {
	}

	/**
	 * Risky Move: Put a gem from your hand into your gem pile. If you do, gain
	 * a gem of 1 higher value
	 * 
	 * @param p
	 */
	public void risky(Player p) {
	}
}
