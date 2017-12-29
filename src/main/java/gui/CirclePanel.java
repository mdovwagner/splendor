package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {
@Override
protected void paintComponent(Graphics g) {
    //Adding  super.paintComponent....  
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(4));
    //g2.setColor(Color.GRAY);
    g2.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}
