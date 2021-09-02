package katas;

import com.google.common.collect.ImmutableMap;
import util.DataUtil;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {

    private Kata10() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map<String, Object>> execute() {
        List<Map<String, Object>> lists = DataUtil.getLists();
        List<Map<String, Object>> videos = DataUtil.getVideos();

        return lists.stream()
                .map(createResponseList(videos))
                .collect(Collectors.toList());
    }

    private static Function<Map<String, Object>, ImmutableMap<String, Object>> createResponseList(List<Map<String, Object>> videos) {
        return listsMap -> ImmutableMap.of(
                "name", listsMap.get("name"),
                "videos", getVideosForList(listsMap, videos));
    }

    private static List<Map<String, Object>> getVideosForList(Map<String, Object> listsMap, List<Map<String, Object>> videos){
        return videos.stream()
                .filter(videosMap -> videosMap.get("listId").equals(listsMap.get("id")))
                .map(videoMap -> ImmutableMap.of(
                        "id", videoMap.get("id"),
                        "title", videoMap.get("title")))
                .collect(Collectors.toList());
    }
}
