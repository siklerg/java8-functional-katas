package katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Kata6Test {

    @Test
    public void testExecute() {
        String kataResult6 = Kata6.execute();
        assertEquals("http://cdn-0.nflximg.com/images/2891/Fracture300.jpg", kataResult6);
    }
}
