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

    public Map<Gem,Integer> buyCard(Card card) throws Exception {
        Bundle<Gem> spentGems = new Bundle<>();
        for (Gem g : card.cost().keySet()) {
            int gemCost = card.cost().amount(g);
            if (gemCost > hand.amount(g) + gems.amount(g)) throw new Exception("Not enough gems");
            int spent = gemCost - hand.amount(g);
            spentGems.addMultiple(g,spent);
            gems.addMultiple(g,-spent);
        }
        addCard(card);
        return spentGems;
    }

    @Override
    public String toString(){
        return "Player " + name + "\n\tPoints: "+  Integer.toString(points)+ "\n\tCards: " + hand + "\n\tGems: " + gems;
    }



}
