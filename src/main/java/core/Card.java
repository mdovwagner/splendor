package core;

public class Card {
    private final Gem gem;
    private final Bundle<Gem> cost;
    private final int points;
    private final int tier;

    public Card(int tier, Gem gem, Bundle<Gem> cost, int points) {
        this.tier = tier;
        this.gem = gem;
        this.cost = cost;
        this.points = points;
    }

    public Card(Card other) {
        this.tier = other.tier;
        this.gem = other.gem;
        this.cost = other.cost;
        this.points = other.points;
    }

    public Gem gem() {
        return gem;
    }

    public int getTier() {
        return tier;
    }

    public Bundle<Gem> cost() {
        return cost;
    }

    public int points() {
        return points;
    }

    @Override
    public String toString() {
        return "|"+gem.toString() + ", Cost: " + cost.toString()+"|";
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Card)) return false;
        Card c = (Card) other;
        return (gem == c.gem && cost.equals(c.cost) && points == c.points);
    }

    @Override
    public int hashCode() {
        return gem.hashCode() + cost.hashCode() + points;
    }
}
