package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {

    private Kata8() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map<String, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        return StreamUtils.zip(
                        movies.stream(),
                        bookMarks.stream(),
                        createResponseMap())
                .collect(Collectors.toList());
    }

    private static BiFunction<Movie, Bookmark, Map<String, String>> createResponseMap() {
        return (a, b) -> ImmutableMap.of(
                "videoId", a.getId().toString(),
                "bookmarkId", b.getId().toString());
    }
}
