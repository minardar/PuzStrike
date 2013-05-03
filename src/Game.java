import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class Game {

	public ArrayList<Card> AllCards;
	public ArrayList<Card> AlwaysCards;
	public Object[] Characters = { "Rook", "Valerie", "Setsuki", "Max", "Grave" };
	public ArrayList<Player> players;
	public ArrayList<Card> bank;
	public int turn = 0;
	public int playerNum;
	public boolean boughtSomething = false;
	public int playerMoney = 0;
	public Player currentTarget = null;
	public Card lastUsedCard = null;
	public int underVal = 0;
	public int getNumber = 0;
	public Card beingUsed = null;
	public ResourceBundle names;
	public ResourceBundle choices;
	public Locale currentLocale;

	public Game(int number) {
		this.players = new ArrayList<Player>();
		this.bank = new ArrayList<Card>();
		this.AllCards = new ArrayList<Card>();
		this.AlwaysCards = new ArrayList<Card>();

		// add Cards to Always Cards
		this.AlwaysCards.add(new Gem(1));
		this.AlwaysCards.add(new Crash());
		this.AlwaysCards.add(new Wound());
		this.AlwaysCards.add(new Combine());

		// add Cards to All Cards
		ParamCard drawThree = new ParamCard();
		drawThree.DrawThree();
		this.AllCards.add(drawThree);
		ParamCard oneTwoPunch = new ParamCard();
		oneTwoPunch.OneTwoPunch();
		this.AllCards.add(oneTwoPunch);
		ParamCard roundhouse = new ParamCard();
		roundhouse.Roundhouse();
		this.AllCards.add(roundhouse);
		ParamCard oneOfEach = new ParamCard();
		oneOfEach.OneOfEach();
		this.AllCards.add(oneOfEach);
		Card dashingStrike = new DashingStrike();
		this.AllCards.add(dashingStrike);
		Card selfImprovement = new SelfImprovement();
		this.AllCards.add(selfImprovement);

		// done with cards
		makePlayers(number);
		makeBank();
		this.currentLocale = new Locale("fr", "FR");
		this.names = ResourceBundle.getBundle("Names", currentLocale);
		this.choices = ResourceBundle.getBundle("Choices", currentLocale);
	}

	public void makePlayers(int number) {
		this.playerNum = number;
		this.players = new ArrayList<Player>();
		for (int i = 0; i < number; i++) {
			this.players.add(new Player());
			this.players.get(i).setup();
		}
	}

	public void makeBank() {
		Card gem1 = this.AlwaysCards.get(0);
		gem1.setAmount(64 - this.playerNum * 6);
		this.bank.add(gem1);
		Card crash = this.AlwaysCards.get(1);
		crash.setAmount(16 - this.playerNum);
		this.bank.add(crash);
		Card wound = this.AlwaysCards.get(2);
		wound.setAmount(24);
		this.bank.add(wound);
		Card combine = this.AlwaysCards.get(3);
		combine.setAmount(20);
		this.bank.add(combine);

		for (Card card : this.AllCards) {
			card.setAmount(5);
			this.bank.add(card);
		}

	}

	public void newTurn() {
		this.boughtSomething = false;
		this.playerMoney = 0;
		this.players.get(this.turn).newTurn();
		if (this.turn == (this.playerNum - 1)) {
			this.turn = 0;
		} else {
			this.turn++;
		}
	}

	public Player getCurrentPlayer() {
		return this.players.get(this.turn);
	}

	public void playerBuyCard(Player play, Card card) {
		if (card.amount > 0 && card.cost <= this.playerMoney) {
			card.amount--;
			this.playerMoney -= card.cost;
			this.boughtSomething = true;
			play.addToDiscard(card.newCard());
		}
	}

	public void playerGetCard(Player play, Card card) {
		card.amount--;
		play.addToDiscard(card.newCard());
	}

	public void playerTrashCard(Player play, Card card) {
		play.hand.remove(card);
		for (int i = 0; i < this.bank.size(); i++) {
			if (this.bank.get(i).cardsSameKind(card)) {
				this.bank.get(i).amount++;
			}
		}
	}

	public void totalMoney() {
		this.playerMoney = this.players.get(this.turn).totalMoney();
	}

	public boolean canBuy(Card card) {
		return this.playerMoney >= card.cost;
	}

	public void setTarget(Player target, Card used) {
		this.currentTarget = target;
		this.lastUsedCard = used;
	}

	public void useCard(Card clicked) {
		getCurrentPlayer().useTurn(clicked);
		getCurrentPlayer().cardWasUsed(clicked);
		this.lastUsedCard = clicked;
	}

	public void setMiniBuy(int val, int num) {
		this.underVal = val;
		this.getNumber = num;
	}

	public void clearMiniBuy() {
		this.underVal = 0;
		this.getNumber = 0;
	}

	/**
	 * A method that will get a list of opponents in string format
	 * 
	 * @return
	 */
	public ArrayList<String> getOpponents() {
		Player p = getCurrentPlayer();
		ArrayList<Player> oppObj = players;
		ArrayList<String> oppStrings = new ArrayList<String>();
		int i = 1;
		String name;
		for (Player o : oppObj) {
			if (!p.equals(o)) {
				name = choices.getString("player") + i;
				oppStrings.add(name);
			}
			i++;
		}
		return oppStrings;
	}

	/**
	 * A method that will get a list of opponents in objects
	 * 
	 * @return
	 */
	public ArrayList<Object> getOpponentsObj() {
		ArrayList<Object> objList = new ArrayList<Object>();
		Player p = getCurrentPlayer();
		ArrayList<Player> oppObj = players;
		for (Player o : oppObj) {
			if (!p.equals(o)) {
				objList.add(o);
			}
		}
		return objList;
	}

	/**
	 * A method that will return a list of gems in the players gempile in
	 * strings
	 * 
	 * @return
	 */
	public ArrayList<String> getGempile() {
		Player p = getCurrentPlayer();
		int[] gempile = p.gemPile;
		ArrayList<String> gemStrings = new ArrayList<String>();
		int whichGem = 1;
		for (int gems : gempile) {
			for (int i = 0; i < gems; i++) {
				gemStrings.add(Integer.toString(whichGem) +" "+ choices.getString("gem"));
				}
			whichGem++;
		}
		return gemStrings;
	}

	/**
	 * A method that will return a list of gems in the players gempile in
	 * objects
	 * 
	 * @return
	 */
	public ArrayList<Object> getGempileObj() {
		ArrayList<Object> objList = new ArrayList<Object>();
		Player p = getCurrentPlayer();
		int[] gempile = p.gemPile;
		int whichGem = 1;
		for (int gems : gempile) {
			for (int i = 0; i < gems; i++) {
				objList.add(whichGem - 1);
			}
			whichGem++;
		}
		return objList;
	}

	/**
	 * A method that will return a list of cards in the player's hand in strings
	 * 
	 * @return
	 */
	public ArrayList<String> getHand(Card usedCard) {
		Player p = getCurrentPlayer();
		ArrayList<Card> h = p.hand;
		ArrayList<String> handStrings = new ArrayList<String>();
		for (Card card : h) {
			if (!card.equals(usedCard)) {
				handStrings.add(card.getName(this));
			}
		}
		return handStrings;
	}

	/**
	 * A method that will return a list of cards in the player's hand in objects
	 * 
	 * @return
	 */
	public ArrayList<Object> getHandObj(Card usedCard) {
		ArrayList<Object> objList = new ArrayList<Object>();
		Player p = getCurrentPlayer();
		ArrayList<Card> h = p.hand;
		for (Card card : h) {
			if (!card.equals(usedCard)) {
				objList.add(card);
			}
		}
		return objList;
	}

	/**
	 * A method that will return a list of cards in the player's hand in Strings
	 * excluding the cards in excluding
	 * 
	 * @param ArrayList
	 *            <Card> excluding
	 * @return
	 */
	public ArrayList<String> getHand(ArrayList<Card> excluding, Card usedCard) {
		Player p = getCurrentPlayer();
		ArrayList<Card> h = p.hand;
		ArrayList<String> handStrings = new ArrayList<String>();
		for (Card card : h) {
			if (!card.equals(usedCard)) {
				for (Card excl : excluding) {
					if (!card.cardsSameKind(excl)) {
						handStrings.add(card.getName(this));
					}
				}
			}
		}
		return handStrings;
	}

	/**
	 * A method that will return a list of cards in the player's hand in objects
	 * excluding the cards in excluding
	 * 
	 * @param ArrayList
	 *            <Card> excluding
	 * @return
	 */
	public ArrayList<Object> getHandObj(ArrayList<Card> excluding, Card usedCard) {
		ArrayList<Object> objList = new ArrayList<Object>();
		Player p = getCurrentPlayer();
		ArrayList<Card> h = p.hand;
		for (Card card : h) {
			if (!card.equals(usedCard)) {
				for (Card excl : excluding) {
					if (!card.cardsSameKind(excl)) {
						objList.add(card);
					}
				}
			}
		}
		return objList;
	}

	/**
	 * A method that will return a list of cards in the player's bag in strings
	 * 
	 * @return
	 */
	public ArrayList<String> getBag() {
		Player p = getCurrentPlayer();
		ArrayList<Card> b = p.bag;
		ArrayList<String> bagStrings = new ArrayList<String>();
		for (Card card : b) {
			bagStrings.add(card.getName(this));
		}
		return bagStrings;
	}

	/**
	 * A method that will return a list of cards in the player's bag in objects
	 * 
	 * @return
	 */
	public ArrayList<Object> getBagObj() {
		ArrayList<Object> objList = new ArrayList<Object>();
		Player p = getCurrentPlayer();
		ArrayList<Card> b = p.bag;
		for (Card card : b) {
			objList.add(card);
		}
		return objList;
	}

	public void setLocale(String lang) {
		String target = lang.toLowerCase();
		if (target.equals("french")) {
			this.currentLocale = new Locale("fr", "FR");
		}
		if (target.equals("english")) {
			this.currentLocale = new Locale("en", "US");
		}
		this.names = ResourceBundle.getBundle("Names", this.currentLocale);
	}

	public ArrayList<Card> getPlayerCards(int i) {
		ArrayList<Card> playerCards = new ArrayList<Card>();
		switch (i) {
		case 0:
			playerCards.add(new StoneWall());
			playerCards.add(new StrengthOfEarth());
			playerCards.add(new BigRocks());
			break;
		case 1:
			playerCards.add(new ChromaticOrb());
			playerCards.add(new CreativeThoughts());
			ParamCard threeColors = new ParamCard();
			threeColors.ThreeColors();
			playerCards.add(threeColors);
			break;
		// case 2: playerCards.add(new SpeedOfTheFox());
		// playerCards.add(new BagOfTricks());
		// playerCards.add(new DoubleTake());
		// break;
		// case 3: playerCards.add(new Research&Development());
		// playerCards.add(new FutureSight());
		// playerCards.add(new ItsTimeForThePast());
		// break;
		// case 4: playerCards.add(new Reversal());
		// playerCards.add(new MartialMastery());
		// playerCards.add(new VersatileStyle());
		// break;
		default:
			playerCards.add(new StoneWall());
			playerCards.add(new StrengthOfEarth());
			playerCards.add(new BigRocks());
			break;
		}
		return playerCards;

	}

	public void setCharacter(int player, int character) {
		ArrayList<Card> cards = getPlayerCards(character);

		for (int i = 0; i < 3; i++) {
			this.players.get(player).bag.add(cards.get(i));
		}
		this.players.get(player).drawFromBag(5);
	}
}
