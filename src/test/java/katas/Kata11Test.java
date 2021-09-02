package katas;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Kata11Test {

    @Test
    public void testExecute() {

        List<Map<String, Object>> kataList11 = Kata11.execute();
        for (Map map : kataList11) {
            if (map.get("name").equals("Thrillers")) {
                List<Object> videos = (List<Object>) map.get("videos");
                ImmutableMap<String, Object> map1 = (ImmutableMap<String, Object>) videos.get(0);
                ImmutableMap<String, Object> map2 = (ImmutableMap<String, Object>) videos.get(1);
                assertTrue(map1.containsValue("Die Hard"));
                assertTrue(map1.containsValue("http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"));
                assertTrue(map1.containsValue(70111470));
                assertTrue(map1.containsValue(645243));
                assertTrue(map2.containsValue("Bad Boys"));
                assertTrue(map2.containsValue("http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"));
                assertTrue(map2.containsValue(654356453));
                assertTrue(map2.containsValue(984934));
                break;
            }
        }
        assertEquals(2, kataList11.size());
    }
}
