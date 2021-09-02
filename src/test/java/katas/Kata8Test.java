package katas;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class Kata8Test {

    @Test
    public void testExecute() {
        List<Map<String, String>> kataList8 = Kata8.execute();
        assertEquals(3, kataList8.size());
        if (!kataList8.get(0).isEmpty()) {
            assertEquals("70111470", kataList8.get(0).get("videoId"));
            assertEquals("470", kataList8.get(0).get("bookmarkId"));
        }
    }
}
