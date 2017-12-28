package gui;

import core.*;

import javax.swing.*;
import javax.swing.border.Border;

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
    private JLabel turns;

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
        updateController();
    }


    private JPanel initController(){
        JPanel controller = new JPanel();
        controller.setName("Controller");
        controller.setLayout(new GridLayout(2,1));
        step = new JButton("Step");
        step.addActionListener((e)-> {
            List<Game> nextMoves = splendor.getNextMoves();
            if (nextMoves.size() == 0) System.out.println("Out of Moves");
            Collections.shuffle(nextMoves);
            splendor = nextMoves.get(0);
            updateAll();
        });
        controller.add(step);
        turns = new JLabel();
        turns.setFont(new Font("Arial",20,20));
        turns.setText("Turn: "+Integer.toString(splendor.getTurn()));
        controller.add(turns);
        return controller;
    }

    private void updateController(){
        turns.setText("Turn: "+Integer.toString(splendor.getTurn()));
    }
    
    private JPanel createCard(Color c, int bonus, int[] cost){
    	JPanel card = new JPanel(new GridLayout(5,3));
    	card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	JLabel bonusLabel = new JLabel(bonus + "");
    	bonusLabel.setFont(new Font("Arial",20,40));
    	bonusLabel.setForeground(c);
    	for(int i = 0; i <5; i ++){
    		if(i==0) card.add(bonusLabel);
    		else card.add(new JLabel());
    		card.add(new JLabel());
    		JLabel costLabel = new JLabel(cost[i] + "");
    		costLabel.setForeground(gemColor(Game.GEM_ORD[i]));
    		costLabel.setFont(new Font("Arial",20,40));
    		card.add(costLabel);
    	}
    	return card;
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
            int[] cost = new int[5];
            for(int j = 0; j < 5; j ++){
            	cost[j] = c.cost().amount(Game.GEM_ORD[j]);
            }
            boardCards.add(createCard(gemColor(c.gem()), c.points(), cost));
        }
        return boardCards;
    }

    private void updateBoardCards() {
    	add(initBoardCards(),BorderLayout.CENTER);
    }

    private JPanel initHand() {
        JPanel hand = new JPanel();
        handLabels = new JLabel[11];
        hand.setName("Hand");
        GridLayout handLayout = new GridLayout(1,11);
        handLayout.setHgap(50);
        hand.setLayout(handLayout);
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
            case GREEN: return new Color(0,102,0);
            case BLUE: return Color.BLUE;
            case WHITE: return Color.LIGHT_GRAY;
            case BLACK: return Color.BLACK;
            case WILD: return Color.YELLOW;
            default: return Color.WHITE;
        }
    }
}
