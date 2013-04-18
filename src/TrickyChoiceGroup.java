
public class TrickyChoiceGroup extends ChoiceGroup {

	public TrickyCard card;
	public Game game;
	
	public TrickyChoiceGroup(TrickyCard card, Game game){
		super();
		this.card = card;
		this.game = game;
	}
	
	@Override
	public Choice getNextChoice(){
			
		
		Choice prevChoice = null;
		if (super.whichChoice >= 1){
			prevChoice = super.choices.get(super.whichChoice-1);
			
			if (prevChoice.nextChoice()){
				return prevChoice;
			}
		}
		
		super.whichChoice++;
		
		Choice toAdd = this.card.getTrickyChoice(super.whichChoice, prevChoice, this.game);
		if (toAdd != null){
			super.addChoiceToGroup(toAdd);
			return super.choices.get(super.whichChoice-1);
		} else {
			return null;
		}
	}
}
