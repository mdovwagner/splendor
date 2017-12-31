package core;

import Jama.Matrix;

import java.util.Arrays;
import java.util.Random;

/**
 * Network of 169 nodes -> 60 nodes -> 1 node
 * 1 bias input node connects to all the hidden nodes and the output node
 */
public class Network {
    private static final int INPUT_SIZE = 169; // 169 is the number of input nodes per game_state;
    private static final int HIDDEN_SIZE = 60;
    private static final double MUTATION_CHANCE = 0.9;
    // init weights randomly
    public Matrix weights_1;  // from input -> hidden
    private Matrix weights_2; // from hidden -> output


    public Network() {
    	// Add 1 for bias weights
        weights_1 = Matrix.random(INPUT_SIZE + 1,HIDDEN_SIZE);
        weights_2 = Matrix.random(HIDDEN_SIZE + 1,1);
    }
    
    public Network(Network n){
    	weights_1 = n.weights_1;
    	weights_2 = n.weights_2;
    }

    /**
     * Uses forward propogation to calculate the values of the NN
     * @param inputs rows: number of inputs, cols: number of nodes/input (169)
     * @return the matrix multiplication of inputs * weights
     */
    private Matrix forward(Matrix inputs) {
        // sums each weight for the hidden layer of nodes (nodes_2) with bias
        Matrix nodes_2 = (inputs.times(weights_1));
        // adds column of 1s to add constant bias to output
        Matrix nodes_2WithOnes = addOnesColumn(nodes_2);
        Matrix outputs = (nodes_2WithOnes.times(weights_2));
//        System.out.println(Arrays.toString(outputs.getArray()[0]));
        return outputs;

    }

    /**
     * Apply's the NN on an array of input nodes, returning the output node.
     * @param inputNodes the first layer of nodes for each possible move
     * @return the output nodes for the next possible moves
     */
    public double[] apply(double[][] inputNodes) {
        // TODO add bias nodes...
        Matrix inputs = new Matrix(inputNodes);
        // Add constant column of 1s
        Matrix inputsWithOnes = addOnesColumn(inputs);
        Matrix outputNode = forward(inputsWithOnes).transpose();
        assert(outputNode.getRowDimension() == 1);
        return outputNode.getArray()[0]; // it's a 2D array but only one row
    }

    private Matrix addOnesColumn(Matrix z){
    	double[][] out = new double[z.getRowDimension()][z.getColumnDimension() + 1];
    	for(int i = 0; i < z.getRowDimension(); i++){
    		for(int j = 0; j < z.getColumnDimension(); j++){
    			out[i][j] = z.getArray()[i][j];
    		}
    		out[i][z.getColumnDimension()] = 1;
    	}
    	return new Matrix(out);
    }
    
    public static Network breed(Network father, Network mother){
    	Network child = new Network();
    	Random rand = new Random();
    	for(int i = 0; i < INPUT_SIZE + 1; i ++){
    		for(int j = 0; j < HIDDEN_SIZE; j ++){
    			Boolean mix = rand.nextBoolean();
    			if(mix){ // mix arbitrarily half the time
    				double t = rand.nextDouble();
    				child.weights_1.getArray()[i][j] = t * mother.weights_1.getArray()[i][j] + 
    						(1-t) * father.weights_1.getArray()[i][j];
    			}
    			else{ // pick one parent half the time
    				Boolean parent = rand.nextBoolean();
    				if(parent) child.weights_1.getArray()[i][j] = mother.weights_1.getArray()[i][j];
    				else child.weights_1.getArray()[i][j] = father.weights_1.getArray()[i][j];
    			}
    		}
    	}
    	for(int i = 0; i < HIDDEN_SIZE + 1; i ++){
    		Boolean mix = rand.nextBoolean();
    		if(mix){ // mix arbitrarily half the time
    			double t = rand.nextDouble();
    			child.weights_2.getArray()[i][0] = t * mother.weights_2.getArray()[i][0] + 
    					(1-t) * father.weights_2.getArray()[i][0];
    		}
    		else{ // pick one parent half the time
    			Boolean parent = rand.nextBoolean();
    			if(parent) child.weights_2.getArray()[i][0] = mother.weights_2.getArray()[i][0];
    			else child.weights_2.getArray()[i][0] = father.weights_2.getArray()[i][0];
    		}
    	}
        return child;
    }
    
    public void mutate(){
    	Random rand = new Random();
    	for(int i = 0; i < INPUT_SIZE + 1; i ++){
    		for(int j = 0; j < HIDDEN_SIZE; j ++){
    			double mutationPercent = rand.nextDouble();
    			// Mutate 10%
    			if(mutationPercent > MUTATION_CHANCE){
    				double mutationAmt = rand.nextDouble();
    				// Mutate so it is still has same expected value
    				weights_1.getArray()[i][j] = mutationAmt * 2 * weights_1.getArray()[i][j];
    			}
    		}
    	}
    	for(int i = 0; i < HIDDEN_SIZE + 1; i ++){
    		double mutationPercent = rand.nextDouble();
			// Mutate 10%
			if(mutationPercent > MUTATION_CHANCE){
				double mutationAmt = rand.nextDouble();
				// Mutate so it is still has same expected value
				weights_2.getArray()[i][0] = mutationAmt * 2 * weights_2.getArray()[i][0];
			}
    	}
    }
    
    private Matrix sigmoid(Matrix z) {
        Matrix n = new Matrix(z.getRowDimension(),z.getColumnDimension());
        for(int row = 0; row < z.getRowDimension(); row ++) {
            for (int col = 0; col < z.getColumnDimension(); col++) {
                n.set(row,col,1/(1+Math.exp(-z.get(row,col))));
            }
        }
        return n;
    }

}
