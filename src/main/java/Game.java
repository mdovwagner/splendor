import java.util.*;

public class Game {

    private static final int GEM_NUMBER = 7;
    private List<Player> players = new ArrayList<>();
    private Bundle<Gem> gems = new Bundle<>();
    private List<Noble> nobles = new ArrayList<>();
    private List<Card> tier1 = new ArrayList<>();
    private List<Card> tier2 = new ArrayList<>();
    private List<Card> tier3 = new ArrayList<>();
    private Map<Card,Integer> display = new HashMap<>(); // Card -> tier

    private int curr = 0;


    private void addcards(){
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE),0));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.RED,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),1));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.BLACK),0));
        tier1.add(new Card(Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.GREEN,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED),1));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.GREEN,Gem.RED,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED),0));
        tier1.add(new Card(Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.RED,Gem.RED,Gem.RED),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),1));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.RED,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.GREEN),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.GREEN,Gem.BLACK),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.RED,Gem.RED),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE),1));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.GREEN,Gem.BLACK),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),1));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.RED),0));
        tier1.add(new Card(Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK),0));
        tier2.add(new Card(Gem.WHITE,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED),2));
        tier2.add(new Card(Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE),3));
        tier2.add(new Card(Gem.WHITE,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(Gem.WHITE,new Bundle<>(Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED,Gem.RED),1));
        tier2.add(new Card(Gem.WHITE,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),2));
        tier2.add(new Card(Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),3));
        tier2.add(new Card(Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),1));
        tier2.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE),2));
        tier2.add(new Card(Gem.GREEN,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),2));
        tier2.add(new Card(Gem.GREEN,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),3));
        tier2.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED),1));
        tier2.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLACK),2));
        tier2.add(new Card(Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN),2));
        tier2.add(new Card(Gem.RED,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(Gem.RED,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED),3));
        tier2.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN),2));
        tier2.add(new Card(Gem.RED,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(Gem.BLACK,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(Gem.BLACK,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier2.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN),1));
        tier2.add(new Card(Gem.BLACK,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED),2));
        tier2.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),2));
        tier3.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),5));
        tier3.add(new Card(Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE),4));
        tier3.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE),5));
        tier3.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),4));
        tier3.add(new Card(Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN),5));
        tier3.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN),4));
        tier3.add(new Card(Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(Gem.RED,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),4));
        tier3.add(new Card(Gem.RED,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),5));
        tier3.add(new Card(Gem.RED,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),4));
        tier3.add(new Card(Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(Gem.BLACK,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED),4));
        tier3.add(new Card(Gem.BLACK,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),5));
        tier3.add(new Card(Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),3));
    }



    public Game(String... playerNames) {
        // Add players
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        // Add gems
        for (Gem g: Gem.values()) gems.addMultiple(g,GEM_NUMBER);
        // Add cards
        addcards();
//        Collections.shuffle(tier1);
//        Collections.shuffle(tier2);
//        Collections.shuffle(tier3);
        for (int i = 0; i < 4; i++) {
            display.put(tier1.remove(0),1);
            display.put(tier2.remove(0),2);
            display.put(tier3.remove(0),3);
        }

    }

    public Map<Card,Integer> getDisplay(){
        return display;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void collectGems(List<Gem> chosen) throws Exception{
        if (new HashSet(chosen).size() == chosen.size() && chosen.size() == 2) {
            if (gems.amount(chosen.get(0)) >= 4) gems.subtractMultiple(chosen.get(0),2);
            else throw new Exception("Not enough to take 2 of the same");
        } else if (chosen.size() <= 3) { //@Michael don't we need to check they are all different
            for (Gem g : chosen) {
                if (gems.amount(g) > 0) gems.subtract(g);
            }
        } else throw new Exception("Can't pick those gems");
        players.get(curr).drawGems(new Bundle(chosen));
    }

    public void buyCard(Card card) throws Exception {
        if (!(display.keySet().contains(card))) throw new Exception("Card not in play");
        Bundle<Gem> spentGems = players.get(curr).buyCard(card);
        gems.subtractBundle(spentGems);
        // Add new card
        int tier = display.get(card);
        display.remove(card);
        if (tier == 1) display.put(tier1.remove(0),1);
        if (tier == 2) display.put(tier2.remove(0),2);
        if (tier == 3) display.put(tier3.remove(0),3);
        // bug: END OF GAME RUN OUT
    }

    public void reserveCard(Card card) throws Exception {

    }



    public void nextPlayer(){
        curr = (curr + 1) % players.size();
    }


}
