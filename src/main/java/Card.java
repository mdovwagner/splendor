import java.util.Map;

public class Card {
    private final Gem gem;
    private final Bundle<Gem> cost;
    private final int points;

    public Card(Gem gem, Bundle<Gem> cost, int points) {
        this.gem = gem;
        this.cost = cost;
        this.points = points;
    }

    public Gem gem() {
        return gem;
    }

    public Bundle<Gem> cost() {
        return cost;
    }

    public int points() {
        return points;
    }

    @Override
    public String toString() {
        return gem.toString() + ", Cost: " + cost.toString();
    }
}
