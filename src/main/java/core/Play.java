package core;

import java.net.ServerSocket;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Play {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(100);
//    private static final List<Integer> results = new CopyOnWriteArrayList<>();
    private static final Map<Network,Integer> results = new ConcurrentHashMap<>();



    private static int runOneGame(Network network) {
        Game g = new Game(network,"Michael");
        while (!g.isGameOver()) {
            g = g.pickNextMove();
        }
        return g.getTurn();
    }

    public static void main(String[] args) throws Exception {
        // First generation
//        ServerSocket socket = new ServerSocket(8000);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(()-> {
                Network network = new Network();
                results.put(network,runOneGame(network));
            });
        }
        while (results.size() < 100) {} // spins until everything is done;
        System.out.println(results.values().toString());
        System.exit(0);




    }
}
