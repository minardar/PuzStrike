import java.util.ArrayList;

public class ChoiceGroup {
	public int whichChoice;
	public ArrayList<Choice> choices;

	public ChoiceGroup() {
		this.whichChoice = 0;
		this.choices = new ArrayList<Choice>();
	}

	public void addChoiceToGroup(Choice choice) {
		this.choices.add(choice);
	}

	public Choice getNextChoice() {

		if (choices.isEmpty()) {
			System.out.println("Empty");
			return null;
		} else if (!choices.get(whichChoice).nextChoice()) {
			this.whichChoice++;
			if (this.choices.size() >= (this.whichChoice + 1)) {
				return choices.get(whichChoice);
			} else {
				System.out.println("Out of bounds");
				return null;
			}
		} else {
			return choices.get(whichChoice);
		}
	}

	public void startOver() {
		this.whichChoice = 0;
	}

	public ArrayList<Choice> getChoiceList() {
		return this.choices;
	}

}
