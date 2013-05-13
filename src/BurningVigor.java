import java.util.ArrayList;


public class BurningVigor extends ParamCard {
	public BurningVigor() {
		this.cardColor = new ArrayList<CardColor>();
		cardColor.add(CardColor.RED);
		this.cardType = cardType.STAR;
		this.defense = false;
		this.opposing = false;
		this.cost = 0;
		this.name = "BurningVigor";
		this.imagePath = "/Jaina/" + name + ".png";
	}
	
	public void use(ArrayList<Choice> choices, Game game) {
		Player p = game.getCurrentPlayer();
		boolean found = false;
		for (int i = 0; i < p.hand.size(); i++) {
			if (p.hand.get(i) instanceof Wound && !found) {
				p.hand.remove(i);
				this.draw += 1;
				for (int j = 0; j < game.getOpponents().size(); j++) {
					Player opp = (Player) game.getOpponentsObj().get(j);
					opp.gemPile[0]++;
				}
				found = true;
			}
		}
		
		if (!found) {
			for (int i = 0; i < p.discard.size(); i++) {
				if (p.discard.get(i) instanceof Wound && !found) {
					p.discard.remove(i);
					this.draw += 1;
					for (int j = 0; j < game.getOpponents().size(); j++) {
						Player opp = (Player) game.getOpponentsObj().get(j);
						opp.gemPile[0]++;
					}
					found = true;
				}
			}
		}
		super.use(choices, game);
		found = false;
	}
	
	public ChoiceGroup getChoice(Game g) {
		return new ChoiceGroup();
	}
	
	public Card newCard() {
		return new BurningVigor();
	}
	
	public void setEqual(ParamCard card) {
		super.setEqual(card);
	}
}
