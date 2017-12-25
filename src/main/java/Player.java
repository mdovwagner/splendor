import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private Map<Gem,Integer> gems = new HashMap<>();
    private Map<Card,Integer> hand = new HashMap<>();
    private int points = 0;

    public Player(String name){
        this.name = name;
    }

    public void drawGems(List<Gem> newGems) {
        for (Gem g : newGems) {
            gems.putIfAbsent(g,0);
            gems.compute(g,(Gem x, Integer i)->i+1);
        }
    }

    private void addCard(Card card) {
        hand.putIfAbsent(card,0);
        hand.compute(card,(Card c,Integer i) -> i+1);
    }

    public Map<Gem,Integer> buyCard(Card card) throws NotEnoughGemsException {
        Map<Gem,Integer> spentGems = new HashMap<>();
        for (Gem g : card.getCost().keySet()) {
            int gemCost = card.getCost().get(g);
            if (gemCost > hand.get(g) + gems.get(g)) throw new NotEnoughGemsException(g);
            int spent = gemCost - hand.get(g);
            spentGems.put(g,spent);
            gems.compute(g,(Gem x, Integer i)-> i - spent);
        }
        return spentGems;
    }



}
