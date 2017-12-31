package gui;
import core.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGameBoard();
        });
    }

    private static void createAndShowGameBoard() {

        // Create a game core and do any necessary setup.

        // Create the game UI and setup. You will need to write
        // your own GUI classes under the "gui" package.
        Game game = new Game(new Network(),"Michael");
        JFrame frame = new JFrame("Splendor");
        SplendorGui panel = new SplendorGui(game);
//        game.setGameListener(panel);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
