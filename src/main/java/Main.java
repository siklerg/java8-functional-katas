import katas.*;
import model.InterestingMoment;
import org.junit.Assert;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        testKata1();
        testKata2();
        testKata3();
        testKata4();
        testKata5();
        testKata6();
        testKata7();
        testKata8();
        testKata9();
        testKata10();
        testKata11();
        System.out.println("ALL DONE, you're a functional programming NINJA!");
    }

    private static void testKata1() {
        List<Map> kataMap1 = Kata1.execute();
        assertEquals(kataMap1.size(), 4);
        System.out.println("Kata 1 solved!");
    }

    private static void testKata2() {
        List<Integer> kataList2 = Kata2.execute();
        assertEquals(kataList2.size(), 2);
        System.out.println("Kata 2 solved!");
    }

    private static void testKata3() {
        List<Integer> kataList3 = Kata3.execute();
        assertEquals(kataList3.size(), 4);
        assertTrue(kataList3.containsAll(Arrays.asList(70111470, 654356453, 65432445, 675465)));
        System.out.println("Kata 3 solved!");

    }

    private static void testKata4() {
        List<Map> kataList4 = Kata4.execute();
        assertEquals(kataList4.size(), 4);
        System.out.println("Kata 4 solved!");
    }

    private static void testKata5() {
        Double kataResult5 = Kata5.execute();
        assertEquals(kataResult5, 5.0, 0.0);
        System.out.println("Kata 5 solved!");
    }

    private static void testKata6() {
        String kataResult6 = Kata6.execute();
        assertEquals(kataResult6, "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg");
        System.out.println("Kata 6 solved!");
    }

    private static void testKata7() {
        List<Map> kataList7 = Kata7.execute();
        assertEquals(kataList7.size(), 4);
        for (Map map : kataList7) {
            if (map.get("title").equals("Die Hard")) {
                assertEquals("http://cdn-0.nflximg.com/images/2891/DieHard150.jpg", map.get("boxart"));
                break;
            }
        }
        System.out.println("Kata 7 solved!");
    }

    private static void testKata8() {
        List<Map> kataList8 = Kata8.execute();
        assertEquals(kataList8.size(), 3);
        assertEquals(70111470, kataList8.get(0).get("videoId"));
        assertEquals(470, kataList8.get(0).get("bookmarkId"));
        System.out.println("Kata 8 solved!");
    }

    private static void testKata9() {
        List<Map> kataList9 = Kata9.execute();
        assertEquals(kataList9.size(), 4);
        for (Map map : kataList9) {
            if (map.get("title").equals("Die Hard")) {
                assertEquals("http://cdn-0.nflximg.com/images/2891/DieHard150.jpg", map.get("url"));
                break;
            }
        }
        System.out.println("Kata 9 solved!");
    }

    private static void testKata10() {
        List<Map> kataList10 = Kata10.execute();
        assertEquals(kataList10.size(), 2);

        for (Map map : kataList10) {
            if (map.get("name").equals("New Releases")) {
                List videos = (List) map.get("videos");
                Map map1 = (Map) videos.get(0);
                Map map2 = (Map) videos.get(1);
                assertTrue(map1.containsValue("The Chamber"));
                assertTrue(map2.containsValue("Fracture"));
                break;
            }
        }
        System.out.println("Kata 10 solved!");
    }

    private static void testKata11() {
        List<Map> kataList11 = Kata11.execute();
        for (Map map : kataList11) {
            if (map.get("name").equals("Thrillers")) {
                List videos = (List) map.get("videos");
                Map map1 = (Map) videos.get(0);
                Map map2 = (Map) videos.get(1);
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
        assertEquals(kataList11.size(), 2);



        System.out.println("Kata 11 solved!");
    }


}
