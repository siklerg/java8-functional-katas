package katas;

import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {

    private Kata1() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map<String, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies
                .stream()
                .map(movie -> ImmutableMap.of("id", movie.getId().toString(),  "title", movie.getTitle()))
                .collect(Collectors.toList());
    }
}
