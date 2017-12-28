public class Noble {

    private Bundle<Gem> cost;
    private int points;

    public Noble(int points, Bundle<Gem> cost) {
        this.points = points;
        this.cost = cost;
    }

    public int getPoints() {
        return points;
    }

    public boolean isConditionMet(Bundle<Gem> handCards) {
        System.out.println(cost);
        for (Gem g : cost.keySet()) {
            if (cost.amount(g) > handCards.amount(g)) return false;
        }
        return true;
    }

}
