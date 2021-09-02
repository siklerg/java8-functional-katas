import katas.Kata1;
import katas.Kata10;
import katas.Kata11;
import katas.Kata2;
import katas.Kata3;
import katas.Kata4;
import katas.Kata5;
import katas.Kata6;
import katas.Kata7;
import katas.Kata8;
import katas.Kata9;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        assertEquals(Kata1.execute().size(), 4);
        System.out.println("Kata 1 solved!");

        assertEquals(Kata2.execute().size(), 2);
        System.out.println("Kata 2 solved!");

        assertEquals(Kata3.execute().size(), 4);
        System.out.println("Kata 3 solved!");

        assertEquals(Kata4.execute().size(), 4);
        System.out.println("Kata 4 solved!");

        assertEquals(Kata5.execute(), 5.0, 0.0);
        System.out.println("Kata 5 solved!");

        assertEquals(Kata6.execute(), "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg");
        System.out.println("Kata 6 solved!");

        assertEquals(Kata7.execute().size(), 4);
        System.out.println("Kata 7 solved!");

        assertEquals(Kata8.execute().size(), 3);
        System.out.println("Kata 8 solved!");

        assertEquals(Kata9.execute().size(), 4);
        System.out.println("Kata 9 solved!");

        assertEquals(Kata10.execute().size(), 2);
        System.out.println("Kata 10 solved!");

        assertEquals(Kata11.execute().size(), 2);
        System.out.println("Kata 11 solved!");

        logger.info("ALL DONE, you're a functional programming NINJA! - logger");
        System.out.println("ALL DONE, you're a functional programming NINJA!");
    }
}
