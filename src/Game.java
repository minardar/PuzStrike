import java.util.ArrayList;
import java.util.Random;


public class Game {

	public ArrayList<Card> AllCards;
	public ArrayList<Card> AlwaysCards;
	public ArrayList<Player> players;
	public ArrayList<Card> bank;
	public int turn = 0;
	public int playerNum;
	public boolean boughtSomething = false;
	public int playerMoney = 0;
	
	public Game(int number){
		this.players = new ArrayList<Player>();
		this.bank = new ArrayList<Card>();
		this.AllCards = new ArrayList<Card>();
		this.AlwaysCards = new ArrayList<Card>();
		
		//add Cards to Always Cards
		this.AlwaysCards.add(new Gem(1));
		this.AlwaysCards.add(new Crash());
		this.AlwaysCards.add(new Wound());
		this.AlwaysCards.add(new Combine());
		
		//add Cards to All Cards
		
		
		makePlayers(number);
		makeBank();		
	}
	
	public void makePlayers(int number){
		this.playerNum = number;
		this.players = new ArrayList<Player>();
		for (int i = 0; i < number; i++){
			this.players.add(new Player());
			this.players.get(i).setup();
		}
	}
	
	public void makeBank(){
		Card gem1 = this.AlwaysCards.get(0);
		gem1.setAmount(64 - this.playerNum*6);
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
	}
	
	public void newTurn(){
		this.boughtSomething = false;
		this.playerMoney = 0;
		this.players.get(this.turn).newTurn();
		if (this.turn == (this.playerNum - 1)){
			this.turn = 0;
		} else {
			this.turn++;
		}
	}
	
	public Player getCurrentPlayer(){
		return this.players.get(this.turn);
	}
	
	public void playerBuyCard(Player play, Card card){
		if (card.amount > 0 && card.cost <= this.playerMoney){
			card.amount--;
			this.playerMoney -= card.cost;
			this.boughtSomething = true;
			play.addToDiscard(card.newCard());
		}
	}
	
	public void totalMoney(){
		this.playerMoney = this.players.get(this.turn).totalMoney();
	}
	
	public boolean canBuy(Card card){
		return this.playerMoney >= card.cost;
	}
}
