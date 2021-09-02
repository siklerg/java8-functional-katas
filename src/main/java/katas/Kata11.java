package katas;

import com.google.common.collect.ImmutableMap;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {

    private static final List<Map<String, Object>> lists = DataUtil.getLists();
    private static final List<Map<String, Object>> videos = DataUtil.getVideos();
    private static final List<Map<String, Object>> boxArts = DataUtil.getBoxArts();
    private static final List<Map<String, Integer>> bookmarkList = DataUtil.getBookmarkList();

    private Kata11() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map<String, Object>> execute() {
        return lists.stream()
                .map(listsMap -> ImmutableMap.of(
                        "name", listsMap.get("name"),
                        "videos", getVideo((int) listsMap.get("id"))))
                .collect(Collectors.toList());
    }

    private static List<Map<String, Object>> getVideo(int listId) {
        return videos.stream()
                .filter(videoMap -> videoMap.get("listId").equals(listId))
                .map(videoMap -> ImmutableMap.of(
                        "id", videoMap.get("id"),
                        "title", videoMap.get("title"),
                        "time", getTime((int) videoMap.get("id")),
                        "boxart", getMinArtBoxUrl((int) videoMap.get("id"))))
                .collect(Collectors.toList());
    }

    private static int getTime(int videoId) {
        return bookmarkList.stream()
                .filter(bookmark -> bookmark.get("videoId").equals(videoId))
                .findFirst()
                .map(bookmark -> bookmark.get("time"))
                .orElseThrow(NoSuchElementException::new);
    }

    private static String getMinArtBoxUrl(int videoId) {
        return boxArts.stream()
                .filter(boxarts -> boxarts.get("videoId").equals(videoId))
                .reduce((a, b) -> (int) a.get("width") < (int) b.get("width") ? a : b)
                .map(boxArt -> boxArt.get("url").toString())
                .orElseThrow(NoSuchElementException::new);
    }
}

