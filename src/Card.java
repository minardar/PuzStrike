import java.util.ArrayList;
import java.util.Arrays;

public class Card {

	public int cost;
	public int value;
	public boolean defense;
	public ArrayList<CardColor> cardColor;
	public ArrayList<Integer> effects;
	public CardType cardType;
	public String name;

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

	public Card(String name, ArrayList<CardColor> color, int cost, CardType type,
			ArrayList<Integer> effects, boolean defense, int value) {
		this.name = name;
		this.cardColor = color;
		this.cost = cost;
		this.cardType = type;
		this.effects = effects;
		this.defense = defense;
		this.value = value;
	}
	public void use(Player user){
		useHelper(user, null);
	}
	public void use (Player user, Player opponent){
		useHelper(user, opponent);
	}
	public void use(Player user, int...choose){
		useHelper(user, null, choose);
	}
	public void use(Player user, Player opponent, int...choose){
		useHelper(user, opponent, choose);
	}
	public void useHelper(Player p, Player opponent, int...choose) {
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
				wound(opponent);
				break;
			case 19:
				lock(p, choose[0]);
				break;
			case 20:
				lock(p, choose[0], choose[1]);
				break;
			case 21:
				combine(p, choose[0],choose[1]);
				break;
			case 22:
				p.money--;
				break;
			case 23:
				crash(p,opponent, choose[0]);
				break;
			case 24:
				crash(p, opponent, choose[0], choose[1]);
				break;
			case 25:
				trashHand(p, choose[0]);
				break;
			}

		}
	}
	/**
	 * 
	 * @param p
	 */
	public void trashHand(Player p, int card){
		p.hand.remove(card);
	}
	/**
	 * Effect that allows player p to crash n gems in their gem pile
	 * 
	 * @param p
	 * @param n
	 */
	public void crash(Player crasher, Player crashee, int... gems) {
		for(int i : gems){
//			crasher.gemPile.set(i, crasher.gemPile.get(i)--);
//			crashee.gemPile.set(0, crashee.gemPile.get(0)+i+1);
		}
	}

	/**
	 * Effect that allows player p to combine two gems into one gem in their gem
	 * pile.
	 * 
	 * @param p
	 */
	public void combine(Player p, int...gems) {
		int v= gems[0] + gems[1]+1;
		if(v<3){
//			p.gemPile.set(gems[0], p.gemPile.get(gems[0])--);
//			p.gemPile.set(gems[1], p.gemPile.get(gems[1])--);
//			p.gemPile.set(v, p.gemPile.get(v)++);
		}
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
		p.drawFromBag(n);
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
	public void lock(Player p, int... cards) {
		Arrays.sort(cards);
		for(int counter=cards.length-1; counter>=0;counter--){
			p.lockedCards.add(p.hand.get(cards[counter]));
			p.hand.remove(cards[counter]);
		}
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
		Card newWound = new Card("Wound",colorList(CardColor.GREY), 0, CardType.CIRCLE, new ArrayList(), false, 0);
		p.bag.add(newWound);
	}

	/**
	 * Risky Move: Put a gem from your hand into your gem pile. If you do, gain
	 * a gem of 1 higher value
	 * 
	 * @param p
	 */
	public void risky(Player p) {
	}
	public ArrayList<CardColor> colorList(CardColor...col){
		ArrayList<CardColor> colors = new ArrayList<CardColor>();
		for (CardColor c : col){
			colors.add(c);
		}
		return colors;
	}
}
