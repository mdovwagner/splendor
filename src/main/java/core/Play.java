package core;

public class Play {



    private static int runGame(Network network) {
        Game g = new Game(network,"Michael");
        while (!g.isGameOver()) {
            g = g.pickNextMove();
        }
        return g.getTurn();
    }

    public static void main(String[] args) {
        System.out.println("hello");
        // First generation
        for (int i = 0; i < 100; i++) {
            Network network = new Network();
            System.out.println(runGame(network));
        }




    }
}
