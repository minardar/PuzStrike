import java.util.ArrayList;

/**
 * The choice class for dealing with options and choices on the GUI
 * 
 * @author harrissa
 * 
 */
public class Choice {
	private Game g;
	private Player currentPlayer;
	private String instructions;
	private ArrayList<String> options;
	private String button;
	private String chosen;

	/**
	 * Choice constructor takes the game, instructoin, options, and button
	 * 
	 * @param ga
	 *            This is the current game
	 * @param inst
	 *            The instructions that will display on the GUI
	 * @param opt
	 *            The options that the user will choose from
	 * @param but
	 *            The text on the button the user will click
	 */
	public Choice(Game ga, String inst, ArrayList<String> opt, String but) {
		g = ga;
		currentPlayer = ga.getCurrentPlayer();
		instructions = inst;
		options = opt;
		button = but;
	}

	/**
	 * Once the user clicks something on the GUI, this method should be used to
	 * send the choice back to the GameEngine. Send the object choice with the
	 * new choice set.
	 * 
	 * @param c
	 *            user's choice
	 */
	public void setChoice(String c) {
		chosen = c;
	}

	/**
	 * Method to let the game engine receive the choice that the GUI has set.
	 * 
	 * @return
	 */
	public String getChoice() {
		return chosen;
	}

	/**
	 * A method that the GUI can use to get the instruction string
	 * 
	 * @return
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * A method that the GUI can use to get the different options in this choice
	 * class
	 * 
	 * @return
	 */
	public ArrayList<String> getOptions() {
		return options;
	}

	/**
	 * A method that the GUI can use to get the button text for this choice.
	 * 
	 * @return
	 */
	public String getButton() {
		return button;
	}

	/**
	 * A method that the card class can use to grab the current player without
	 * knowing the game.
	 * 
	 * @return
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
