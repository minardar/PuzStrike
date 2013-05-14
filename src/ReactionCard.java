import java.util.ArrayList;


public abstract class ReactionCard extends TrickyCard {

	public abstract void react(Card card, Player reacting, ArrayList<Choice> choices, Game game);

	public abstract boolean canReactTo(Card card);
	
	public abstract ChoiceGroup getReactChoices(Game g, Player p);
}
