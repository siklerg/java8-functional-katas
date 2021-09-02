package katas;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class Kata9Test {

    @Test
    public void testExecute() {

        List<Map<String, Object>> kataList9 = Kata9.execute();
        assertEquals(4, kataList9.size());
        for (Map<String, Object> map : kataList9) {
            if (map.get("title").equals("Die Hard")) {
                assertEquals("http://cdn-0.nflximg.com/images/2891/DieHard150.jpg", map.get("url"));
                break;
            }
        }
    }
}
