package katas;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class Kata1Test {

    @Test
    public void testExecute() {
        List<Map<String, String>> kataMap1 = Kata1.execute();
        Assert.assertEquals(4, kataMap1.size());
    }
}
