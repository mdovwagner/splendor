import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private Bundle<Gem> gems = new Bundle<>();
    private Bundle<Gem> tableau = new Bundle<>();
    private List<Card> reserves = new ArrayList<>();
    private int points = 0;

    public Player(String name){
        this.name = name;
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
                	throw new Exception("Not enough gems");
                }
            	spentGems.addMultiple(Gem.WILD,deficit);
            }
            int spent = Integer.max(gemCost - tableau.amount(g) - deficit,0);
            System.out.println(g.toString() + " " + spent);
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

    @Override
    public String toString(){
        return "Player " + name + "\n\tPoints: "+  Integer.toString(points)+ "\n\tCards: " 
        		+ tableau + "\n\tGems: " + gems + "\n\tReserved: " + reserves;
    }

}
