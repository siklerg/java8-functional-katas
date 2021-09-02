package katas;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata2Test {

    @Test
    public void testExecute() {
        List<Integer> kataList2 = Kata2.execute();
        Assert.assertThat(kataList2.size(), equalTo(2));
    }
}
