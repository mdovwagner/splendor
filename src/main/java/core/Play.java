package core;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Play {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(16);
//    private static final List<Integer> results = new CopyOnWriteArrayList<>();
    private static final Map<Network,Integer> results = new ConcurrentHashMap<>();
    private static final Map<Network,Integer> results2 = new ConcurrentHashMap<>();



    private static int runOneGame(Network network) {
        Game g = new Game(network,"Michael");
        while (!g.isGameOver()) {
            g = g.pickNextMove();
        }
        return g.getTurn();
    }
    
    private static List<Network> evolve(Map<Network,Integer> prevGen){
    	List<Network> newGen = new ArrayList<Network>();
    	int threshold = 0;
    	// pick out 25 best nets
    	while(newGen.size() < prevGen.size() / 4){
    		for(Map.Entry<Network, Integer> entry : prevGen.entrySet()) {
    			Network key = entry.getKey();
			    int value = entry.getValue();
			    if(value < threshold) newGen.add(key);
			}
    		threshold++;
    	}
    	// add 10 random nets 
    	int extraNets = 0;
    	Network[] prevGenArr = new Network[prevGen.size()];
    	prevGenArr = prevGen.keySet().toArray(prevGenArr);
    	Random rand = new Random();
    	while(extraNets < prevGen.size() / 10){
    		int i = rand.nextInt(prevGenArr.length);
    		if(!newGen.contains(prevGenArr[i])) newGen.add(prevGenArr[i]);
    		extraNets ++;
    	}
    	// mutate
    	for(Network n : newGen) n.mutate();
    	// fill in rest with children
    	int numParents = newGen.size();
    	int childrenNeeded = prevGen.size() - numParents;
    	for(int i = 0; i < childrenNeeded; i++){
    		// pick parents from beginning of list
    		Network father = newGen.get(rand.nextInt(numParents));
    		Network mother = newGen.get(rand.nextInt(numParents));
    		newGen.add(Network.breed(father,mother));
    	}
    	return newGen;
    }

    public static void main(String[] args) throws Exception {
        // First generation
    	long startTime = System.nanoTime();
//        ServerSocket socket = new ServerSocket(8000);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(()-> {
                Network network = new Network();
                results.put(network,runOneGame(network));
            });
        }
        while (results.size() < 100) {} // spins until everything is done;
        System.out.println(results.values().toString());
        // Second generation
        List<Network> secondGen = evolve(results); // This has size 100
        for (Network network : secondGen) {
            threadPool.submit(()-> {
                results2.put(network,runOneGame(network));
            });
        }
        while (results2.size() < 100) {} // this never hits 100
        System.out.println(results.values().toString());
        
        long endTime = System.nanoTime();
        System.out.println("Runtime: "+(endTime - startTime) / 1000000.0 + " ms");
        System.exit(0);
        



    }
}
