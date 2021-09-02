package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    private Kata4() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map<String, Object>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream()
                .flatMap(createResponseMap())
                .collect(Collectors.toList());
    }

    private static Function<MovieList, Stream<Map<String, Object>>> createResponseMap() {
        return m -> m.getVideos().stream()
                .map(movie -> ImmutableMap.of(
                        "id", movie.getId(),
                        "title", movie.getTitle(),
                        "boxart", getBoxArt(movie)));
    }

    public static BoxArt getBoxArt(Movie movie) {
        BoxArt boxArt = movie.getBoxarts().stream()
                .filter(ba -> ba.getWidth() == 150)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        return boxArt;
    }
}
