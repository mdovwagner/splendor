import java.util.*;

public class Game {

    private static final int GEM_NUMBER = 7;
    private List<Player> players = new ArrayList<>();
    private Bundle<Gem> gems = new Bundle<>();
    private List<Noble> nobles = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private int curr = 0;



    public Game(String[] playerNames) {
        // Add players
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        // Add gems
        for (Gem g: Gem.values()) gems.addMultiple(g,GEM_NUMBER);
        // Add cards
        // @Lewis plz do this


    }

    public void collectGems(List<Gem> chosen) throws Exception{
        if (new HashSet(chosen).size() == chosen.size() && chosen.size() == 2) {
            if (gems.amount(chosen.get(0)) >= 4) gems.subtractMultiple(chosen.get(0),2);
            else throw new Exception("Not enough to take 2 of the same");
        } else if (chosen.size() <= 3) {
            for (Gem g : chosen) {
                if (gems.amount(g) > 0) gems.subtract(g);
            }
        } else throw new Exception("Can't pick those gems");
        players.get(curr).drawGems(new Bundle(chosen));
    }

    public void buyCard(Card card) throws Exception {
        Bundle<Gem> spentGems = players.get(curr).buyCard(card);
        gems.subtractBundle(spentGems);
        // Add new card
    }



    private void nextPlayer(){
        curr = (curr + 1) % players.size();
    }


}
