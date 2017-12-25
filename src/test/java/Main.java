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
        b.add(Gem.BLACK);
        b.add(Gem.BLACK);
        b.subtract(Gem.BLACK);
        b.addMultiple(Gem.BLUE,3);
        System.out.println(b.toString());
        System.out.println(b.toList().toString());

        Bundle<Gem> b2 = new Bundle(Gem.RED,Gem.GREEN,Gem.GREEN);
        System.out.println(b2);
        b2.subtract(Gem.RED);
        System.out.println(b2);

    }
    @Test
    public void testPlayers() throws Exception{
        Player p1 = new Player("Michael");
        Card c1 = new Card(Gem.BLACK,new Bundle(Gem.RED,Gem.RED),1);
        System.out.println(c1.toString());
        p1.drawGems(new Bundle(Gem.RED,Gem.BLACK,Gem.RED));
        System.out.println(p1.toString());
        p1.buyCard(c1);
        System.out.println(p1.toString());


    }


}
