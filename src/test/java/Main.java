import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


    @Test
    public void testPiles() throws Exception{
        Bundle<Gem> b = new Bundle<>();

        b.add(Gem.RED);
        b.add(Gem.RED);
        b.add(Gem.BROWN);
        b.add(Gem.BROWN);
        b.subtract(Gem.BROWN);
        b.addMultiple(Gem.BLUE,3);
        System.out.println(b.toString());
        System.out.println(b.toList().toString());

        Bundle<Gem> b2 = new Bundle<>(Gem.RED,Gem.GREEN,Gem.GREEN);
        System.out.println(b2);
        b2.subtract(Gem.RED);
        System.out.println(b2);

    }
    

    @Test
    public void testPlayers() throws Exception{
        Card c1 = new Card(Gem.BROWN,new Bundle<Gem>(Gem.RED,Gem.RED,Gem.RED),1);
        Card c2 = new Card(Gem.RED,new Bundle<Gem>(Gem.BROWN,Gem.GREEN),0);
        Card c3 = new Card(Gem.GREEN,new Bundle<Gem>(Gem.RED,Gem.BROWN),0);
        Player p1 = new Player("Michael");

        System.out.println(p1.toString());
        System.out.println("gets gems, Red, Red, Brown, Wild");
        p1.drawGems(new Bundle<Gem>(Gem.RED,Gem.BROWN,Gem.RED,Gem.WILD,Gem.WILD));
        System.out.println(p1.toString());

        System.out.println("Buys card 1");
        p1.buyCard(c1);
        System.out.println(p1.toString());

        System.out.println("gets gems, Green");
        p1.drawGems(new Bundle<Gem>(Gem.GREEN));
        System.out.println(p1.toString());

        System.out.println("Buys card 2");
        p1.buyCard(c2);
        System.out.println(p1.toString());

        System.out.println("Buys card 3");
        p1.buyCard(c3);
        System.out.println(p1.toString());


    }


}
