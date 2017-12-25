import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private Bundle<Gem> gems = new Bundle<>();
    private Bundle<Gem> hand = new Bundle<>();
    private int points = 0;

    public Player(String name){
        this.name = name;
    }

    public void drawGems(Bundle<Gem> newGems) {
        gems.addBundle(newGems);
    }

    private void addCard(Card card) {
        points += card.points();
        hand.add(card.gem());
    }

    public Bundle<Gem> buyCard(Card card) throws Exception {
        Bundle<Gem> spentGems = new Bundle<>();
        for (Gem g : card.cost().keySet()) {
            int wilds = gems.amount(Gem.WILD);
            int gemCost = card.cost().amount(g);
            int deficit = gemCost - (hand.amount(g) + gems.amount(g));       
            if(deficit > 0){
            	if (deficit > wilds){            	
                	throw new Exception("Not enough gems");
                }
            	spentGems.addMultiple(Gem.WILD,deficit);
            }
            int spent = Integer.max(gemCost - hand.amount(g) - deficit,0);
            System.out.println(g.toString() + " " + spent);
            spentGems.addMultiple(g,spent);
        }
        addCard(card);
        gems.subtractBundle(spentGems);
        return spentGems;
    }

    @Override
    public String toString(){
        return "Player " + name + "\n\tPoints: "+  Integer.toString(points)+ "\n\tCards: " + hand + "\n\tGems: " + gems;
    }



}
