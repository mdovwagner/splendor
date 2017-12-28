import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final String name;
    private Bundle<Gem> gems = new Bundle<>();
    private Bundle<Gem> tableau = new Bundle<>();
    private List<Card> reserves = new ArrayList<>();
    private int points = 0;

    public Player(String name){
        this.name = name;
    }

    public Player(Player other){
        this.name = other.name;
        this.gems = new Bundle<>(other.gems);
        this.tableau = new Bundle<>(other.tableau);
        this.reserves  = new ArrayList<>();
        for (Card c : other.reserves) this.reserves.add(new Card(c));
        this.points = other.points;
    }

    public void drawGems(Bundle<Gem> newGems) {
        gems.addBundle(newGems);
    }

    private void addCard(Card card) {
        points += card.points();
        tableau.add(card.gem());
    }
    
    public List<Card> getReserves(){
    	return reserves;
    }

    public Bundle<Gem> buyCard(Card card) throws Exception {
        Bundle<Gem> spentGems = new Bundle<>();
        for (Gem g : card.cost().keySet()) {
            int wilds = gems.amount(Gem.WILD);
            int gemCost = card.cost().amount(g);
            int deficit = Integer.max(gemCost - (tableau.amount(g) + gems.amount(g)),0);
            if(deficit > 0){
            	if (deficit > wilds){            	
                	throw new Exception("Not enough gems for this card");
                }
            	spentGems.addMultiple(Gem.WILD,deficit);
            }
            int spent = Integer.max(gemCost - tableau.amount(g) - deficit,0);
            spentGems.addMultiple(g,spent);
        }
        addCard(card);
        if(reserves.contains(card)) reserves.remove(card);
        gems.subtractBundle(spentGems);
        return spentGems;
    }
    
	public void reserveCard(Card card) {
		reserves.add(card);
	}

    public Bundle<Gem> getTableau() {
        return tableau;
    }

    public Bundle<Gem> getGems() {
        return gems;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int p) {
        points += p;
    }

    @Override
    public String toString(){
        return "Player " + name + "\n\tPoints: "+  Integer.toString(points)+ "\n\tCards: " 
        		+ tableau + "\n\tGems: " + gems + "\n\tReserved: " + reserves;
    }

}
