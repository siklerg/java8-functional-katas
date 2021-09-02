package katas;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class Kata7Test {

    @Test
    public void testExecute() {
        List<Map> kataList7 = Kata7.execute();
        Assert.assertEquals(4, kataList7.size());
        for (Map map : kataList7) {
            if (map.get("title").equals("Die Hard")) {
                Assert.assertEquals("http://cdn-0.nflximg.com/images/2891/DieHard150.jpg", map.get("boxart"));
                break;
            }
        }
    }
}
