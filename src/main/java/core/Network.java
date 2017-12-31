package core;

import Jama.Matrix;

import java.util.Arrays;

/**
 * Network of 169 nodes -> 169 nodes -> 1 node
 * 1 bias input node connects to all the hidden nodes and the output node
 */
public class Network {
    private static final int INPUT_SIZE = 169; // 169 is the number of input nodes per game_state;
    private static final int HIDDEN_SIZE = 169;
    // init weights randomly
    public Matrix weights_1;  // from input -> hidden
    private Matrix weights_2; // from hidden -> output


    public Network() {
        weights_1 = Matrix.random(INPUT_SIZE,HIDDEN_SIZE);
        weights_2 = Matrix.random(HIDDEN_SIZE,1);
    }

    /**
     * Uses forward propogation to calculate the values of the NN
     * @param inputs rows: number of inputs, cols: number of nodes/input (169)
     * @return the matrix multiplication of inputs * weights
     */
    private Matrix forward(Matrix inputs) {
        // sums each weight for the hidden layer of nodes (nodes_2)
        // Then applies the sigmoid function element wise to each value
        Matrix nodes_2 = (inputs.times(weights_1));
//        System.out.println(Arrays.toString(nodes_2.getArray()[0]));

        Matrix outputs = (nodes_2.times(weights_2));
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

        Matrix outputNode = forward(inputs).transpose();
        assert(outputNode.getRowDimension() == 1);
        return outputNode.getArray()[0]; // it's a 2D array but only one row
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
