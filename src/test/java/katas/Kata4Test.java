package katas;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class Kata4Test {

    @Test
    public void testExecute() {
        List<Map<String, Object>> kataList4 = Kata4.execute();
        assertEquals(4, kataList4.size());
    }
}
