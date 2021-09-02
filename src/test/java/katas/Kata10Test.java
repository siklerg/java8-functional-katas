package katas;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Kata10Test {

    @Test
    public void testExecute() {

        List<Map<String, Object>> kataList10 = Kata10.execute();
        assertEquals(2, kataList10.size());

        for (Map<String, Object> map : kataList10) {
            if (map.get("name").equals("New Releases")) {
                List<Object> videos = (List<Object>) map.get("videos");
                Map<String, String> map1 = (Map<String, String>) videos.get(0);
                Map<String, String> map2 = (Map<String, String>) videos.get(1);
                assertTrue(map1.containsValue("The Chamber"));
                assertTrue(map2.containsValue("Fracture"));
                break;
            }
        }
    }
}
