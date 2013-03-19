import java.util.ArrayList;


public class Player {

	public ArrayList<Integer> gemPile;
	public int money;
	public int blackTurns;
	public int redTurns;
	public int blueTurns;
	public int purpleTurns;
	public int brownTurns;
	
	public Player(){
		this.gemPile = new ArrayList<Integer>();
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
	
	
}
