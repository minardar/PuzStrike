import java.util.ArrayList;

public class ChoiceGroup {
	public int whichChoice;
	public ArrayList<Choice> choices;
	/**
	 * Constructor for choicegroup class
	 */
	public ChoiceGroup() {
		this.whichChoice = 0;
		this.choices = new ArrayList<Choice>();
	}
	/**
	 * adds the given choice to the choicegroup
	 * @param choice
	 */
	public void addChoiceToGroup(Choice choice) {
		this.choices.add(choice);
	}
	
	/**
	 * returns the next choice in the choicegroup
	 * @return
	 */
	public Choice getNextChoice() {

		if (choices.isEmpty()) {
			return null;
		} else if (!choices.get(whichChoice).nextChoice()) {
			this.whichChoice++;
			if (this.choices.size() >= (this.whichChoice + 1)) {
				return choices.get(whichChoice);
			} else {
				return null;
			}
		} else {
			return choices.get(whichChoice);
		}
	}

	/**
	 * gets the current list of choices and returns it
	 * @return ArrayList<Choice>
	 */
	public ArrayList<Choice> getChoiceList() {
		return this.choices;
	}

}
