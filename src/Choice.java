import java.util.ArrayList;
import java.util.Collection;

/**
 * The choice class for dealing with options and choices on the GUI
 * 
 * @author harrissa
 * 
 */
public class Choice {
	private String instructions;
	private ArrayList<String> options;
	private ArrayList<Object> optionObjects;
	private ArrayList<Object> chosen=new ArrayList<Object>();
	private int amtOfChoices;

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
	public Choice(String inst, ArrayList<String> opt, ArrayList<Object> optObjects, int amt) {
		instructions = inst;
		options = opt;
		optionObjects = optObjects;
		amtOfChoices = amt;
	}

	/**
	 * Once the user clicks something on the GUI, this method should be used to
	 * send the choice back to the GameEngine. Send the object choice with the
	 * new choice set.
	 * 
	 * It does this by finding the chosen string in the arraylist of options.
	 * Since the arraylist of objects exactly parallel the strings, we can use
	 * that index to choose the correct object and then remove the object and
	 * its string counterpart from the arraylists
	 * 
	 * @param c
	 *            user's choice
	 */
	public void addChoice(String c) {
		int index = options.indexOf(c);
		chosen.add(optionObjects.get(index));

		options.remove(index);
		optionObjects.remove(index);

		amtOfChoices--;
	}

	public boolean nextChoice(){
		return amtOfChoices>0;
	}
	/**
	 * Method to let the game engine receive the choice that the GUI has set.
	 * 
	 * @return
	 */
	public ArrayList<Object> getChoice() {
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
}
