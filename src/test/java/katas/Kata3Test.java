package katas;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Kata3Test {

    @Test
    public void testExecute() {
        List<Integer> kataList3 = Kata3.execute();
        assertEquals(4, kataList3.size());
        assertTrue(kataList3.containsAll(Arrays.asList(70111470, 654356453, 65432445, 675465)));
    }
}
