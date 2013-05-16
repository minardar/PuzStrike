import java.util.ArrayList;


public class PileBunker extends TrickyCard {
	public PileBunker() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.BROWN);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = true;
		this.cost = 0;
		this.name = "Pilebunker";
		this.imagePath = "/DeGray/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		Object choice = choices.get(0).getChoice().get(0);
		if (choice.equals("1")) {
			this.draw++;
		} else {
			Card card = (Card) choices.get(1).getChoice().get(0);
			Player player = game.getCurrentPlayer();
			player.lockedCards.add(card);
			player.hand.remove(card);
		}
		
		super.use(choices, game);
		for (int i = 0; i < game.getOpponents().size(); i++) {
			Player opp = (Player) game.getOpponentsObj().get(i);
			opp.gemPile[0]++;
		}
	}
	
	public ChoiceGroup getChoice(Game g) {
		TrickyChoiceGroup choices = new TrickyChoiceGroup(this, g);
		return choices;
	}
	
	public Card newCard() {
		return new PileBunker();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
	
	public Choice getTrickyChoice(int i, Choice choice, Game g) {
		switch(i){
		case 1:
			ArrayList<String> things = new ArrayList<String>();
			ArrayList<Object> thingObj = new ArrayList<Object>();
			things.add(g.names.getString("Draw"));
			thingObj.add("1");
			things.add(g.names.getString("Lock"));
			thingObj.add("2");
			Choice c1 = new Choice(g.choices.getString("object"), things, thingObj, 1);
			return c1;
		case 2:
			if (choice.getChoice().get(0) == "1") {
				return null;
			}
			ArrayList<String> cards = g.getHand(this);
			ArrayList<Object> cardObj = g.getHandObj(this);
			if(cards.isEmpty()){
				return null;
			}
			Choice c2 = new Choice(g.choices.getString("cardKeep"), cards, cardObj, 1);
			return c2;
		default:
			return null;
		}
	}
}
