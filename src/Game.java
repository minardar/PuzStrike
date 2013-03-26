import java.util.ArrayList;
import java.util.Random;


public class Game {

	public Card[] AllCards = {new Card()};
	public ArrayList<Player> players;
	public ArrayList<Card> bank;
	public int turn = 0;
	public int playerNum;
	public boolean boughtSomething = false;
	
	public Game(){
		this.players = new ArrayList<Player>();
		this.bank = new ArrayList<Card>();
		makeBank();		
	}
	
	public void makePlayers(int number){
		this.playerNum = number;
		for (int i = 0; i < number; i++){
			this.players.add(new Player());
			this.players.get(i).setup();
		}
	}
	
	public void makeBank(){
		for (int i = 0; i < 10; i++){
			if (i < this.AllCards.length){
				Random generator = new Random();
				int randomIndex = generator.nextInt(this.AllCards.length);
				while (this.bank.contains(this.AllCards[randomIndex])){
					randomIndex = generator.nextInt(this.AllCards.length);
				}
				this.bank.add(this.AllCards[randomIndex]);
			} else {
				break;
			}
		}
		
	}
	
	public void newTurn(){
		this.boughtSomething = false;
		if (this.turn == (this.playerNum - 1)){
			this.turn = 0;
		} else {
			this.turn++;
		}
	}
	
	
}
