import java.util.Map;

public class Card {
    private final Gem gem;
    private final Map<Gem,Integer> cost;

    public Card(Gem gem, Map<Gem,Integer> cost) {
        this.gem = gem;
        this.cost = cost;
    }

    public Gem getGem() {
        return gem;
    }

    public Map<Gem,Integer> getCost() {
        return cost;
    }
}
