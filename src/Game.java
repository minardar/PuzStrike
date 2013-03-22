import java.util.ArrayList;


public class Game {

	public ArrayList<Player> players;
	public ArrayList<Card> bank;
	
	public Game(){
		this.players = new ArrayList<Player>();
		this.bank = new ArrayList<Card>();
		
	}
	
	public void makePlayers(int number){
		for (int i = 1; i <= number; i++){
			this.players.add(new Player());
		}
	}
	
	public void makeBank(){
		//later this method should select random cards from implemented cards
		for (int i = 1; i <= 10; i++){
			this.bank.add(new Card());
		}
		//later this should be replaced by specific gem cards etc
		for (int i = 1; i <= 8; i++){
			this.bank.add(new Card());
		}
	}
	
}
