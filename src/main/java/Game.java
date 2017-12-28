import java.util.*;

public class Game {

	public static final Gem[] GEM_ORD = { Gem.RED, Gem.GREEN, Gem.BLUE, Gem.WHITE, Gem.BLACK };
    private static final int GEM_NUMBER = 4;
    private static final int NOBLES_NUMBER = 3;
    private static final int MAX_HAND_SIZE = 10;
    private List<Player> players = new ArrayList<>();
    private Bundle<Gem> gems = new Bundle<>();
    private List<Noble> nobles = new ArrayList<>();
    private List<Card> tier1 = new ArrayList<>();
    private List<Card> tier2 = new ArrayList<>();
    private List<Card> tier3 = new ArrayList<>();
    private List<Card> display = new ArrayList<>();

    private int curr = 0;


    private void addcards(){
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE),0));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.RED,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),1));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.GREEN,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED),1));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.GREEN,Gem.RED,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED),0));
        tier1.add(new Card(1,Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.RED,Gem.RED,Gem.RED),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.RED,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),1));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.RED,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.GREEN),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.GREEN,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.RED,Gem.RED),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE),1));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.GREEN,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.RED,new Bundle<>(Gem.WHITE,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),1));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.RED),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.RED),0));
        tier1.add(new Card(1,Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK),0));
        tier2.add(new Card(2,Gem.WHITE,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED),2));
        tier2.add(new Card(2,Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE),3));
        tier2.add(new Card(2,Gem.WHITE,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(2,Gem.WHITE,new Bundle<>(Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED,Gem.RED),1));
        tier2.add(new Card(2,Gem.WHITE,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),2));
        tier2.add(new Card(2,Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),3));
        tier2.add(new Card(2,Gem.BLUE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),1));
        tier2.add(new Card(2,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE),2));
        tier2.add(new Card(2,Gem.GREEN,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),2));
        tier2.add(new Card(2,Gem.GREEN,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),3));
        tier2.add(new Card(2,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(2,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED),1));
        tier2.add(new Card(2,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN),2));
        tier2.add(new Card(2,Gem.RED,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.RED,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED),3));
        tier2.add(new Card(2,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(2,Gem.RED,new Bundle<>(Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN),2));
        tier2.add(new Card(2,Gem.RED,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(2,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.BLACK,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),2));
        tier2.add(new Card(2,Gem.BLACK,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier2.add(new Card(2,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN),1));
        tier2.add(new Card(2,Gem.BLACK,new Bundle<>(Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED),2));
        tier2.add(new Card(2,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.BLACK,Gem.BLACK),1));
        tier2.add(new Card(2,Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),2));
        tier3.add(new Card(3,Gem.WHITE,new Bundle<>(Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(3,Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),5));
        tier3.add(new Card(3,Gem.WHITE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(3,Gem.WHITE,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(3,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE),4));
        tier3.add(new Card(3,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE),5));
        tier3.add(new Card(3,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(3,Gem.BLUE,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(3,Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE),4));
        tier3.add(new Card(3,Gem.GREEN,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN),5));
        tier3.add(new Card(3,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN),4));
        tier3.add(new Card(3,Gem.GREEN,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(3,Gem.RED,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN),4));
        tier3.add(new Card(3,Gem.RED,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),5));
        tier3.add(new Card(3,Gem.RED,new Bundle<>(Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),4));
        tier3.add(new Card(3,Gem.RED,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.BLACK,Gem.BLACK,Gem.BLACK),3));
        tier3.add(new Card(3,Gem.BLACK,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED),4));
        tier3.add(new Card(3,Gem.BLACK,new Bundle<>(Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),5));
        tier3.add(new Card(3,Gem.BLACK,new Bundle<>(Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.RED,Gem.BLACK,Gem.BLACK,Gem.BLACK),4));
        tier3.add(new Card(3,Gem.BLACK,new Bundle<>(Gem.WHITE,Gem.WHITE,Gem.WHITE,Gem.BLUE,Gem.BLUE,Gem.BLUE,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.GREEN,Gem.RED,Gem.RED,Gem.RED),3));
    }



    public Game(String... playerNames) {
        // Add players
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        // Add gems
        for (Gem g: GEM_ORD){
        	if(g.equals(Gem.WILD)) gems.addMultiple(g, 5);
        	else gems.addMultiple(g,GEM_NUMBER);        
        }
        // Add cards
        addcards();
        Random r = new Random(617489);
        Collections.shuffle(tier1,r);
        Collections.shuffle(tier2,r);
        Collections.shuffle(tier3,r);

        // add nobles;
        nobles.add(new Noble(3,new Bundle(Arrays.asList(Gem.BLACK,Gem.RED,Gem.GREEN),Arrays.asList(3,3,3))));
        nobles.add(new Noble(3,new Bundle(Arrays.asList(Gem.WHITE,Gem.BLACK),Arrays.asList(4,4))));
        nobles.add(new Noble(3,new Bundle(Arrays.asList(Gem.BLUE,Gem.WHITE),Arrays.asList(4,4))));


        for (int i = 0; i < 4; i++) {
            display.add(tier1.remove(0));
            display.add(tier2.remove(0));
            display.add(tier3.remove(0));
        }

    }

    public Game(Game other) {
        this.players = new ArrayList<>();
        for (Player p : other.players) this.players.add(new Player(p));
        this.gems = new Bundle<>(other.gems);
        this.nobles = new ArrayList<>();
        for (Noble n : other.nobles) this.nobles.add(new Noble(n));
        this.tier1 = new ArrayList<>();
        for (Card c : other.tier1) this.tier1.add(new Card(c));
        this.tier2 = new ArrayList<>();
        for (Card c : other.tier2) this.tier2.add(new Card(c));
        this.tier3 = new ArrayList<>();
        for (Card c : other.tier3) this.tier3.add(new Card(c));
        this.display = new ArrayList<>();
        for (Card c : other.display) this.display.add(new Card(c));
        this.curr = other.curr;
    }

    public List<Card> getDisplay(){
        return display;
    }
    
    public Bundle<Gem> getGems(){
    	return gems;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void collectGems(List<Gem> chosen) throws Exception{
        if (currPlayer().getGems().size() + chosen.size() > MAX_HAND_SIZE) throw new Exception("Can't hold that many gems");
    	if(chosen.contains(Gem.WILD)){
    		throw new Exception("Can't pick those gems");
    	} else if (new HashSet<Gem>(chosen).size() != chosen.size() && chosen.size() == 2) {
            if (gems.amount(chosen.get(0)) >= 4) gems.subtractMultiple(chosen.get(0),2);
            else throw new Exception("Not enough to take 2 of the same");
        } else if (new HashSet<Gem>(chosen).size() == chosen.size() && chosen.size() == 3) {
            for (Gem g : chosen) {
                if (gems.amount(g) > 0) gems.subtract(g);
                else throw new Exception("Not enough gems");
            }
        } else throw new Exception("Can't pick those gems");
        players.get(curr).drawGems(new Bundle<Gem>(chosen));
    }

    public void buyCard(Card card) throws Exception {
        if (!(display.contains(card)) && !(currPlayer().getReserves().contains(card))){
        	throw new Exception("Card not in play/reserves");
        }
        Bundle<Gem> spentGems = currPlayer().buyCard(card);
        gems.addBundle(spentGems);
        // Add new card
        if(display.contains(card)){
	        int tier = card.getTier();
            int i = display.indexOf(card);
            if (tier == 1) display.set(i,tier1.remove(0));
            if (tier == 2) display.set(i,tier2.remove(0));
            if (tier == 3) display.set(i,tier3.remove(0));
	        // bug: END OF GAME RUN OUT
        }
        // check if got nobles
        for (Noble n : nobles) {
            if (!n.isBoughtYet() && n.isConditionMet(players.get(curr).getTableau())) {
                players.get(curr).addPoints(n.points());
                n.buy();
                break; // can't get more than one
            }
        }
    }

    public void reserveCard(Card card) throws Exception {
    	if (!(display.contains(card))) throw new Exception("Card not in play");
    	players.get(curr).reserveCard(card);    	
    	if (gems.amount(Gem.WILD) > 0) {
    		gems.subtract(Gem.WILD);
    		players.get(curr).drawGems(new Bundle<Gem>(Arrays.asList(Gem.WILD)));
    	}
    	int tier = card.getTier();
        int i = display.indexOf(card);
        if (tier == 1) display.set(i,tier1.remove(0));
        if (tier == 2) display.set(i,tier2.remove(0));
        if (tier == 3) display.set(i,tier3.remove(0));
        // bug: END OF GAME RUN OUT
    }



    public void nextPlayer(){
        curr = (curr + 1) % players.size();
    }

    public Player currPlayer(){
        return players.get(curr);
    }


    public final List<Integer> getInputNodes() {
//        int[] nodes = new int[169]; // 166 is the number of nodes
        List<Integer> nodes = new ArrayList<>();
        // gems go red, green, blue, white, black
        // Order of nodes:
        //      handGems(5), handCards(5), handPoints(1), boardGems(5),  = 16
        //      boardCards(12 * gems(5), bonus(5), points(1)),           = 132
        //      nobles(3 * gems(5), points(1), boughtYet(1))             = 21

        // use curr player
        for (Gem g : GEM_ORD) nodes.add(currPlayer().getGems().amount(g));
        for (Gem g : GEM_ORD) nodes.add(currPlayer().getTableau().amount(g));
        nodes.add(currPlayer().getPoints());
        for (Gem g : GEM_ORD) nodes.add(gems.amount(g));
        for (Card c : display) {
            for (Gem g : GEM_ORD) nodes.add(c.cost().amount(g));
            for (Gem g : GEM_ORD) nodes.add(c.gem() == g ? 1:0); // only 1 if the bonus is that gem
            nodes.add(c.points());
        }
        for (Noble n : nobles) {
            for (Gem g : GEM_ORD) nodes.add(n.cost().amount(g));
            nodes.add(n.points());
            nodes.add(n.isBoughtYet() ? 1:0);
        }
        assert(nodes.size() == 169);
        return nodes;

    }

    public List<Game> getNextMoves() {
        // Returns copies of game for the next set of moves it can do.
        // There are 27 possible next moves
        //      10 = (5 choose 3) ways of picking 3 different colored gems,
        //      5 ways of picking 2 same colored gems
        //      12 cards to buy
        // We will try to do all of them, and if we raise an exception we'll skip it
        List<Game> moves = new ArrayList<>();
        for (int i = 0; i < GEM_ORD.length; i++) {
            for (int j = i+1; j < GEM_ORD.length; j++) {
                for (int k = j+1; k < GEM_ORD.length; k++) {
                    try {
                        Game g = new Game(this);
                        g.collectGems(Arrays.asList(GEM_ORD[i],GEM_ORD[j],GEM_ORD[k]));
                        moves.add(g);
                    } catch (Exception e){
//                        System.out.println(e);
                    }
                }
            }
        }
        for (Gem gem : GEM_ORD) {
            try {
                Game g = new Game(this);
                g.collectGems(Arrays.asList(gem,gem));
                moves.add(g);
            } catch (Exception e) {

            }
        }
        for (Card c : display) {
            try {
                Game g = new Game(this);
                g.buyCard(c);
                moves.add(g);
            } catch (Exception e) {

            }
        }
        return moves;
    }


}
