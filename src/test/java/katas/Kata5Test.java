package katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Kata5Test {

    @Test
    public void testExecute() {
        Double kataResult5 = Kata5.execute();
        assertEquals(5.0, kataResult5, 0.0);
    }
}
