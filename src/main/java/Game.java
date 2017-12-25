import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private static final int GEM_NUMBER = 7;
    private List<Player> players = new ArrayList<>();
    private Map<Gem,Integer> gems = new HashMap<>();
    private List<Noble> nobles = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private int curr = 0;



    public Game(String[] playerNames) {
        // Add players
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        // Add gems
        for (Gem g: Gem.values()) gems.put(g,GEM_NUMBER);
        // Add cards
        // @Lewis plz do this


    }

    public void collectGems(List<Gem> chosen) {
        if (chosen.size() == 3) {
            for (Gem g : chosen) {
//                if (gems.get(g) > 0) gems.
            }
        } else if (chosen.size() == 2) {

        }
    }


    private void nextPlayer(){
        curr = (curr + 1) % players.size();
    }


}
