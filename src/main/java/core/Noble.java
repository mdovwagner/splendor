package core;

public class Noble {

    private final Bundle<Gem> cost;
    private final int points;
    private boolean boughtYet;

    public Noble(int points, Bundle<Gem> cost) {
        this.points = points;
        this.cost = cost;
        this.boughtYet = false;
    }

    public Noble(Noble other) {
        this.points = other.points;
        this.cost = other.cost;
        this.boughtYet = other.boughtYet;
    }

    public int points() {
        return points;
    }

    public boolean isBoughtYet() {
        return boughtYet;
    }

    public void buy() {
        boughtYet = true;
    }

    public Bundle<Gem> cost() {
        return cost;
    }

    public boolean isConditionMet(Bundle<Gem> handCards) {
        for (Gem g : cost.keySet()) {
            if (cost.amount(g) > handCards.amount(g)) return false;
        }
        return true;
    }

}
