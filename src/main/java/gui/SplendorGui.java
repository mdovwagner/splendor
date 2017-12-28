package gui;

import core.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SplendorGui extends JPanel {

    private Game splendor;
    private JLabel[] boardGemLabels ;
    private JLabel[] boardCardLabels;
    private JLabel[] handLabels;
    // controller
    private JButton step;

    public SplendorGui(Game splendor) {
        this.splendor = splendor;
        setLayout(new BorderLayout());
        // Board gems
        JPanel boardGems = initBoardGems();
        add(boardGems,BorderLayout.NORTH);
        // Board cards
        JPanel boardCards = initBoardCards();
        add(boardCards,BorderLayout.CENTER);
        // Hand points / gems / cards
        JPanel hand = initHand();
        add(hand,BorderLayout.SOUTH);
        // TODO Nobles

        // Controller
        JPanel controller = initController();
        add(controller,BorderLayout.WEST);

    }

    private void updateAll() {
        updateBoardGems();
        updateBoardCards();
        updateHand();
    }


    private JPanel initController(){
        JPanel controller = new JPanel();
        controller.setName("Controller");
        controller.setLayout(new GridLayout(1,1));
        step = new JButton("Step");
        step.addActionListener((e)-> {
            List<Game> nextMoves = splendor.getNextMoves();
            if (nextMoves.size() == 0) System.out.println("Out of Moves");
            Collections.shuffle(nextMoves);
            splendor = nextMoves.get(0);
            updateAll();
        });
        controller.add(step);
        return controller;
    }


    private JPanel initBoardGems() {
        JPanel boardGems = new JPanel();
        boardGemLabels = new JLabel[splendor.GEM_ORD.length];
        boardGems.setName("Board Gems");
        boardGems.setLayout(new GridLayout(1,splendor.GEM_ORD.length));
        for (int i = 0; i < splendor.GEM_ORD.length; i++) {
            Gem g = splendor.GEM_ORD[i];
            JLabel label = new JLabel();
            label.setForeground(gemColor(g));
            label.setFont(new Font("Arial",20,40));
            label.setText(Integer.toString(splendor.getGems().get(g)));
            boardGemLabels[i] = label;
            boardGems.add(label);
        }
        return boardGems;
    }

    private void updateBoardGems() {
        for (int i = 0; i < splendor.GEM_ORD.length; i++) {
            Gem g = splendor.GEM_ORD[i];
            boardGemLabels[i].setText(Integer.toString(splendor.getGems().amount(g)));
        }
    }

    private JPanel initBoardCards() {
        JPanel boardCards = new JPanel();
        boardCardLabels = new JLabel[12];
        boardCards.setName("Board Cards");
        boardCards.setLayout(new GridLayout(3,4));
        for (int i = 0; i < splendor.getDisplay().size(); i++) {
            Card c = splendor.getDisplay().get(i);
            JLabel label = new JLabel();
            label.setFont(new Font("Arial",20,16));
            String text = "Bonus: "+ c.points() + "; Cost: ";
            for (Gem g : c.cost().keySet()) text += g.toString().substring(0,3) +":"+ c.cost().get(g)+", ";
            label.setText(text);
            boardCardLabels[i] = label;
            boardCards.add(label);
        }
        return boardCards;
    }

    private void updateBoardCards() {
        for (int i = 0; i < splendor.getDisplay().size(); i++) {
            Card c = splendor.getDisplay().get(i);
            String text = "Bonus: "+ c.points() + "; Cost: ";
            for (Gem g : c.cost().keySet()) text += g.toString().substring(0,3) +":"+ c.cost().get(g)+", ";
            boardCardLabels[i].setText(text);
        }
    }

    private JPanel initHand() {
        JPanel hand = new JPanel();
        handLabels = new JLabel[11];
        hand.setName("Hand");
        hand.setLayout(new GridLayout(1,11));
        for (int i = 0; i < splendor.GEM_ORD.length; i++) {
            Gem g = splendor.GEM_ORD[i];
            JLabel label = new JLabel();
            label.setFont(new Font("Arial",20,32));
            label.setForeground(gemColor(g));
            label.setText("G"+Integer.toString(splendor.currPlayer().getGems().amount(g)));
            handLabels[i] = label;
            hand.add(label);
        }
        for (int i = splendor.GEM_ORD.length; i < splendor.GEM_ORD.length*2; i++) {
            Gem g = splendor.GEM_ORD[i-5];
            JLabel label = new JLabel();
            label.setFont(new Font("Arial",20,32));
            label.setForeground(gemColor(g));
            label.setText("C"+Integer.toString(splendor.currPlayer().getTableau().amount(g)));
            handLabels[i] = label;
            hand.add(label);
        }
        JLabel label = new JLabel();
        label.setFont(new Font("Arial",20,32));
        label.setText("P" + Integer.toString(splendor.currPlayer().getPoints()));
        handLabels[10] = label;
        hand.add(label);
        return hand;
    }

    private void updateHand() {
        for (int i = 0; i <splendor.GEM_ORD.length; i++) {
            Gem g = splendor.GEM_ORD[i];
            handLabels[i].setText("G"+Integer.toString(splendor.currPlayer().getGems().amount(g)));
        }
        for (int i = splendor.GEM_ORD.length; i < splendor.GEM_ORD.length*2; i++) {
            Gem g = splendor.GEM_ORD[i-5];
            handLabels[i].setText("C"+Integer.toString(splendor.currPlayer().getTableau().amount(g)));
        }
        handLabels[10].setText("P" + Integer.toString(splendor.currPlayer().getPoints()));
    }





    private Color gemColor(Gem g) {
        switch (g) {
            case RED: return Color.RED;
            case GREEN: return Color.GREEN;
            case BLUE: return Color.BLUE;
            case WHITE: return Color.LIGHT_GRAY;
            case BLACK: return Color.BLACK;
            case WILD: return Color.YELLOW;
            default: return Color.WHITE;
        }
    }
}
